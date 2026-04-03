package com.gehu.utms;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RouteStopRepository extends JpaRepository<RouteStop, Integer> {
    List<RouteStop> findByBusNumber(int busNumber);
    List<RouteStop> findByStopName(String stopName);
    RouteStop findByBusNumberAndStopName(int busNumber, String stopName);
    List<RouteStop> findByBusNumberAndStopOrderGreaterThan(int busNumber, int stopOrder);
}