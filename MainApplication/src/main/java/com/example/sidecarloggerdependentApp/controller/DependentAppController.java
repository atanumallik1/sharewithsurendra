package com.example.sidecarloggerdependentApp.controller;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class DependentAppController {

	@Value("${CONFIG_SERVER_PORT:8082}")
	private String port;

	@GetMapping("")
	public String sayHello() {
		return "Hello from Mainapp "
				+"</br>"
				+"</br>"
				+ "<a href=\"MainAppLog\">/MainAppLog</a>"
				+"</br>"
				+ "<a href=\"SidecarLog\">/SidecarLog</a>" ;
	}

	@GetMapping("/MainAppLog")
	public String logSomething() {
		String logMessage = "MainApp Log : Logged at " + Instant.now();
		System.out.println(logMessage);
		return logMessage;
	}

	@GetMapping("/SidecarLog")
	public String logSomethingViaSideCar() {

		final String uri = "http://localhost:" + port + "/log";
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(uri, String.class);

	}

}
