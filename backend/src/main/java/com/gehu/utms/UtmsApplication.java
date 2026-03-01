package com.gehu.utms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UtmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UtmsApplication.class, args);
    }

    @Bean
    CommandLineRunner loadData(BusRepository busRepository, StopRepository stopRepository) {
        return args -> {

            // CORRIDOR A — Rispana / ISBT route
            stopRepository.save(new Stop("Ranipokhri", "CORRIDOR_A"));
            stopRepository.save(new Stop("Doiwala", "CORRIDOR_A"));
            stopRepository.save(new Stop("Jogiwala", "CORRIDOR_A"));
            stopRepository.save(new Stop("Rispana", "CORRIDOR_A"));
            stopRepository.save(new Stop("Kargi Chowk", "CORRIDOR_A"));
            stopRepository.save(new Stop("ISBT", "CORRIDOR_A"));

            // CORRIDOR B — GMS Road route
            stopRepository.save(new Stop("Hathibadkala", "CORRIDOR_B"));
            stopRepository.save(new Stop("Garhi Cant", "CORRIDOR_B"));
            stopRepository.save(new Stop("ONGC Chowk", "CORRIDOR_B"));
            stopRepository.save(new Stop("Ballupur Chowk", "CORRIDOR_B"));
            stopRepository.save(new Stop("GMS Road", "CORRIDOR_B"));

            // CORRIDOR C — Rajpur Road route
            stopRepository.save(new Stop("Rajpur", "CORRIDOR_C"));
            stopRepository.save(new Stop("Survey Chowk", "CORRIDOR_C"));
            stopRepository.save(new Stop("Araghar", "CORRIDOR_C"));
            stopRepository.save(new Stop("Kargi Chowk", "CORRIDOR_C"));

            // CORRIDOR D — Selaqui / Vikasnagar route
            stopRepository.save(new Stop("VikasNagar", "CORRIDOR_D"));
            stopRepository.save(new Stop("Selaqui Chowk", "CORRIDOR_D"));
            stopRepository.save(new Stop("Premnagar", "CORRIDOR_D"));
            stopRepository.save(new Stop("Panditwari", "CORRIDOR_D"));
            stopRepository.save(new Stop("Balliwala Chowk", "CORRIDOR_D"));

            // CORRIDOR E — Clock Tower route
            stopRepository.save(new Stop("Clock Tower", "CORRIDOR_E"));
            stopRepository.save(new Stop("Darshanlal Chowk", "CORRIDOR_E"));
            stopRepository.save(new Stop("Saharanpur Chowk", "CORRIDOR_E"));

            // Common destination
            stopRepository.save(new Stop("GEU", "ALL"));

            // BUSES — Corridor A
            busRepository.save(new Bus(6,  "UK07PA2191", "6.10 AM", false, "CORRIDOR_A", "Ranipokhri"));
            busRepository.save(new Bus(14, "UK07PA1811", "6.10 AM", false, "CORRIDOR_A", "Ranipokhri"));
            busRepository.save(new Bus(27, "UK07PA1791", "6.35 AM", true,  "CORRIDOR_A", "Doiwala"));
            busRepository.save(new Bus(39, "UK07PA3346", "6.35 AM", true,  "CORRIDOR_A", "Doiwala"));
            busRepository.save(new Bus(53, "UK07PA4160", "7.00 AM", true,  "CORRIDOR_A", "Kargi Chowk"));
            busRepository.save(new Bus(56, "UK07PA4172", "7.00 AM", true,  "CORRIDOR_A", "Rispana"));

            // BUSES — Corridor B
            busRepository.save(new Bus(20, "UK07PA2190", "7.00 AM", true,  "CORRIDOR_B", "Hathibadkala"));
            busRepository.save(new Bus(21, "UK07PA1910", "7.00 AM", true,  "CORRIDOR_B", "Hathibadkala"));
            busRepository.save(new Bus(22, "UA07Q4731",  "7.00 AM", true,  "CORRIDOR_B", "ONGC Chowk"));
            busRepository.save(new Bus(23, "UK07PA0630", "7.00 AM", true,  "CORRIDOR_B", "ONGC Chowk"));

            // BUSES — Corridor C
            busRepository.save(new Bus(74, "UK07PA5016", "6.45 AM", true,  "CORRIDOR_C", "Rajpur"));
            busRepository.save(new Bus(94, "UK07PA5549", "6.45 AM", true,  "CORRIDOR_C", "Rajpur"));
            busRepository.save(new Bus(96, "UK07PA5553", "6.45 AM", true,  "CORRIDOR_C", "Rajpur"));

            // BUSES — Corridor D
            busRepository.save(new Bus(36, "UK07PA2621", "6.10 AM", false, "CORRIDOR_D", "VikasNagar"));
            busRepository.save(new Bus(50, "UK07PA4118", "6.35 AM", true,  "CORRIDOR_D", "Selaqui Chowk"));
            busRepository.save(new Bus(71, "UK07PA5006", "6.35 AM", true,  "CORRIDOR_D", "Selaqui Chowk"));
            busRepository.save(new Bus(91, "UK07PA5542", "7.00 AM", true,  "CORRIDOR_D", "Premnagar"));
            busRepository.save(new Bus(92, "UK07PA5547", "7.00 AM", true,  "CORRIDOR_D", "Premnagar"));

            // BUSES — Corridor E
            busRepository.save(new Bus(18, "UK07PA1696", "7.00 AM", true,  "CORRIDOR_E", "Clock Tower"));
            busRepository.save(new Bus(24, "UK07PA1691", "7.00 AM", true,  "CORRIDOR_E", "Clock Tower"));
            busRepository.save(new Bus(11, "UA07D3359",  "7.00 AM", true,  "CORRIDOR_E", "Saharanpur Chowk"));

            System.out.println("✅ UTMS Data loaded successfully!");
        };
    }
}