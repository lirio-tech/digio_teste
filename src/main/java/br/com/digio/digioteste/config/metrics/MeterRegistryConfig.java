package br.com.digio.digioteste.config.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MeterRegistryConfig {

    private static final String APP_NAME = "app_name";
    private static final String APP_VERSION = "app_version";
    
    @Bean
    MeterRegistryCustomizer<MeterRegistry> registryCustomizer(
            @Value("${spring.application.name}") String appName,
            @Value("${spring.application.version}") String appVersion) {
        return registry -> {
            String tags [] = {APP_NAME, appName, APP_VERSION, appVersion};
            registry.config().commonTags(tags);
        };
    }
}