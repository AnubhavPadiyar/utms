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
    CommandLineRunner loadData(BusRepository busRepository,
                               StopRepository stopRepository,
                               RouteStopRepository routeStopRepository) {
        return args -> {

            // ── GMS ROAD CORRIDOR (never touches Rispana) ──
            busRepository.save(new Bus(20, "UK07PA2190", "7.00 AM", true, "GMS_ROAD", "Hathibadkala"));
            addStops(routeStopRepository, 20, new String[]{"Hathibadkala","Garhi Cant","Vijay Colony","Chir Bagh","CM House","ONGC Chowk","Ballupur Chowk","GMS Road","GEU"});

            busRepository.save(new Bus(21, "UK07PA1910", "7.00 AM", true, "GMS_ROAD", "Hathibadkala"));
            addStops(routeStopRepository, 21, new String[]{"Hathibadkala","Garhi Cant","Vijay Colony","Chir Bagh","CM House","ONGC Chowk","Ballupur Chowk","GMS Road","GEU"});

            busRepository.save(new Bus(69, "UK07PA4998", "7.00 AM", true, "GMS_ROAD", "Garhi Cant"));
            addStops(routeStopRepository, 69, new String[]{"Garhi Cant","Vijay Colony","Chir Bagh","CM House","ONGC Chowk","Ballupur Chowk","GMS Road","GEU"});

            busRepository.save(new Bus(84, "UK07PA5033", "7.00 AM", true, "GMS_ROAD", "Garhi Cant"));
            addStops(routeStopRepository, 84, new String[]{"Garhi Cant","Vijay Colony","Chir Bagh","CM House","ONGC Chowk","Ballupur Chowk","GMS Road","GEU"});

            busRepository.save(new Bus(76, "UK07PA5018", "7.00 AM", true, "GMS_ROAD", "Garhi Cant"));
            addStops(routeStopRepository, 76, new String[]{"Garhi Cant","Vijay Colony","Chir Bagh","CM House","ONGC Chowk","Ballupur Chowk","GMS Road","GEU"});

            busRepository.save(new Bus(81, "UK07PA5030", "7.00 AM", true, "GMS_ROAD", "Rajender Nagar"));
            addStops(routeStopRepository, 81, new String[]{"Rajender Nagar","Yamuna Colony","Bindal Pul","Kishan Nagar","Blood Bank","Ballupur Chowk","GMS Road","GEU"});

            busRepository.save(new Bus(93, "UK07PA5548", "7.00 AM", true, "GMS_ROAD", "Rajender Nagar"));
            addStops(routeStopRepository, 93, new String[]{"Rajender Nagar","Yamuna Colony","Bindal Pul","Kishan Nagar","Blood Bank","Ballupur Chowk","GMS Road","GEU"});

            busRepository.save(new Bus(4, "UK07PA2192", "7.00 AM", true, "GMS_ROAD", "Supply"));
            addStops(routeStopRepository, 4, new String[]{"Supply","Ballupur Chowk","GMS Road","GEU"});

            busRepository.save(new Bus(22, "UA07Q4731", "7.00 AM", true, "GMS_ROAD", "ONGC Chowk"));
            addStops(routeStopRepository, 22, new String[]{"ONGC Chowk","Ballupur Chowk","GMS Road","GEU"});

            busRepository.save(new Bus(23, "UK07PA0630", "7.00 AM", true, "GMS_ROAD", "ONGC Chowk"));
            addStops(routeStopRepository, 23, new String[]{"ONGC Chowk","Ballupur Chowk","GMS Road","GEU"});

            // ── SELAQUI/PREMNAGAR CORRIDOR (via GMS Road, never Rispana) ──
            busRepository.save(new Bus(36, "UK07PA2621", "6.10 AM", false, "SELAQUI", "VikasNagar"));
            addStops(routeStopRepository, 36, new String[]{"VikasNagar","Harbatpur Chowk","Langa Road","Shaspur","Selaqui","Sudhowala","Nanda Ki Chowki","Premnagar","Panditwari","Vasant Vihar","Balliwala Chowk","GMS Road","GEU"});

            busRepository.save(new Bus(47, "UK07PA3848", "6.10 AM", false, "SELAQUI", "VikasNagar"));
            addStops(routeStopRepository, 47, new String[]{"VikasNagar","Harbatpur Chowk","Langa Road","Shaspur","Selaqui","Sudhowala","Nanda Ki Chowki","Premnagar","Panditwari","Vasant Vihar","Balliwala Chowk","GMS Road","GEU"});

            busRepository.save(new Bus(50, "UK07PA4118", "6.35 AM", true, "SELAQUI", "Selaqui Chowk"));
            addStops(routeStopRepository, 50, new String[]{"Selaqui Chowk","Sudhowala","Nanda Ki Chowki","Premnagar","Panditwari","Vasant Vihar","Balliwala Chowk","GMS Road","GEU"});

            busRepository.save(new Bus(71, "UK07PA5006", "6.35 AM", true, "SELAQUI", "Selaqui Chowk"));
            addStops(routeStopRepository, 71, new String[]{"Selaqui Chowk","Sudhowala","Nanda Ki Chowki","Premnagar","Panditwari","Vasant Vihar","Balliwala Chowk","GMS Road","GEU"});

            busRepository.save(new Bus(73, "UK07PA5015", "6.35 AM", true, "SELAQUI", "Selaqui Chowk"));
            addStops(routeStopRepository, 73, new String[]{"Selaqui Chowk","Sudhowala","Nanda Ki Chowki","Premnagar","Panditwari","Vasant Vihar","Balliwala Chowk","GMS Road","GEU"});

            busRepository.save(new Bus(33, "UK07PA2584", "6.35 AM", true, "SELAQUI", "Selaqui Chowk"));
            addStops(routeStopRepository, 33, new String[]{"Selaqui Chowk","Sudhowala","Nanda Ki Chowki","Premnagar","Panditwari","Vasant Vihar","Balliwala Chowk","GMS Road","GEU"});

            busRepository.save(new Bus(37, "UK07PA3348", "6.35 AM", true, "SELAQUI", "Selaqui Chowk"));
            addStops(routeStopRepository, 37, new String[]{"Selaqui Chowk","Sudhowala","Nanda Ki Chowki","Premnagar","Panditwari","Vasant Vihar","Balliwala Chowk","GMS Road","GEU"});

            busRepository.save(new Bus(79, "UK07PA5028", "6.35 AM", true, "SELAQUI", "Selaqui Chowk"));
            addStops(routeStopRepository, 79, new String[]{"Selaqui Chowk","Sudhowala","Nanda Ki Chowki","Premnagar","Panditwari","Vasant Vihar","Balliwala Chowk","GMS Road","GEU"});

            busRepository.save(new Bus(90, "UK07PA5541", "6.35 AM", true, "SELAQUI", "Selaqui Chowk"));
            addStops(routeStopRepository, 90, new String[]{"Selaqui Chowk","Sudhowala","Nanda Ki Chowki","Premnagar","Panditwari","Vasant Vihar","Balliwala Chowk","GMS Road","GEU"});

            busRepository.save(new Bus(91, "UK07PA5542", "7.00 AM", true, "SELAQUI", "Premnagar"));
            addStops(routeStopRepository, 91, new String[]{"Premnagar","Panditwari","Balliwala Chowk","GMS Road","GEU"});

            busRepository.save(new Bus(92, "UK07PA5547", "7.00 AM", true, "SELAQUI", "Premnagar"));
            addStops(routeStopRepository, 92, new String[]{"Premnagar","Panditwari","Balliwala Chowk","GMS Road","GEU"});

            busRepository.save(new Bus(85, "UK07PA5512", "7.00 AM", true, "SELAQUI", "Premnagar"));
            addStops(routeStopRepository, 85, new String[]{"Premnagar","Panditwari","Balliwala Chowk","GMS Road","GEU"});

            busRepository.save(new Bus(67, "UK07PA4996", "7.00 AM", true, "SELAQUI", "Premnagar"));
            addStops(routeStopRepository, 67, new String[]{"Premnagar","Panditwari","Balliwala Chowk","GMS Road","GEU"});

            // ── NAYA GAON/MEHUWALA CORRIDOR (via ISBT, never Rispana) ──
            busRepository.save(new Bus(44, "UK07PA3814", "7.00 AM", true, "NAYA_GAON", "Naya Gaon Palio"));
            addStops(routeStopRepository, 44, new String[]{"Naya Gaon Palio","Badowala","Telpur","Mehuwala","ISBT","GEU"});

            busRepository.save(new Bus(35, "UK07PA2622", "7.00 AM", true, "NAYA_GAON", "Naya Gaon Palio"));
            addStops(routeStopRepository, 35, new String[]{"Naya Gaon Palio","Badowala","Telpur","Mehuwala","ISBT","GEU"});

            busRepository.save(new Bus(46, "UK07PA3816", "7.00 AM", true, "NAYA_GAON", "Naya Gaon Palio"));
            addStops(routeStopRepository, 46, new String[]{"Naya Gaon Palio","Badowala","Telpur","Mehuwala","ISBT","GEU"});

            busRepository.save(new Bus(51, "UK07PA4119", "7.00 AM", true, "NAYA_GAON", "Naya Gaon Palio"));
            addStops(routeStopRepository, 51, new String[]{"Naya Gaon Palio","Badowala","Telpur","Mehuwala","ISBT","GEU"});

            busRepository.save(new Bus(83, "UK07PA5032", "7.00 AM", true, "NAYA_GAON", "Naya Gaon Palio"));
            addStops(routeStopRepository, 83, new String[]{"Naya Gaon Palio","Badowala","Telpur","Mehuwala","ISBT","GEU"});

            busRepository.save(new Bus(17, "UK07PA1694", "7.00 AM", true, "NAYA_GAON", "Badowala"));
            addStops(routeStopRepository, 17, new String[]{"Badowala","Telpur","Mehuwala","ISBT","GEU"});

            // ── KULHAL CORRIDOR ──
            busRepository.save(new Bus(3, "UK07PA2334", "6.10 AM", false, "KULHAL", "Kulhal"));
            addStops(routeStopRepository, 3, new String[]{"Kulhal","ISBT","GEU"});

            // ── SAHARANPUR/CLOCK TOWER CORRIDOR (via ISBT, never Rispana) ──
            busRepository.save(new Bus(18, "UK07PA1696", "7.00 AM", true, "CLOCK_TOWER", "Clock Tower"));
            addStops(routeStopRepository, 18, new String[]{"Clock Tower","Darshanlal Chowk","Saharanpur Chowk","ISBT","GEU"});

            busRepository.save(new Bus(24, "UK07PA1691", "7.00 AM", true, "CLOCK_TOWER", "Clock Tower"));
            addStops(routeStopRepository, 24, new String[]{"Clock Tower","Darshanlal Chowk","Saharanpur Chowk","ISBT","GEU"});

            busRepository.save(new Bus(42, "UK07PA3542", "7.00 AM", true, "CLOCK_TOWER", "Asley Hall"));
            addStops(routeStopRepository, 42, new String[]{"Asley Hall","Clock Tower","Darshanlal Chowk","Saharanpur Chowk","ISBT","GEU"});

            busRepository.save(new Bus(11, "UA07D3359", "7.00 AM", true, "CLOCK_TOWER", "Saharanpur Chowk"));
            addStops(routeStopRepository, 11, new String[]{"Saharanpur Chowk","Matawala Bagh","ISBT","GEU"});

            busRepository.save(new Bus(9, "UK07PA1699", "7.00 AM", true, "CLOCK_TOWER", "Saharanpur Chowk"));
            addStops(routeStopRepository, 9, new String[]{"Saharanpur Chowk","Matawala Bagh","ISBT","GEU"});

            busRepository.save(new Bus(19, "UK07PA1698", "7.00 AM", true, "CLOCK_TOWER", "Saharanpur Chowk"));
            addStops(routeStopRepository, 19, new String[]{"Saharanpur Chowk","Matawala Bagh","ISBT","GEU"});

            busRepository.save(new Bus(2, "UA07S2788", "7.00 AM", true, "CLOCK_TOWER", "Saharanpur Chowk"));
            addStops(routeStopRepository, 2, new String[]{"Saharanpur Chowk","Matawala Bagh","ISBT","GEU"});

            // ── KARGI/DAUDWALA CORRIDOR (via Kargi, never Rispana) ──
            busRepository.save(new Bus(7, "UK07PA2333", "7.00 AM", true, "KARGI", "Daudwala"));
            addStops(routeStopRepository, 7, new String[]{"Daudwala","Mathurawala","Vishnupuram","Bangali Kothi","Kargi Chowk","ISBT","GEU"});

            busRepository.save(new Bus(72, "UK07PA5007", "7.00 AM", true, "KARGI", "Daudwala"));
            addStops(routeStopRepository, 72, new String[]{"Daudwala","Mathurawala","Vishnupuram","Bangali Kothi","Kargi Chowk","ISBT","GEU"});

            busRepository.save(new Bus(75, "UK07PA5017", "7.00 AM", true, "KARGI", "Bangali Kothi"));
            addStops(routeStopRepository, 75, new String[]{"Bangali Kothi","Kargi Chowk","ISBT","GEU"});

            busRepository.save(new Bus(13, "UK07PA0858", "7.00 AM", true, "KARGI", "Race Course"));
            addStops(routeStopRepository, 13, new String[]{"Race Course","Dharampur","Mata Mandir","Kargi Chowk","ISBT","GEU"});

            busRepository.save(new Bus(63, "UK07PA4815", "7.00 AM", true, "KARGI", "Race Course"));
            addStops(routeStopRepository, 63, new String[]{"Race Course","Dharampur","Mata Mandir","Kargi Chowk","ISBT","GEU"});

            // ── RISPANA CORRIDOR (passes through Rispana) ──
            busRepository.save(new Bus(6, "UK07PA2191", "6.10 AM", false, "RISPANA", "Ranipokhri"));
            addStops(routeStopRepository, 6, new String[]{"Ranipokhri","Doiwala","Lachiwala","Kuanwala","Harawala","Miawala","Mokampur","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(14, "UK07PA1811", "6.10 AM", false, "RISPANA", "Ranipokhri"));
            addStops(routeStopRepository, 14, new String[]{"Ranipokhri","Doiwala","Lachiwala","Kuanwala","Harawala","Miawala","Mokampur","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(65, "UK07PA4992", "6.10 AM", false, "RISPANA", "Ranipokhri"));
            addStops(routeStopRepository, 65, new String[]{"Ranipokhri","Doiwala","Lachiwala","Kuanwala","Harawala","Miawala","Mokampur","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(34, "UK07PA2623", "6.10 AM", false, "RISPANA", "Ranipokhri"));
            addStops(routeStopRepository, 34, new String[]{"Ranipokhri","Doiwala","Lachiwala","Kuanwala","Harawala","Miawala","Mokampur","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(57, "UK07PA4738", "6.10 AM", false, "RISPANA", "Ranipokhri"));
            addStops(routeStopRepository, 57, new String[]{"Ranipokhri","Doiwala","Lachiwala","Kuanwala","Harawala","Miawala","Mokampur","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(5, "UK07PA2341", "6.10 AM", false, "RISPANA", "Ranipokhri"));
            addStops(routeStopRepository, 5, new String[]{"Ranipokhri","Doiwala","Lachiwala","Kuanwala","Harawala","Miawala","Mokampur","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(27, "UK07PA1791", "6.35 AM", true, "RISPANA", "Doiwala"));
            addStops(routeStopRepository, 27, new String[]{"Doiwala","Lachiwala","Kuanwala","Harawala","Miawala","Mokampur","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(39, "UK07PA3346", "6.35 AM", true, "RISPANA", "Doiwala"));
            addStops(routeStopRepository, 39, new String[]{"Doiwala","Lachiwala","Kuanwala","Harawala","Miawala","Mokampur","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(40, "UK07PA3345", "6.35 AM", true, "RISPANA", "Doiwala"));
            addStops(routeStopRepository, 40, new String[]{"Doiwala","Lachiwala","Kuanwala","Harawala","Miawala","Mokampur","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(49, "UK07PA4117", "6.35 AM", true, "RISPANA", "Doiwala"));
            addStops(routeStopRepository, 49, new String[]{"Doiwala","Lachiwala","Kuanwala","Harawala","Miawala","Mokampur","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(15, "UK07PA1944", "7.00 AM", true, "RISPANA", "Nakrounda More"));
            addStops(routeStopRepository, 15, new String[]{"Nakrounda More","Harawala","Miawala","Mokampur","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(62, "UK07PA4778", "7.00 AM", true, "RISPANA", "Nakrounda More"));
            addStops(routeStopRepository, 62, new String[]{"Nakrounda More","Harawala","Miawala","Mokampur","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(45, "UK07PA3815", "7.00 AM", true, "RISPANA", "Nakrounda More"));
            addStops(routeStopRepository, 45, new String[]{"Nakrounda More","Harawala","Miawala","Mokampur","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(58, "UK07PA4739", "7.00 AM", true, "RISPANA", "Nakrounda More"));
            addStops(routeStopRepository, 58, new String[]{"Nakrounda More","Harawala","Miawala","Mokampur","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(52, "UK07PA4121", "7.00 AM", true, "RISPANA", "Nakrounda More"));
            addStops(routeStopRepository, 52, new String[]{"Nakrounda More","Harawala","Miawala","Mokampur","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(59, "UK07PA4740", "7.00 AM", true, "RISPANA", "Nakrounda More"));
            addStops(routeStopRepository, 59, new String[]{"Nakrounda More","Harawala","Miawala","Mokampur","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(53, "UK07PA4160", "7.00 AM", true, "RISPANA", "Mokampur"));
            addStops(routeStopRepository, 53, new String[]{"Mokampur","Jogiwala","Rispana","Kargi Chowk","ISBT","GEU"});

            busRepository.save(new Bus(56, "UK07PA4172", "7.00 AM", true, "RISPANA", "Rispana"));
            addStops(routeStopRepository, 56, new String[]{"Rispana","Kargi Chowk","ISBT","GEU"});

            busRepository.save(new Bus(48, "UK07PA3849", "7.00 AM", true, "RISPANA", "Rispana"));
            addStops(routeStopRepository, 48, new String[]{"Rispana","Kargi Chowk","ISBT","GEU"});

            busRepository.save(new Bus(89, "UK07PA5517", "7.00 AM", true, "RISPANA", "Rispana"));
            addStops(routeStopRepository, 89, new String[]{"Rispana","Kargi Chowk","ISBT","GEU"});

            busRepository.save(new Bus(64, "UK07PA4816", "7.00 AM", true, "RISPANA", "Rispana"));
            addStops(routeStopRepository, 64, new String[]{"Rispana","Kargi Chowk","ISBT","GEU"});

            busRepository.save(new Bus(80, "UK07PA5029", "7.00 AM", true, "RISPANA", "Rispana"));
            addStops(routeStopRepository, 80, new String[]{"Rispana","Kargi Chowk","ISBT","GEU"});

            busRepository.save(new Bus(86, "UK07PA5514", "7.00 AM", true, "RISPANA", "Rispana"));
            addStops(routeStopRepository, 86, new String[]{"Rispana","Kargi Chowk","ISBT","GEU"});

            busRepository.save(new Bus(87, "UK07PA5515", "7.00 AM", true, "RISPANA", "Fountain Chowk"));
            addStops(routeStopRepository, 87, new String[]{"Fountain Chowk","Nehru Colony","Rispana","Kargi Chowk","GEU"});

            busRepository.save(new Bus(43, "UK07PA3546", "7.00 AM", true, "RISPANA", "Dharampur"));
            addStops(routeStopRepository, 43, new String[]{"Dharampur","Balbir Road","Fountain Chowk","Rispana","ISBT","GEU"});

            // ── RAIPUR/JOGIWALA CORRIDOR (passes Rispana) ──
            busRepository.save(new Bus(10, "UK07PA1690", "6.45 AM", true, "RAIPUR", "Raipur Chowk"));
            addStops(routeStopRepository, 10, new String[]{"Raipur Chowk","Dobhal Chowk","6 No. Pulia","Ring Road","Post Office Nehru Gram","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(38, "UK07PA3344", "6.45 AM", true, "RAIPUR", "Gujraunwala"));
            addStops(routeStopRepository, 38, new String[]{"Gujraunwala","Raipur Chowk","Dobhal Chowk","6 No. Pulia","Ring Road","Post Office Nehru Gram","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(88, "UK07PA5516", "6.45 AM", true, "RAIPUR", "Gujraunwala"));
            addStops(routeStopRepository, 88, new String[]{"Gujraunwala","Raipur Chowk","Dobhal Chowk","6 No. Pulia","Ring Road","Post Office Nehru Gram","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(95, "UK07PA5551", "6.45 AM", true, "RAIPUR", "Gujraunwala"));
            addStops(routeStopRepository, 95, new String[]{"Gujraunwala","Raipur Chowk","Dobhal Chowk","6 No. Pulia","Ring Road","Post Office Nehru Gram","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(61, "UK07PA4742", "6.45 AM", true, "RAIPUR", "Gujraunwala"));
            addStops(routeStopRepository, 61, new String[]{"Gujraunwala","Raipur Chowk","Dobhal Chowk","6 No. Pulia","Ring Road","Post Office Nehru Gram","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(78, "UK07PA5020", "6.35 AM", true, "RAIPUR", "Gujraunwala"));
            addStops(routeStopRepository, 78, new String[]{"Gujraunwala","Raipur Chowk","Dobhal Chowk","6 No. Pulia","Ring Road","Post Office Nehru Gram","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(66, "UK07PA4995", "6.45 AM", true, "RAIPUR", "Raipur Chowk"));
            addStops(routeStopRepository, 66, new String[]{"Raipur Chowk","Dobhal Chowk","6 No. Pulia","Ring Road","Post Office Nehru Gram","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(12, "UK07PA1695", "7.00 AM", true, "RAIPUR", "Raipur Chowk"));
            addStops(routeStopRepository, 12, new String[]{"Raipur Chowk","Dobhal Chowk","6 No. Pulia","Ring Road","Post Office Nehru Gram","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(55, "UK07PA4171", "6.45 AM", true, "RAIPUR", "Raipur Chowk"));
            addStops(routeStopRepository, 55, new String[]{"Raipur Chowk","Dobhal Chowk","6 No. Pulia","Ring Road","Post Office Nehru Gram","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(77, "UK07PA5019", "6.45 AM", true, "RAIPUR", "Post Office Nehru Gram"));
            addStops(routeStopRepository, 77, new String[]{"Post Office Nehru Gram","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(8, "UK07PA1266", "6.45 AM", true, "RAIPUR", "Post Office Nehru Gram"));
            addStops(routeStopRepository, 8, new String[]{"Post Office Nehru Gram","Jogiwala","Rispana","ISBT","GEU"});

            busRepository.save(new Bus(70, "UK07PA4999", "6.45 AM", true, "RAIPUR", "Raipur Chowk"));
            addStops(routeStopRepository, 70, new String[]{"Raipur Chowk","Dobhal Chowk","6 No. Pulia","Ring Road","Post Office Nehru Gram","Jogiwala","Rispana","ISBT","GEU"});

            // ── IT PARK/SHASTDHARA CORRIDOR (passes Rispana) ──
            busRepository.save(new Bus(41, "UK07PA3545", "6.45 AM", true, "IT_PARK", "IT Park"));
            addStops(routeStopRepository, 41, new String[]{"IT Park","Nala Paani Chowk","Shastdhara Crossing","Ladpur","6 No. Pulia","Fountain Chowk","Rispana","Kargi Chowk","ISBT","GEU"});

            busRepository.save(new Bus(54, "UK07PA4161", "6.45 AM", true, "IT_PARK", "IT Park"));
            addStops(routeStopRepository, 54, new String[]{"IT Park","Nala Paani Chowk","Shastdhara Crossing","Ladpur","6 No. Pulia","Fountain Chowk","Rispana","Kargi Chowk","ISBT","GEU"});

            busRepository.save(new Bus(82, "UK07PA5031", "6.45 AM", true, "IT_PARK", "IT Park"));
            addStops(routeStopRepository, 82, new String[]{"IT Park","Nala Paani Chowk","Shastdhara Crossing","Ladpur","6 No. Pulia","Fountain Chowk","Rispana","Kargi Chowk","ISBT","GEU"});

            busRepository.save(new Bus(68, "UK07PA4997", "6.45 AM", true, "IT_PARK", "IT Park"));
            addStops(routeStopRepository, 68, new String[]{"IT Park","Nala Paani Chowk","Shastdhara Crossing","Ladpur","6 No. Pulia","Fountain Chowk","Rispana","Kargi Chowk","ISBT","GEU"});

            busRepository.save(new Bus(60, "UK07PA4741", "6.45 AM", true, "IT_PARK", "Shastdhara Crossing"));
            addStops(routeStopRepository, 60, new String[]{"Shastdhara Crossing","Ladpur","6 No. Pulia","Fountain Chowk","Rispana","Kargi Chowk","ISBT","GEU"});

            // ── RAJPUR ROAD CORRIDOR (passes Rispana) ──
            busRepository.save(new Bus(74, "UK07PA5016", "6.45 AM", true, "RAJPUR", "Rajpur"));
            addStops(routeStopRepository, 74, new String[]{"Rajpur","Great Value","Dilaram Bazar","Nanni Bakery","Survey Chowk","Dwarka Store","Araghar","Rispana","Kargi Chowk","ISBT","GEU"});

            busRepository.save(new Bus(94, "UK07PA5549", "6.45 AM", true, "RAJPUR", "Rajpur"));
            addStops(routeStopRepository, 94, new String[]{"Rajpur","Great Value","Dilaram Bazar","Nanni Bakery","Survey Chowk","Dwarka Store","Araghar","Rispana","Kargi Chowk","ISBT","GEU"});

            busRepository.save(new Bus(96, "UK07PA5553", "6.45 AM", true, "RAJPUR", "Rajpur"));
            addStops(routeStopRepository, 96, new String[]{"Rajpur","Great Value","Dilaram Bazar","Nanni Bakery","Survey Chowk","Dwarka Store","Araghar","Rispana","Kargi Chowk","ISBT","GEU"});

            System.out.println("✅ UTMS Data loaded successfully with " +
                busRepository.count() + " buses and " +
                routeStopRepository.count() + " route stops!");
        };
    }

    private void addStops(RouteStopRepository repo, int busNumber, String[] stops) {
        for (int i = 0; i < stops.length; i++) {
            repo.save(new RouteStop(busNumber, stops[i], i + 1));
        }
    }
}