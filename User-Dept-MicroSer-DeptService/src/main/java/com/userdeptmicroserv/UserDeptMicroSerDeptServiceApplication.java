package com.userdeptmicroserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserDeptMicroSerDeptServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDeptMicroSerDeptServiceApplication.class, args);
		System.out.println("Dept Service is Started.");
	}

}
