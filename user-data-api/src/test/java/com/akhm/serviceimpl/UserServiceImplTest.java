package com.akhm.serviceimpl;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.akhm.exception.UserCustomException;
import com.akhm.repository.UserEntityRepository;
import com.akhm.repository.entity.UserEntity;
import com.akhm.service.impl.UserServiceImpl;
import com.akhm.service.vo.UserVO;
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest 
{
	@InjectMocks
	private UserServiceImpl service;
	@Mock
	private UserEntityRepository repository;
	@Test
	public void testInsertUser()throws Exception
	{
		UserVO userVO=new UserVO();
		userVO.setUserId(10);
		userVO.setFullName("praveen");
		userVO.setEmailId("praveen@123");
		userVO.setPassword("131612");
		userVO.setMobileNumber("905985");
		userVO.setStatus("completed");
		
		UserEntity userEntity=new UserEntity();
		
		userEntity.setUserId(10);
		userEntity.setFullName(userVO.getFullName());
		userEntity.setEmailId(userVO.getEmailId());
		userEntity.setPassword(userVO.getPassword());
		userEntity.setMobileNumber(userVO.getMobileNumber());
		userEntity.setStatus(userVO.getStatus());
	
		when(repository.save(Mockito.any())).thenReturn(userEntity);
		UserVO user=service.insertUser(userVO);
		assertNotNull(user);
	
		
		
	}
	
		@Test(expected = UserCustomException.class)
	public void testInsertUserException()throws Exception
	{
		UserVO userVO=new UserVO();
		
		userVO.setFullName("praveen");
		userVO.setEmailId("praveen@123");
		userVO.setPassword("131612");
		userVO.setMobileNumber("905985");
		userVO.setStatus("completed");
		
		UserEntity userEntity=new UserEntity();
		
	
		userEntity.setFullName(userVO.getFullName());
		userEntity.setEmailId(userVO.getEmailId());
		userEntity.setPassword(userVO.getPassword());
		userEntity.setMobileNumber(userVO.getMobileNumber());
		userEntity.setStatus(userVO.getStatus());
	
		when(repository.save(null)).thenReturn(userEntity);
		UserVO user=service.insertUser(userVO);
		assertNotNull(user);
		
		
	
		
		
	}
		@Test
		public void testGetUserByUserNameAndPassword() throws Exception
		{
			UserEntity userEntity=Mockito.mock(UserEntity.class);
			when(repository.findByEmailIdAndPassword(Mockito.any(),Mockito.any())).thenReturn(userEntity);
			UserVO userVO=service.getUser("praveen@123","password");
			assertNotNull(userVO);
			
			
		}
		
		@Test
		public void testGetUserById() throws Exception
		{
			UserEntity userEntity=Mockito.mock(UserEntity.class);
			when(repository.findById(Mockito.anyInt())).thenReturn(Optional.of(userEntity));
			UserVO userVO=service.getUser(123);
			assertNotNull(userVO);
			
			
		}
		@Test
		public void testUpdateUser() throws Exception
		{
			UserEntity userEntity=Mockito.mock(UserEntity.class);
			when(repository.findById(Mockito.anyInt())).thenReturn(Optional.of(userEntity));
			when(repository.save(Mockito.any())).thenReturn(userEntity);
			UserVO userVO=Mockito.mock(UserVO.class);
			UserVO user=service.updateUser(userVO);
			assertNotNull(user);
			
		}
		@Test
		public void testDeleteUser() throws Exception
		{
			UserEntity userEntity=Mockito.mock(UserEntity.class);
			//when(repository.save(userEntity)).thenReturn(userEntity);
			when(repository.findById(Mockito.anyInt())).thenReturn(Optional.of(userEntity));
			doNothing().when(repository).delete(userEntity);
			service.deleteUser(Mockito.anyInt());
			assertTrue(true);			
		}
		@Test
		public void testGetallUsersNull() throws Exception
		{
			List<UserEntity> userslist=Mockito.mock(List.class);
			when(repository.findAll()).thenReturn(userslist);
			List<UserVO> users=service.getallUsers();
			assertNull(users);
			
		}
		@Test
		public void testGetallUsersNotNull() throws Exception
		{
			List<UserEntity> userslist=new ArrayList<>();
			UserEntity user1=new UserEntity();
			UserEntity user2=new UserEntity();
			userslist.add(user1);
			userslist.add(user2);
			when(repository.findAll()).thenReturn(userslist);
			List<UserVO> users=service.getallUsers();
			assertNotNull(users);
			
		}
		
	
	
	
}