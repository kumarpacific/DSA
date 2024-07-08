package com.dsa.phase1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public Set<RequestPayload> status(){
		Set<RequestPayload> set = new HashSet<>();

		set.add(RequestPayload.builder().id("1").name("Pras").build());

		set.add(RequestPayload.builder().id("2").name("Kuma").build());

		set.add(RequestPayload.builder().id("3").name("Praj").build());

		set.add(RequestPayload.builder().id("4").name("Pras").build());

		return set;

		// comments
	}
}

 class TestClass {
	public static Integer wiggler(Integer x) {
		Integer y = x + 10;
		x++;
		System.out.println(x);
		return y;
	}

	public static void main(String[] args) {
		Integer dataWrapper = 5;
		Integer value = wiggler(dataWrapper);
		System.out.println(dataWrapper + value);
	}
}
