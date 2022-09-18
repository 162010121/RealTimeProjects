package com.akhm.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.akhm.exception.UserCustomException;
import com.akhm.service.UserService;
import com.akhm.service.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)

public class UserControllerTest 
{
	@InjectMocks
	private UserController userController;
	@Mock
	private UserService userService;
	@Test
	public void testRigestor()throws Exception
	{	
		UserVO userVO=mock(UserVO.class);
		when(userService.insertUser(Mockito.any())).thenReturn(userVO);
		ResponseEntity<UserVO> response=userController.rigestor(Mockito.any());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	
	@Test
	public void testLogin()throws Exception
	{	
		UserVO userVO=mock(UserVO.class);
		when(userService.getUser(Mockito.any(),Mockito.any())).thenReturn(userVO);
		ResponseEntity<UserVO> response=userController.login(userVO);
		assertNotNull(response.getBody());
	}
	public void testGetUserException() throws Exception
	{
		UserVO userVO=mock(UserVO.class);
		when(userService.getUser(Mockito.any(),Mockito.any())).thenReturn(userVO);
		ResponseEntity<UserVO> response=userController.rigestor(userVO);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
	@Test
	public void testGetUser() throws Exception
	{
		UserVO userVO=mock(UserVO.class);
		//when(userService.getUser(Mockito.any())).thenReturn(userVO);
		ResponseEntity<UserVO> response=userController.getUser(2);
		assertNotNull(response.getBody());
	}
	@Test
	public void testupdateUser() throws Exception
	{
		UserVO userVO=mock(UserVO.class);
		when(userService.updateUser(Mockito.any())).thenReturn(userVO);
		ResponseEntity<UserVO> response=userController.updateUser(Mockito.any());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	@Test
	public void testDeleteUser() throws Exception
	{
		doNothing().when(userService).deleteUser(Mockito.anyInt());
		ResponseEntity<Void> response=userController.deleteUser(12);
		assertEquals(HttpStatus.OK,response.getStatusCode());
	}
	@Test
	public void testGetallUser() throws Exception
	{
		List<UserVO> users=mock(List.class);
		when(userService.getallUsers()).thenReturn(users);
		ResponseEntity<List<UserVO>> response=userController.getallUser();
		assertNotNull(response.getBody());
	}
	
}