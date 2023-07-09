package com.userdepthystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard
public class UserDeptMicroSerHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDeptMicroSerHystrixDashboardApplication.class, args);
		System.out.println("Hystrix Started");
	}

}
