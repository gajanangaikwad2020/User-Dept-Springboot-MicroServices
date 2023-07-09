package com.userdeptapicloudapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableCircuitBreaker
public class UserDeptMicroSerApiCloudGatewayApplication 
{

	public static void main(String[] args) {
		SpringApplication.run(UserDeptMicroSerApiCloudGatewayApplication.class, args);
		System.out.println("API Cloud Gateway Started");
	}

}
