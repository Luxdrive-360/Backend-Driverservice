package com.luxdrive.DriverServiceConfiguration;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfig {

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> containerCustomizer() {
        return factory -> factory.addConnectorCustomizers((Connector connector) -> {
            // Increase max file count
            connector.setProperty("maxParameterCount", "10000");  // default is 1000
            connector.setMaxPostSize(20 * 1024 * 1024); // 20MB
        });
    }
}
