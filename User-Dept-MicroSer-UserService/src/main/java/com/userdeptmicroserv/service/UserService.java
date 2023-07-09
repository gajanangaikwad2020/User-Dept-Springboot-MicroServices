package com.userdeptmicroserv.service;

import java.util.List;

import com.userdeptmicroserv.entity.User;
import com.userdeptmicroserv.model.UserDepartment;

public interface UserService 
{
	public User saveUser(User user);

	public UserDepartment getUserByIdWithDept(Long userId);

	public List<UserDepartment> getAllUserWithDept();

}
