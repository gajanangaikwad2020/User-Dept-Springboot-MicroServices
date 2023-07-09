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

import com.userdeptmicroserv.entity.Department;
import com.userdeptmicroserv.exception.ResourceNotFoundException;
import com.userdeptmicroserv.exception.SomethingWentWrongException;
import com.userdeptmicroserv.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/dept")
@Slf4j
public class DepartmentController 
{
	@Autowired
	private DepartmentService departmentService;
	@PostMapping(value ="/save-dept")
	public ResponseEntity<String> saveDept(@RequestBody Department department)
	{
		log.info("SaveDept() method of DepartmentController. ");
		Department deptDB = departmentService.saveDept(department);
		if (deptDB!=null) 
		{
			return new ResponseEntity<String>("Dept is Saved.",HttpStatus.CREATED);
		}
		else
		{
			throw new SomethingWentWrongException("Something Went Wrong Exception Occure, Please try again");
		}
	}
	
	@GetMapping(value ="/get-dept-by-id/{deptId}")
	public ResponseEntity<Department> getDeptById(@PathVariable Long deptId)
	{
		log.info("getDeptById() method of DepartmentController. ");
		Department deptDB = departmentService.getDeptById(deptId);
		if (deptDB!=null) 
		{
			log.info("Department Resource Found. ");
			return new ResponseEntity<Department>(deptDB,HttpStatus.OK);
		}
		else
		{
			throw new ResourceNotFoundException("Resource is Not Found For deptId -> "+deptId);
		}
	}
	@GetMapping(value ="/get-all-dept")
	public ResponseEntity<List<Department>> getAllDept()
	{
			log.info("getAllDept() method of DepartmentController. ");
			List<Department> deptDBList = departmentService.getAllDept();
			if (!deptDBList.isEmpty()) 
			{
				log.info("List of Department Resource Found. ");
				return new ResponseEntity<List<Department>>(deptDBList,HttpStatus.OK);
			}
			else
			{
				throw new ResourceNotFoundException("Resource is Not Found For deptId ");
			}
	
	}

}
