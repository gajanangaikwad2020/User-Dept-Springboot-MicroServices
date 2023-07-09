package com.userdeptmicroserv.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userdeptmicroserv.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>
{

//	User findByUserId(Long userId);;
}
