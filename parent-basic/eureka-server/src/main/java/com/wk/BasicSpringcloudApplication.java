package com.wk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BasicSpringcloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicSpringcloudApplication.class, args);
	}
}
