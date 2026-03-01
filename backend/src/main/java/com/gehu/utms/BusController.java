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

    // Report a delay and get BFS result
    @PostMapping("/delay")
    public Map<String, Object> reportDelay(@RequestBody Map<String, Object> request) {
        String stopName = (String) request.get("stopName");
        int delayMinutes = (int) request.get("delayMinutes");
        String reason = (String) request.get("reason");
        return bfsService.analyzeDelay(stopName, delayMinutes, reason);
    }
}