# SkillTracker Cloud

SkillTracker is a microservices-based learning project designed to
explore Spring Boot, Spring Cloud, Observability (Micrometer /
OpenTelemetry), Resilience4j, and other Spring ecosystem modules.

## Project Structure

    skilltracker-cloud/
     ├── config-service
     ├── discovery-service (Eureka)
     ├── gateway-service
     ├── user-service
     ├── skill-service
     └── config-repo/ (remote config for Spring Cloud Config)

## Features

### ✔ User Service

Simple REST service returning a test user.

### ✔ Skill Service

Foundation service for skill management.

### ✔ Gateway Service

Spring Cloud Gateway routing all API requests.

### ✔ Eureka Discovery Server

Automatic service registration.

### ✔ Config Server

Centralized configuration storage.

### ✔ Distributed Tracing

Using: - Micrometer Tracing\
- OpenTelemetry bridge\
- Zipkin exporter

------------------------------------------------------------------------

# 🚀 How to Run the Project

## 1️⃣ Start Zipkin (Tracing)

``` bash
docker run -d -p 9411:9411 openzipkin/zipkin
```

Open UI:

    http://localhost:9411

## 2️⃣ Start Config Service

``` bash
cd config-service
./gradlew bootRun
```

## 3️⃣ Start Discovery Service (Eureka)

``` bash
cd discovery-service
./gradlew bootRun
```

Open Eureka dashboard:

    http://localhost:8761

## 4️⃣ Start Gateway, User, and Skill Services

Recommended order:

1.  gateway-service\
2.  user-service\
3.  skill-service

Run each with:

``` bash
./gradlew bootRun
```

You should see:

    GATEWAY-SERVICE — UP
    USER-SERVICE   — UP
    SKILL-SERVICE  — UP

------------------------------------------------------------------------

# 🌐 Test the API

### Get user by ID:

    GET http://localhost:8080/users/1

### Get skill by ID:

    GET http://localhost:8080/skills/1

------------------------------------------------------------------------

# 🔍 Distributed Tracing in Zipkin

Go to:

    http://localhost:9411

Every request generates: - one **traceId** for the entire request -
several **spanId** entries for each step (Gateway → Service → DB)

------------------------------------------------------------------------

# ⚙ Tracing Configuration (Micrometer + OpenTelemetry)

Each service contains:

``` yaml
management:
  tracing:
    enabled: true
    sampling:
      probability: 1.0

  zipkin:
    tracing:
      endpoint: http://localhost:9411/api/v2/spans

logging:
  pattern:
    level: "%5p [${spring.application.name},%X{traceId:-},%X{spanId:-}]"
```

------------------------------------------------------------------------

# 🧪 Actuator Health Checks

    http://localhost:<port>/actuator/health

------------------------------------------------------------------------

# 🐞 Troubleshooting

### ❗ Eureka shows host like `*.mshome.net`

This can happen on Windows after DNS resets.

Fix:

``` yaml
eureka:
  instance:
    hostname: localhost
    prefer-ip-address: true
```

------------------------------------------------------------------------

# 📌 Roadmap

1.  Spring Core, Boot, Web ✔\
2.  Validation, JPA ✔\
3.  Spring Cloud ✔\
4.  Resilience4j ✔\
5.  Micrometer Tracing + OTel ✔\
6.  Prometheus + Grafana (upcoming)\
7.  Actuator Deep Dive\
8.  Batch / Integration / WebSockets / GraphQL

------------------------------------------------------------------------

# 📧 Author

**Aleksandr Isaev**
