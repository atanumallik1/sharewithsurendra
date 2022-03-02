package com.example.demo.comtroller;

import java.time.Instant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SidecarController {
	 @GetMapping("")
	public String sayHello() {
			return "Hello from TaskApplication "
			+"</br>"
			+"</br>"
			+ "<a href=\"log\">/log</a>" ;
			
	 }
    @GetMapping("log")
	public String logSomething() {
    	String logMessage = " TaskApplication: Logged at "  + Instant.now();
		System.out.println(logMessage);
		return logMessage ;
	} 
	
	
}
