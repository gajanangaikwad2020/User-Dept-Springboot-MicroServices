package com.userdeptmicroserv.service;

import java.util.List;

import com.userdeptmicroserv.entity.Department;

public interface DepartmentService 
{

	public Department saveDept(Department department) ;

	public Department getDeptById(Long deptId);

	public List<Department> getAllDept();
	

}
