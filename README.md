# Web Project - System Stats Dashboard 
(Work in Progress)

A simple Spring Boot web application that shows system statistics via a REST API and displays them on a web dashboard. This project is primarily for learning and experimentation with Java, Spring Boot, and frontend integration.

---

## Features

- **Memory Stats**: Total RAM, free RAM, and used RAM
- **CPU Stats**: Process CPU load, system CPU load, total CPU load
- **Disk Stats**: Total and free disk space
- **Uptime**: JVM uptime in seconds
- **REST API**: Access each metric individually with `/api/stats/...` endpoints
- **Frontend Dashboard**: Display stats dynamically using JavaScript and APIs

---

## API Endpoints

### All Stats (json object)
- `GET /api/stats`

### Memory
- `GET /api/stats/memory/totalRAM` — Total RAM (GB)
- `GET /api/stats/memory/freeRAM` — Free RAM (GB)
- `GET /api/stats/memory/usedRAM` — Used RAM (GB)

### CPU
- `GET /api/stats/cpu/processCPU` — Process CPU load (%)
- `GET /api/stats/cpu/systemCPU` — System CPU load (%)
- `GET /api/stats/cpu/totalCPU` — Total CPU load (%)

### Disk
- `GET /api/stats/disk/totalSpace` — Total disk space (GB)
- `GET /api/stats/disk/freeSpace` — Free disk space (GB)

### Uptime
- `GET /api/stats/uptime` — JVM uptime (seconds)

---

This site is just source code, not a live service

