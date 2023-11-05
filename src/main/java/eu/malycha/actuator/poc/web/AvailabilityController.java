package eu.malycha.actuator.poc.web;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvailabilityController {

    private final ApplicationEventPublisher publisher;

    public AvailabilityController(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping("/api/liveness/up")
    public void setLivenessUp() {
        AvailabilityChangeEvent.publish(publisher, this, LivenessState.CORRECT);
    }

    @PostMapping("/api/liveness/down")
    public void setLivenessDown() {
        AvailabilityChangeEvent.publish(publisher, this, LivenessState.BROKEN);
    }

    @PostMapping("/api/readiness/up")
    public void setReadinessUp() {
        AvailabilityChangeEvent.publish(publisher, this, ReadinessState.ACCEPTING_TRAFFIC);
    }

    @PostMapping("/api/readiness/down")
    public void setReadinessDown() {
        AvailabilityChangeEvent.publish(publisher, this, ReadinessState.REFUSING_TRAFFIC);
    }
}
