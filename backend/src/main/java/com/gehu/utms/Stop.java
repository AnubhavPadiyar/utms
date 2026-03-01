package com.gehu.utms;

import jakarta.persistence.*;

@Entity
@Table(name = "stops")
public class Stop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String corridor;

    public Stop() {}

    public Stop(String name, String corridor) {
        this.name = name;
        this.corridor = corridor;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCorridor() { return corridor; }
}