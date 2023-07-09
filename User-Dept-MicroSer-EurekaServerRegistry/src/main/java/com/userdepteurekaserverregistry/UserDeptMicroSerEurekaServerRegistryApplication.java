package com.userdepteurekaserverregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class UserDeptMicroSerEurekaServerRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDeptMicroSerEurekaServerRegistryApplication.class, args);
		System.out.println("User-Dept Eureka Server Started..");
	}

}
