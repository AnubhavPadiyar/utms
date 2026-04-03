package com.gehu.utms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BfsService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteStopRepository routeStopRepository;

    public Map<String, Object> analyzeDelay(String delayedStopName, int delayMinutes, String reason, int busNumber) {
        Map<String, Object> result = new HashMap<>();

        boolean isVehicleIssue = reason != null && reason.equalsIgnoreCase("Vehicle Issue");

        if (isVehicleIssue) {
            // Only specific bus affected
            List<Bus> affectedBuses = busRepository.findAll().stream()
                .filter(b -> b.getBusNumber() == busNumber)
                .collect(Collectors.toList());

            // All other buses are alternates
            List<Bus> alternateBuses = busRepository.findAll().stream()
                .filter(b -> b.getBusNumber() != busNumber)
                .collect(Collectors.toList());

            result.put("delayedStop", delayedStopName);
            result.put("delayMinutes", delayMinutes);
            result.put("reason", reason);
            result.put("isVehicleIssue", true);
            result.put("affectedBuses", affectedBuses);
            result.put("affectedStops", List.of(delayedStopName));
            result.put("alternateBuses", alternateBuses);
            result.put("message", "Vehicle issue on Bus " + busNumber +
                ". Only this bus is affected. " +
                alternateBuses.size() + " alternate buses available.");
            return result;
        }

        // TRAFFIC/ACCIDENT/WEATHER — Smart BFS with stop order
        // Step 1 — Find all buses that pass through delayed stop
        List<RouteStop> routeStopsAtDelay = routeStopRepository.findByStopName(delayedStopName);
        Set<Integer> affectedBusNumbers = routeStopsAtDelay.stream()
            .map(RouteStop::getBusNumber)
            .collect(Collectors.toSet());

        List<Bus> affectedBuses = busRepository.findAll().stream()
            .filter(b -> affectedBusNumbers.contains(b.getBusNumber()))
            .collect(Collectors.toList());

        // Step 2 — Find affected stops (stops AFTER delay point on each affected bus)
        Set<String> affectedStopNames = new HashSet<>();
        affectedStopNames.add(delayedStopName);

        for (int affectedBusNum : affectedBusNumbers) {
            RouteStop delayPoint = routeStopRepository
                .findByBusNumberAndStopName(affectedBusNum, delayedStopName);
            if (delayPoint != null) {
                List<RouteStop> stopsAfter = routeStopRepository
                    .findByBusNumberAndStopOrderGreaterThan(affectedBusNum, delayPoint.getStopOrder());
                stopsAfter.forEach(rs -> affectedStopNames.add(rs.getStopName()));
            }
        }

        // Step 3 — Find safe alternate buses
        // A bus is safe if it NEVER passes through the delayed stop
        List<Bus> alternateBuses = busRepository.findAll().stream()
            .filter(b -> !affectedBusNumbers.contains(b.getBusNumber()))
            .collect(Collectors.toList());

        // Step 4 — For each affected stop, find which alternate buses serve it
        Map<String, List<Integer>> alternatesPerStop = new HashMap<>();
        for (String stop : affectedStopNames) {
            if (stop.equals("GEU") || stop.equals(delayedStopName)) continue;
            List<Integer> busesAtStop = new ArrayList<>();
            for (Bus altBus : alternateBuses) {
                RouteStop rs = routeStopRepository
                    .findByBusNumberAndStopName(altBus.getBusNumber(), stop);
                if (rs != null) busesAtStop.add(altBus.getBusNumber());
            }
            if (!busesAtStop.isEmpty()) {
                alternatesPerStop.put(stop, busesAtStop);
            }
        }

        result.put("delayedStop", delayedStopName);
        result.put("delayMinutes", delayMinutes);
        result.put("reason", reason);
        result.put("isVehicleIssue", false);
        result.put("affectedBuses", affectedBuses);
        result.put("affectedStops", new ArrayList<>(affectedStopNames));
        result.put("alternateBuses", alternateBuses);
        result.put("alternatesPerStop", alternatesPerStop);
        result.put("message", "Traffic delay at " + delayedStopName + ". " +
            affectedBuses.size() + " buses affected. " +
            alternateBuses.size() + " alternate buses available.");

        return result;
    }
}