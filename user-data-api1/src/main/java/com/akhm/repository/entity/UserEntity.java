package com.akhm.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;

@Entity
@Table(name="User_Tl")
@Data
public class UserEntity {
	
	@Id
	@Column(name="User_Id")
	@GeneratedValue
	private Integer userId;
	@Column(name="full_Name")
	private String fullName;
	@Column(name="email_Id")
	private String emailId;
	@Column(name="password")
	private String password;
	@Column(name="status")
	private String status;
	@Column(name="mobileNumber")
	private String mobileNumber;
	
	
	

}