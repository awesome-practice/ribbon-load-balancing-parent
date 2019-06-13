package com.practice.springcloud.ribbon.client.user.actuate;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Luo Bao Ding
 * @since 2018/10/10
 */
//@Component //close
public class ProblemMakerHealthIndicator extends AbstractHealthIndicator {
    private AtomicBoolean shdSleep = new AtomicBoolean(false);

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        if (shdSleep.get()) {
            Thread.sleep(4_000);
        }
        builder.up();
        shdSleep.set(!shdSleep.get());
    }
}
