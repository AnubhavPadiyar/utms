package com.gehu.utms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class BusController {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private StopRepository stopRepository;

    @Autowired
    private RouteStopRepository routeStopRepository;

    @Autowired
    private BfsService bfsService;

    // Get all buses
    @GetMapping("/buses")
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    // Get all stops
    @GetMapping("/stops")
    public List<Stop> getAllStops() {
        return stopRepository.findAll();
    }

    // Get route stops for a specific bus
    @GetMapping("/routes/{busNumber}")
    public List<RouteStop> getRouteForBus(@PathVariable int busNumber) {
        return routeStopRepository.findByBusNumber(busNumber);
    }

    // Report a delay and get BFS result
    @PostMapping("/delay")
    public Map<String, Object> reportDelay(@RequestBody Map<String, Object> request) {
        String stopName = (String) request.get("stopName");
        int delayMinutes = (int) request.get("delayMinutes");
        String reason = (String) request.get("reason");
        int busNumber = request.get("busNumber") != null ? (int) request.get("busNumber") : 0;
        return bfsService.analyzeDelay(stopName, delayMinutes, reason, busNumber);
    }
}