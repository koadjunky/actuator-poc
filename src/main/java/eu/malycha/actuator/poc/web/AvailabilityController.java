package eu.malycha.actuator.poc.web;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvailabilityController {

    private final ApplicationEventPublisher publisher;

    public AvailabilityController(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping("/api/liveness/up/{id}")
    public void setLivenessUp(@PathVariable  String id) {
        AvailabilityChangeEvent.publish(publisher, id, LivenessState.CORRECT);
    }

    @PostMapping("/api/liveness/down/{id}")
    public void setLivenessDown(@PathVariable  String id) {
        AvailabilityChangeEvent.publish(publisher, id, LivenessState.BROKEN);
    }

    @PostMapping("/api/readiness/up/{id}")
    public void setReadinessUp(@PathVariable  String id) {
        AvailabilityChangeEvent.publish(publisher, id, ReadinessState.ACCEPTING_TRAFFIC);
    }

    @PostMapping("/api/readiness/down/{id}")
    public void setReadinessDown(@PathVariable  String id) {
        AvailabilityChangeEvent.publish(publisher, id, ReadinessState.REFUSING_TRAFFIC);
    }
}
