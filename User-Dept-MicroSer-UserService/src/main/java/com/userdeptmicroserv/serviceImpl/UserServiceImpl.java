package com.userdeptmicroserv.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.userdeptmicroserv.entity.User;
import com.userdeptmicroserv.model.Department;
import com.userdeptmicroserv.model.UserDepartment;
import com.userdeptmicroserv.repo.UserRepo;
import com.userdeptmicroserv.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public User saveUser(User user) 
	{
		return userRepo.save(user);
	}

	@Override
	public UserDepartment getUserByIdWithDept(Long userId) 
	{
		UserDepartment userDepartment=new UserDepartment();
		User userDb = userRepo.findById(userId).get();
//		User userDb = userRepo.findByUserId(userId);  
		Department deptObject = restTemplate.getForObject("http://Department-Service/dept/get-dept-by-id/"+userDb.getDeptId(),Department.class);
//		Department deptObject = restTemplate.getForObject("http://localhost:9093/dept/get-dept-by-id/"+userDb.getDeptId(),Department.class);
		
		userDepartment.setUser(userDb);
		userDepartment.setDepartment(deptObject);
		return userDepartment;
	}

	@Override
	public List<UserDepartment> getAllUserWithDept() 
	{
		List<User> userDbList = userRepo.findAll();
		List<UserDepartment> userDeptList=new ArrayList<>();
		for (User user : userDbList) 
		{
			Department department = restTemplate.getForObject("http://Department-Service/dept/get-dept-by-id/"+user.getDeptId(),Department.class);
//			Department department = restTemplate.getForObject("http://localhost:9093/dept/get-dept-by-id/"+user.getDeptId(),Department.class);
			
			UserDepartment userDepartmentList2=new UserDepartment();
			userDepartmentList2.setUser(user);
			userDepartmentList2.setDepartment(department);
			userDeptList.add(userDepartmentList2);
		}
		return userDeptList;
	}
	

}
