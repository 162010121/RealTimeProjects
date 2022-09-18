package com.akhm.service;

import com.akhm.service.dto.UserDTO;

public interface UserService
{
	
	public UserDTO insertUser(UserDTO userDTO);
	
	public UserDTO getUser(UserDTO userDTO);
	
	public UserDTO updateUser(UserDTO userDTO);
	
	public UserDTO getUser(String emailId);
	
	
	

}
