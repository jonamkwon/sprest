package com.wmp.user.service;

import java.util.HashMap;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.wmp.user.dao.UserDao;
import com.wmp.user.model.User;

@Service("UserService")
public class UserService {
	
	@Autowired
	private UserDao userDao; 
	
	public void insertAuthority(@Param("email") String email,@Param("authority") String authority) {
		HashMap<String, String> hashmap = new HashMap<String, String>();
		hashmap.put("email", email);
		hashmap.put("authority", authority);
		userDao.insertAuthority(hashmap);
	}
	
	public void deleteAuthority(@Param("email") String email) {
		userDao.deleteAuthority(email);
	}
	
	public int insert(User user) {
		return userDao.insert(user);
	}

	public User login(String email, String passwd) {
		HashMap<String, String> hashmap = new HashMap<String, String>();
		hashmap.put("email", email);
		hashmap.put("passwd", passwd);
		return userDao.login(hashmap);
	}
	
	public int modify(User user) {
		return userDao.modify(user);
	}
	
	public void changePasswd(User user) {
		userDao.changePasswd(user);
	}
	
	public void deleteUser(String email) {
		userDao.deleteUser(email);
	}

	//이메일로 회원를 찾는다.
	
	public User getUserByEmail(String email){
		return userDao.getUserByEmail(email);
	}
	
}
