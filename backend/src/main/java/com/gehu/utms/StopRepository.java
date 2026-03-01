package com.gehu.utms;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StopRepository extends JpaRepository<Stop, Integer> {
    List<Stop> findByCorridor(String corridor);
    Stop findByName(String name);
}