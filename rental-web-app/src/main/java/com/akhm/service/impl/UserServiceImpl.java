package com.akhm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhm.fiegnclient.UserClient;
import com.akhm.service.UserService;
import com.akhm.service.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserClient userClient;
	
	
	@Override
	public UserDTO insertUser(UserDTO userDTO) {
		
		log.info("In UserServiceImpl....insert() method Started");
		
		return userClient.saveUser(userDTO);
	}


	@Override
	public UserDTO getUser(UserDTO userDTO) {
		
		log.info("In UserServiceImpl....getuser() method Started");
		
		return userClient.getUser(userDTO);
	}


	@Override
	public UserDTO updateUser(UserDTO userDTO) {
		
		log.info("In UserServiceImpl....updateuser() method Started");
		return userClient.updateUser(userDTO);
	}


	@Override
	public UserDTO getUser(String emailId) {
		
		log.info("In UserServiceImpl....getuser() method Started");
		
		return userClient.getUser(emailId);
	}
	
	
	
}
