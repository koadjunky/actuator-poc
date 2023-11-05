package eu.malycha.actuator.poc.web;

import eu.malycha.actuator.poc.health.LatchHealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    private final LatchHealthIndicator latchHealthIndicator;

    public HealthController(LatchHealthIndicator latchHealthIndicator) {
        this.latchHealthIndicator = latchHealthIndicator;
    }

    @PostMapping("/api/health/unknown")
    public void setUnknown() {
        latchHealthIndicator.setStatus(Status.UNKNOWN);
    }

    @PostMapping("/api/health/up")
    public void setUp() {
        latchHealthIndicator.setStatus(Status.UP);
    }

    @PostMapping("/api/health/down")
    public void setDown() {
        latchHealthIndicator.setStatus(Status.DOWN);
    }

    @PostMapping("/api/health/oos")
    public void setOutOfService() {
        latchHealthIndicator.setStatus(Status.OUT_OF_SERVICE);
    }

}
