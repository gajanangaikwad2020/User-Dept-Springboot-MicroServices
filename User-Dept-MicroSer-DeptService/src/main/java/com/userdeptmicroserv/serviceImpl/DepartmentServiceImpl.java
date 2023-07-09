package com.userdeptmicroserv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.userdeptmicroserv.entity.Department;
import com.userdeptmicroserv.repo.DepartmentRepo;
import com.userdeptmicroserv.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService
{
	@Autowired
	private DepartmentRepo departmentRepo;
	
	@Override
	public Department saveDept(Department department) 
	{
		return departmentRepo.save(department);
	}

	@Override
	public Department getDeptById(Long deptId) 
	{
		 Department department = departmentRepo.findById(deptId).get();
		 return department;
	}

	@Override
	public List<Department> getAllDept() 
	{
		
		return departmentRepo.findAll();
	}

}
