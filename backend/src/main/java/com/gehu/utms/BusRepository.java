package com.gehu.utms;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BusRepository extends JpaRepository<Bus, Integer> {
    List<Bus> findByCorridor(String corridor);
    List<Bus> findByStartStop(String startStop);
    List<Bus> findByCorridorNot(String corridor);
}