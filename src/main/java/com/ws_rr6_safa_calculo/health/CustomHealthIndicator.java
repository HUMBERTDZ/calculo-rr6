package com.ws_rr6_safa_calculo.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    private boolean lastKnownStatus = true;
    private Instant lastUpTime = Instant.now();
    //private Instant lastUpTime = Instant.parse("2024-12-31T12:00:00Z");
 
    @Override
    public Health health() {
        boolean isServiceUp = checkSomething();

        if (isServiceUp) {
            // Solo se establece la hora si el servicio acaba de pasar a UP
            if (!lastKnownStatus || lastUpTime == null) {
                lastUpTime = Instant.now();
            }
            lastKnownStatus = true;

            Duration uptime = Duration.between(lastUpTime, Instant.now());

            return Health.up()
                    .withDetail("customService", "Disponible")
                    .withDetail("uptime", formatDuration(uptime))
                    .withDetail("since", lastUpTime.toString())
                    .build();
        } else {
            lastKnownStatus = false;
            return Health.down()
                    .withDetail("customService", "No disponible")
                    .withDetail("message", "El servicio falló la verificación")
                    .build();
        }
    }
    
    private boolean checkSomething() {
        return true; // Siempre UP por defecto
    }

    private String formatDuration(Duration duration) {
        long hours = duration.toHours();
//        long minutes = duration.toMinutesPart();
//        long seconds = duration.toSecondsPart();
        return String.format("%02dh %02dm %02ds", hours, 0, 0);
    }
}
