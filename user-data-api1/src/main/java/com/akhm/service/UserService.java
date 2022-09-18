package com.akhm.service;

import java.util.List;

import com.akhm.service.vo.UserVO;



public interface UserService {
	
	public UserVO insertUser(UserVO userVO);
	public UserVO getUser(String emailId, String password);
	public UserVO getUser(Integer userId);
	public UserVO updateUser(UserVO userVO);
	public void deleteUser(Integer userId);
	public List<UserVO> getallUsers();
	public UserVO getUser(String emailId);
	

}