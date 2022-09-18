package com.akhm.service.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserVO implements Serializable
{
	private static final long serialVersionUID=10L;
	private Integer userId;
	private String fullName;
	private String emailId;
	private String password;
	private String status;
	private String mobileNumber;
	

}