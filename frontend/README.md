# 🚌 UTMS — University Transport Management System

> A smart bus delay tracking and alternate route suggestion system built for Graphic Era Hill University (GEHU), Dehradun.

---

## 📌 Project Overview

UTMS is a full-stack web application that helps students track university bus delays in real time. When a delay is reported at a stop, the system uses a **BFS (Breadth-First Search) graph traversal algorithm** to identify all affected buses and suggest safe alternate buses from different corridors.

Built solo by **Anubhav Padiyar** | Team PCB 2.0 | GEHU

---

## ✨ Features

- 🗺️ **Live Bus Dashboard** — View all 20+ buses, routes, timings and corridors
- 👤 **Student Registration** — Register with your stop and get auto-assigned a bus
- ⚠️ **Smart Delay Reporting** — Report a delay at any stop
- 🔍 **BFS Algorithm** — Automatically finds all affected buses on the same corridor
- 🚌 **Alternate Bus Suggestions** — Suggests safe buses from completely different corridors
- ⚙️ **Admin Panel** — View all registered students and buses with search and filter
- 📱 **Responsive UI** — Works on desktop and mobile

---

## 📁 Project Structure

```
utms/
├── backend/
│   ├── src/main/java/com/gehu/utms/
│   │   ├── UtmsApplication.java       # Main app + data loader
│   │   ├── Bus.java                   # Bus entity
│   │   ├── Stop.java                  # Stop entity
│   │   ├── Student.java               # Student entity
│   │   ├── BusRepository.java         # Bus DB operations
│   │   ├── StopRepository.java        # Stop DB operations
│   │   ├── StudentRepository.java     # Student DB operations
│   │   ├── BfsService.java            # BFS delay analysis logic
│   │   ├── BusController.java         # Bus & delay REST endpoints
│   │   └── StudentController.java     # Student REST endpoints
│   ├── src/main/resources/
│   │   └── application.properties
│   └── pom.xml
└── frontend/
    ├── index.html                     # Dashboard
    ├── register.html                  # Student registration
    ├── delay.html                     # Report delay + BFS results
    └── admin.html                     # Admin panel
```

---

## 🚀 How to Run Locally

### Prerequisites
- Java 17 or above
- Maven 3.9+
- Any modern browser
- VS Code (recommended) with Live Server extension

### Step 1 — Clone the repository
```bash
git clone https://github.com/YOUR_USERNAME/utms.git
cd utms
```

### Step 2 — Start the backend
```bash
cd backend
mvn spring-boot:run
```

Wait for:
```
✅ UTMS Data loaded successfully!
Started UtmsApplication in X.XXX seconds
```

### Step 3 — Open the frontend
Open `frontend/index.html` with Live Server in VS Code or directly in your browser.

The app will be available at:
```
http://127.0.0.1:5500/frontend/index.html
```

Backend API runs at:
```
http://localhost:8080
```

---

## 🔗 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/buses` | Get all buses |
| GET | `/api/stops` | Get all stops |
| GET | `/api/students` | Get all students |
| POST | `/api/students/register` | Register a student |
| POST | `/api/delay` | Report delay + BFS analysis |

### Example — Report a delay
```json
POST /api/delay
{
  "stopName": "Rispana",
  "delayMinutes": 20,
  "reason": "Traffic"
}
```

### Response
```json
{
  "delayedStop": "Rispana",
  "delayMinutes": 20,
  "affectedCorridor": "CORRIDOR_A",
  "affectedBuses": [...],
  "affectedStops": [...],
  "alternateBuses": [...],
  "message": "Bus delay detected on CORRIDOR_A. 6 buses affected. 15 alternate buses available."
}
```

---

## 🧠 How BFS Works

Stops are treated as **graph nodes** and routes as **edges** connecting them. When a delay is reported:

```
Rispana delayed (Traffic)
        ↓ BFS spreads on CORRIDOR_A
Ranipokhri ← affected
Doiwala    ← affected
Jogiwala   ← affected
Kargi Chowk← affected
ISBT       ← affected

✅ Alternate buses suggested from:
   CORRIDOR_B (GMS Road)
   CORRIDOR_C (Rajpur Road)
   CORRIDOR_D (Selaqui)
   CORRIDOR_E (Clock Tower)
```

For **Vehicle Breakdown**, only the specific bus is affected — not the entire corridor.

---

## 🗺️ Bus Corridors

| Corridor | Route | Buses |
|----------|-------|-------|
| Corridor A | Ranipokhri → Rispana → ISBT → GEU | 6 |
| Corridor B | Hathibadkala → GMS Road → GEU | 4 |
| Corridor C | Rajpur → Araghar → Kargi → GEU | 3 |
| Corridor D | VikasNagar → Selaqui → Premnagar → GEU | 5 |
| Corridor E | Clock Tower → Saharanpur Chowk → GEU | 3 |

---

## 📸 Screenshots

| Page | Description |
|------|-------------|
| Dashboard | View all buses with search and filter |
| Register | Student registration with auto bus assignment |
| Delay Report | BFS-powered delay analysis |
| Admin Panel | Manage all students and buses |

---

## 🔮 Future Improvements

- [ ] Real-time delay notifications via SMS/email
- [ ] Exact travel time estimation between stops
- [ ] GPS-based live bus tracking
- [ ] Mobile app (Android/iOS)
- [ ] Switch from H2 to MySQL for production
- [ ] Admin login with authentication

---

## 👨‍💻 Author

**Anubhav Padiyar**
B.Tech Computer Science

---

## 📄 License

This project is built for academic purposes only.