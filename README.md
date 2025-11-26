# SkillTracker Cloud

SkillTracker Cloud is a microservices-based Spring Cloud system demonstrating modern backend architecture with centralized configuration, service discovery, API gateway routing, event-driven communication (Kafka), and a complete observability stack (Zipkin, Prometheus, Grafana).

---

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
├── docker-compose.yml
│
└── monitoring/
    ├── prometheus.yml
    └── spring-microservices-dashboard.json
```

---

## Running the Infrastructure

All infrastructure components run with a single command using `docker-compose`.

In the project root:

```bash
docker compose up -d
```

This launches:

- Zookeeper  
- Kafka broker  
- Zipkin (distributed tracing)  
- Prometheus (metrics collection)  
- Grafana (dashboards)

All containers run inside the shared Docker network `skillnet`.

---

## Running Spring Cloud Services

After the infrastructure is up, you can start microservices from your IDE or manually:

1. `config-service`  
2. `discovery-service`  
3. `gateway-service`  
4. `user-service`  
5. `skill-service`

Each service:

- retrieves configuration from Config Server  
- registers itself in Eureka Discovery Server  
- becomes reachable through the API Gateway  

---

## Service URLs

### Eureka Dashboard  
http://localhost:8761

### API Gateway  
Examples:

```
POST http://localhost:8080/users
GET  http://localhost:8080/skills
```

---

## Observability

### Zipkin (Tracing)
http://localhost:9411

### Prometheus (Metrics)
http://localhost:9560  
Targets: http://localhost:9560/targets

### Grafana (Dashboards)
http://localhost:3000  
Login: `admin / admin`

Prometheus data source URL inside Docker network:

```
http://prometheus:9090
```

You can import the dashboard file:

```
monitoring/spring-microservices-dashboard.json
```

---

## Kafka Event Streaming

Kafka is included in the infrastructure and is fully functional.  
Services can publish and consume events using Spring Cloud Stream with the Kafka binder.

No manual setup is required — Kafka starts automatically with `docker-compose`.

---

## Summary

SkillTracker Cloud provides a clean example of a modern microservices architecture with:

- API Gateway  
- Distributed configuration  
- Service discovery  
- Kafka event streaming  
- Full observability stack (Zipkin + Prometheus + Grafana)  
- Single-command infrastructure startup

Launch everything with:

```bash
docker compose up -d
```

Then start microservices from your IDE.
