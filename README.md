
For documentation see blog article: [Liveness and Readiness Probes with Spring Boot](https://spring.io/blog/2020/03/25/liveness-and-readiness-probes-with-spring-boot)

Start application with `./gradlew bootRun`.

Change "latch" health indicator state and post availability events
via [web interface](http://localhost:8080/).

Observe [health](http://localhost:8080/actuator/health),
[liveness](http://localhost:8080/actuator/health/liveness) and
[readiness](http://localhost:8080/actuator/health/readiness) probes.
Pay attention to status codes from http (they are used in k8).

LatchHealthIndicator is included in liveness probe.
