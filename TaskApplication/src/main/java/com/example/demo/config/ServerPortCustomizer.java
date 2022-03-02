package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class ServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
	
	@Value("${CONFIG_SERVER_PORT:8082}")
	private String port;

	@Override
	public void customize(ConfigurableWebServerFactory factory) {
		factory.setPort(Integer.parseInt(port));
	}
}
