	package com.akhm.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhm.exception.UserCustomException;
import com.akhm.repository.UserEntityRepository;
import com.akhm.repository.entity.UserEntity;
import com.akhm.service.UserService;
import com.akhm.service.vo.UserVO;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class UserServiceImpl implements UserService
{	
	//private static final Logger logger=LogManager.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserEntityRepository repository;
	@Override
	public UserVO insertUser(UserVO userVO) 
	{
		log.info("in UserServiceImpl...insertUser() method is started");
		//logger.info("in UserServiceImpl...insertUser() method is started");
		try
		{
			UserEntity userEntity=new UserEntity();
			userEntity.setUserId(userVO.getUserId());
			userEntity.setFullName(userVO.getFullName());
			userEntity.setEmailId(userVO.getEmailId());
			userEntity.setPassword(userVO.getPassword());
			userEntity.setMobileNumber(userVO.getMobileNumber());
			userEntity.setStatus(userVO.getStatus());
			UserVO user=new UserVO();
			UserEntity entity=repository.save(userEntity);
			user.setUserId(entity.getUserId());
			user.setFullName(entity.getFullName());
			user.setEmailId(entity.getEmailId());
			user.setPassword(entity.getPassword());
			user.setMobileNumber(entity.getMobileNumber());
			user.setStatus(entity.getStatus());
			log.info("in UserServiceImpl...insertUser()method user details are succsesfully inserted");
			return user;
		}
		catch (Exception e) 
		{
			log.error("in UserServiceImpl...insertUser()method user details inserted fail-{}",e);
			throw new UserCustomException(e.getMessage());
		}
	
	}

	@Override
	public UserVO getUser(String emailId, String password)
	{
		UserVO userVO=null;
		try 
		{
			log.info("in UserServiceImpl...getUser()method started");
			UserEntity userEntity=repository.findByEmailIdAndPassword(emailId,password);
			log.info("in UserServiceImpl...getUser()method user detail are succesesfully loaded from database");
			if(userEntity!=null)
			{
				log.info("in UserServiceImpl...getUser()method user deatils found");
				userVO=new UserVO();
				userVO.setUserId(userEntity.getUserId());
				userVO.setFullName(userEntity.getFullName());
				userVO.setEmailId(userEntity.getEmailId());
				userVO.setPassword(userEntity.getPassword());
				userVO.setMobileNumber(userEntity.getMobileNumber());
				userVO.setStatus(userEntity.getStatus());
			}
		}
		catch (Exception e)
		{
			log.error("in UserServiceImpl...getUser()method exception accured-{}",e);
			throw new UserCustomException(e.getMessage());
		}
		return userVO;
	}

	@Override
	public UserVO getUser(Integer userId) 
	{	UserVO userVO=null;
		try 
		{
			log.info("in UserServiceImpl...getUser()method started");
			UserEntity userEntity=repository.findById(userId).get();
			log.info("in UserServiceImpl...getUser()method user detail are succesesfully loaded from database");
			if(userEntity!=null)
			{
				log.info("in UserServiceImpl...getUser()method user deatils found");
				userVO=new UserVO();
				userVO.setUserId(userEntity.getUserId());
				userVO.setFullName(userEntity.getFullName());
				userVO.setEmailId(userEntity.getEmailId());
				userVO.setPassword(userEntity.getPassword());
				userVO.setMobileNumber(userEntity.getMobileNumber());
				userVO.setStatus(userEntity.getStatus());
		}
	}
		catch (Exception e) 
		{
			log.error("in UserServiceImpl...getUser()method exception accured-{}",e);
			throw new UserCustomException(e.getMessage());
		}
		return userVO;
	}

	@Override
	public UserVO updateUser(UserVO userVO) {
		
		try {
					UserEntity userEntity=repository.findById(userVO.getUserId()).get();
					if (userEntity !=null) {
						
						
						userEntity.setFullName(userVO.getFullName());
						userEntity.setEmailId(userVO.getEmailId());
						userEntity.setMobileNumber(userVO.getMobileNumber());
						userEntity.setPassword(userVO.getPassword());
						userEntity.setStatus(userVO.getStatus());
						repository.save(userEntity);
						return userVO;
					}
			
		} catch (Exception e) {
			
			throw new UserCustomException(e.getMessage());
		}
		
		
		return null;
	}

	@Override
	public void deleteUser(Integer userId) {
		
		
		try {
			UserEntity entity=repository.findById(userId).get();
			repository.delete(entity);
		} catch (Exception e)
		{
		throw new UserCustomException(e.getMessage());
		}
		
	}

	@Override
	public List<UserVO> getallUsers() {
		
		try {
			List<UserVO> users=null;
			
			List<UserEntity> usersList=repository.findAll();
			
			if (usersList !=null && usersList.size()>0) {
				
				users=new ArrayList<>();
				for(UserEntity userEntity:usersList)
				{
					UserVO userVO=new UserVO();
					userVO.setUserId(userEntity.getUserId());
					userVO.setFullName(userEntity.getFullName());
					userVO.setMobileNumber(userEntity.getMobileNumber());
					userVO.setPassword(userEntity.getPassword());
					userVO.setStatus(userEntity.getStatus());
					users.add(userVO);
					
				}
				
			}
			
			return users;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			
			throw new UserCustomException(e.getMessage());
		}
				
	}

	@Override
	public UserVO getUser(String emailId) {
		
		UserVO userVO=null;
		
		try {
			
				UserEntity userEntity=repository.findByEmailId(emailId);
				if(userEntity !=null)
				{
					userVO=new UserVO();
					userVO.setUserId(userEntity.getUserId());
					userVO.setFullName(userEntity.getFullName());
					userVO.setEmailId(userEntity.getEmailId());
					userVO.setMobileNumber(userEntity.getMobileNumber());
					userVO.setPassword(userEntity.getPassword());
					userVO.setStatus(userEntity.getStatus());
					
					
					
				}
				
				
				
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new UserCustomException(e.getMessage());
		}
		return userVO;
		
		
		
		
	}


	

}