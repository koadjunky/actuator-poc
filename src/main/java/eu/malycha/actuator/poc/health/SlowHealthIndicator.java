package eu.malycha.actuator.poc.health;

import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnEnabledHealthIndicator("slow")
public class SlowHealthIndicator extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
