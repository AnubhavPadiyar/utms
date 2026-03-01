package com.gehu.utms;

import jakarta.persistence.*;

@Entity
@Table(name = "buses")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int busNumber;
    private String regNumber;
    private String departureTime;
    private boolean hasSecondShift;
    private String corridor;
    private String startStop;

    public Bus() {}

    public Bus(int busNumber, String regNumber, String departureTime, boolean hasSecondShift, String corridor, String startStop) {
        this.busNumber = busNumber;
        this.regNumber = regNumber;
        this.departureTime = departureTime;
        this.hasSecondShift = hasSecondShift;
        this.corridor = corridor;
        this.startStop = startStop;
    }

    public int getId() { return id; }
    public int getBusNumber() { return busNumber; }
    public String getRegNumber() { return regNumber; }
    public String getDepartureTime() { return departureTime; }
    public boolean isHasSecondShift() { return hasSecondShift; }
    public String getCorridor() { return corridor; }
    public String getStartStop() { return startStop; }
}