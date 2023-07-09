package com.userdeptmicroserv.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Department 
{
	
	private Long deptId;
	private String deptName;
	private String deptAddress;
	private String deptCode;
	
}
