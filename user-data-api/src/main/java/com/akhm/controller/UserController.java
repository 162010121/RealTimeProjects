package com.akhm.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akhm.service.UserService;
import com.akhm.service.vo.UserVO;


import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/reg")
	public ResponseEntity<UserVO> rigestor(@RequestBody UserVO userVO)
	{
		log.info("in UserController... rigestor()method started");
		try 
		{
			UserVO user=userService.insertUser(userVO);
			log.info("in UserController... rigestor() method user details are succesesfully rigestored");
			return new ResponseEntity<>(user,HttpStatus.OK);
			
		}
		catch (Exception e) 
		{
				log.error("in UserController rigestor()method erroraccured-{}",e);
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/getuser")
	public ResponseEntity<UserVO> getUser(@RequestParam Integer userId)
	{
		log.info("in UserController... login()method started");
		try 
		{
			
			UserVO userVO2=userService.getUser(userId);
			log.info("in UserController... login() method user details are succesesfully rigestored");
			return new ResponseEntity<>(userVO2,HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			log.error("in UserController login()method erroraccured-{}",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/login")
	public ResponseEntity<UserVO> login(@RequestBody UserVO userVO)
	{
		log.info("in UserController... login()method started");
		try 
		{
			
			UserVO userVO2=userService.getUser(userVO.getEmailId(),userVO.getPassword());
			log.info("in UserController... login() method user details are succesesfully rigestored");
			return new ResponseEntity<>(userVO2,HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			log.error("in UserController login()method erroraccured-{}",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/updateuser")
	public ResponseEntity<UserVO> updateUser(@RequestBody UserVO userVO)
	{
		log.info("in UserController... updateUser()method started");
		try 
		{
			UserVO user=userService.updateUser(userVO);
			log.info("in UserController... updateUser() method user details are succesesfully rigestored");
			return new ResponseEntity<>(user,HttpStatus.OK);
			
		} 
		catch (Exception e) 
		{
			log.error("in UserController updateUser()method erroraccured-{}",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer userId )
	
	{
		log.info("in UserController... deleteUser()method started");

		try 
		{	
			
			userService.deleteUser(userId);
			log.info("in UserController... deleteUser() method user details are succesesfully rigestored");

			return new ResponseEntity<>(HttpStatus.OK);
			
		}
		catch (Exception e) 
		{
			log.error("in UserController deleteUser()method erroraccured-{}",e);

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getusers")
	public ResponseEntity<List<UserVO>> getallUser()
	{
		log.info("in UserController... getallUser()method started");

		try 
		{
			log.info("in UserController... getallUser() method user details are succesesfully rigestored");

			List<UserVO> users=userService.getallUsers();
			return new ResponseEntity<>(users,HttpStatus.OK); 
		}
		catch (Exception e) 
		{
			log.error("in UserController getallUser()method erroraccured-{}",e);

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	@PostMapping("/getuserbyemailid")
	public ResponseEntity<UserVO> getUserByEmailId(@RequestBody String emailId)
	{
		log.info("in UserController... getUserByEmailId()method started");
		try {
			
			log.info("in UserController... getUserByEmailId() method user details are succesesfully rigestored");
				UserVO userVO=userService.getUser(emailId);
				return new ResponseEntity<>(userVO,HttpStatus.OK);
			
		} catch (Exception e) {
			
			log.error("in UserController getallUser()method erroraccured-{}",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
		
	}
}
