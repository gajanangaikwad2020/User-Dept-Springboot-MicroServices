package com.userdeptmicroserv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userdeptmicroserv.entity.User;
import com.userdeptmicroserv.exception.ResourceNotFoundException;
import com.userdeptmicroserv.exception.SomethingWentWrongException;
import com.userdeptmicroserv.model.UserDepartment;
import com.userdeptmicroserv.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@PostMapping(value ="/save-user")
	public ResponseEntity<String> saveUser(@RequestBody User user)
	{
		log.info("SaveUser() method of UserController. ");
		User userDB = userService.saveUser(user);
		if (userDB!=null) 
		{
			return new ResponseEntity<String>("User is Saved.",HttpStatus.CREATED);
		}
		else
		{
			throw new SomethingWentWrongException("Something Went Wrong Exception Occure, Please try again");
		}
	}
	
	@GetMapping(value ="/get-user-by-id-withdept/{userId}")
	public ResponseEntity<UserDepartment> getUserByIdWithDept(@PathVariable Long userId)
	{
		log.info("Inside getUserWithDeptByUserId() method of UserController. ");
		UserDepartment userDeptDB = userService.getUserByIdWithDept(userId);
		System.out.println(userDeptDB);
		if (userDeptDB!=null) 
		{
			log.info("User Resource Found. ");
			return new ResponseEntity<UserDepartment>(userDeptDB,HttpStatus.OK);
		}
		else
		{
			throw new ResourceNotFoundException("Resource is Not Found For userId -> "+userId);
		}
	}
	@GetMapping(value ="/get-all-user-with-dept")
	public ResponseEntity<List<UserDepartment>> getAllUserWithDept()
	{
			log.info("getAllUser() method of UserController. ");
			List<UserDepartment> userDeptDbList = userService.getAllUserWithDept();
			if (!userDeptDbList.isEmpty()) 
			{
				log.info("List of User Resource Found. ");
				return new ResponseEntity<List<UserDepartment>>(userDeptDbList,HttpStatus.OK);
			}
			else
			{
				throw new ResourceNotFoundException("Resource is Not Found For userId ");
			}
	
	}
}
