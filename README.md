# SkillTracker Cloud
A microservices-based Spring Cloud project demonstrating modern backend architecture, observability, tracing, metrics, and monitoring.

This project includes:

- Spring Cloud Gateway
- User Service
- Skill Service
- Config Server
- Discovery Server (Eureka)
- Distributed Tracing with Zipkin
- Metrics via Prometheus
- Dashboards via Grafana

## Project Structure

```
skilltracker-cloud/
│
├── gateway-service/
├── user-service/
├── skill-service/
├── discovery-service/
├── config-service/
│
└── monitoring/
    ├── prometheus.yml
    └── spring-microservices-dashboard.json
```

## How to Run the Entire System

Below is the correct order to start all components.

### 1. Start Zipkin (Tracing)

```bash
docker run -d -p 9411:9411 --name zipkin openzipkin/zipkin
```

Open Zipkin UI:

http://localhost:9411  
Click **Run Query** to see traces.

### 2. Start Prometheus (Metrics Collector)

Prometheus config file is located at:

```
monitoring/prometheus.yml
```

Run:

```bash
docker run -d ^
  -p 9560:9090 ^
  -v C:\Users\isaev\IdeaProjects\skilltracker-cloud\monitoring\prometheus.yml:/etc/prometheus/prometheus.yml ^
  --name prometheus ^
  prom/prometheus
```

Prometheus UI:  
http://localhost:9560  
Prometheus targets:  
http://localhost:9560/targets

You should see 3 UP targets.

### 3. Start Grafana (Dashboards)

```bash
docker run -d ^
  -p 3000:3000 ^
  --name grafana ^
  grafana/grafana
```

Grafana:  
http://localhost:3000  
Login: admin / admin

Add Prometheus as a data source:

```
http://host.docker.internal:9560
```

Import dashboard:  
Monitoring → Dashboards → Import → Upload `spring-microservices-dashboard.json`

### 4. Start Spring Cloud Services (in order)

1. Config Server  
2. Discovery Server  
3. Gateway Service  
4. User Service  
5. Skill Service  

## Available Endpoints

### Eureka
http://localhost:8761

### Gateway Routes
```
GET http://localhost:8080/users/1
GET http://localhost:8080/skills/1
```

### Prometheus Metrics
```
/actuator/prometheus
```

### Zipkin UI
http://localhost:9411

### Grafana UI
http://localhost:3000

## Observability Overview

- Micrometer Tracing → OpenTelemetry → Zipkin  
- Micrometer Metrics → Prometheus  
- Dashboards → Grafana  

## Technologies Used

- Spring Boot 3  
- Spring Cloud 2023.x  
- Spring Cloud Gateway  
- Eureka Server  
- Config Server  
- Micrometer  
- OpenTelemetry  
- Zipkin  
- Prometheus  
- Grafana  
- Docker  
