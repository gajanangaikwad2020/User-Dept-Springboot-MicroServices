package com.userdeptmicroserv.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long deptId;
	private String deptName;
	private String deptAddress;
	private String deptCode;
	
}
