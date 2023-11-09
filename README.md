
For documentation see blog article: [Liveness and Readiness Probes with Spring Boot](https://spring.io/blog/2020/03/25/liveness-and-readiness-probes-with-spring-boot)

# Local run

Start application with `./gradlew bootRun`.

Change "latch" health indicator state and post availability events
via [web interface](http://localhost:8080/).

Observe [health](http://localhost:8080/actuator/health),
[liveness](http://localhost:8080/actuator/health/liveness) and
[readiness](http://localhost:8080/actuator/health/readiness) probes.
Pay attention to status codes from http (they are used in k8).

LatchHealthIndicator is included in liveness probe.

# Minikube

Start minikube with `minikube start`.

Configure docker-env with `eval $(minikube docker-env)`.

Build image with `./gradlew clean build docker`

Install helm chart with `helm upgrade --install actuator-poc ./k8s/actuator-poc/.`

With enabled addons `ingress` and `ingress-dns` and `minikube ip` added to `resolv.conf`, the `http://actuator-poc.local` 
should lead to the poc application.
