package eu.malycha.actuator.poc.health;

import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnEnabledHealthIndicator("latch")
public class LatchHealthIndicator extends AbstractHealthIndicator {

    private Status status = Status.UNKNOWN;
    private long timestamp = System.currentTimeMillis();

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        builder.status(status);
        builder.withDetail("duration (s)", (System.currentTimeMillis() - timestamp)/1000L);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.timestamp = System.currentTimeMillis();
        this.status = status;
    }
}
