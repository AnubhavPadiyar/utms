package com.gehu.utms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BfsService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private StopRepository stopRepository;

    public Map<String, Object> analyzeDelay(String delayedStopName, int delayMinutes, String reason) {
        Map<String, Object> result = new HashMap<>();

        // Step 1 — Find the delayed stop
        Stop delayedStop = stopRepository.findByName(delayedStopName);
        if (delayedStop == null) {
            result.put("error", "Stop not found");
            return result;
        }

        String affectedCorridor = delayedStop.getCorridor();
        boolean isVehicleIssue = reason != null && reason.equalsIgnoreCase("Vehicle Issue");

        List<Bus> affectedBuses;
        List<Stop> affectedStops;
        List<Bus> alternateBuses;

        if (isVehicleIssue) {
            // Only the specific bus at that stop is affected
            // Find buses that START from this stop
            affectedBuses = busRepository.findByStartStop(delayedStopName);

            // Only the delayed stop itself is affected
            affectedStops = new ArrayList<>();
            affectedStops.add(delayedStop);

            // All other buses on ANY corridor are alternates
            alternateBuses = busRepository.findAll();
            alternateBuses.removeAll(affectedBuses);

            result.put("message", "Vehicle issue at " + delayedStopName + ". Only " +
                affectedBuses.size() + " bus(es) directly affected. " +
                alternateBuses.size() + " alternate buses available on all corridors.");
        } else {
            // Traffic/Accident/Weather — BFS spreads across whole corridor
            affectedBuses = busRepository.findByCorridor(affectedCorridor);
            affectedStops = stopRepository.findByCorridor(affectedCorridor);
            alternateBuses = busRepository.findByCorridorNot(affectedCorridor);

            result.put("message", "Bus delay detected on " + affectedCorridor +
                ". " + affectedBuses.size() + " buses affected. " +
                alternateBuses.size() + " alternate buses available.");
        }

        result.put("delayedStop", delayedStopName);
        result.put("delayMinutes", delayMinutes);
        result.put("reason", reason);
        result.put("isVehicleIssue", isVehicleIssue);
        result.put("affectedCorridor", affectedCorridor);
        result.put("affectedBuses", affectedBuses);
        result.put("affectedStops", affectedStops);
        result.put("alternateBuses", alternateBuses);

        return result;
    }
}