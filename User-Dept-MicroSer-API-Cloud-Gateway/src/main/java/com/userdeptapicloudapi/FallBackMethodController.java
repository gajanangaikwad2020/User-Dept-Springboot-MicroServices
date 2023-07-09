package com.userdeptapicloudapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController 
{
	@GetMapping(value = "/userservicefallback")
	public String userServiceFallBackMethod()
	{
		return "User service is taking longer than Expected." + "Please try again later.";
	}

	@GetMapping(value = "/departmentservicefallback")
	public String departmentServiceFallBackMethod()
	{
		return "Department service is taking longer than Expected." + "Please try again later.";
	}
}
