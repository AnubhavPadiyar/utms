package com.gehu.utms;

import jakarta.persistence.*;

@Entity
@Table(name = "route_stops")
public class RouteStop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int busNumber;
    private String stopName;
    private int stopOrder;

    public RouteStop() {}

    public RouteStop(int busNumber, String stopName, int stopOrder) {
        this.busNumber = busNumber;
        this.stopName = stopName;
        this.stopOrder = stopOrder;
    }

    public int getId() { return id; }
    public int getBusNumber() { return busNumber; }
    public String getStopName() { return stopName; }
    public int getStopOrder() { return stopOrder; }
}
