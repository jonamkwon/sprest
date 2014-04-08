package com.wmp.user.dao;

import java.util.HashMap;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wmp.user.model.User;

@Repository("userDao")
public class UserDao extends SqlSessionDaoSupport {
	
	public void insertAuthority(HashMap<String, String> hashmap) {
		getSqlSession().insert("UserMapper.insertAuthority", hashmap);
	}
	
	public void deleteAuthority(String email) {
		getSqlSession().delete("UserMapper.deleteAuthority", email);
	}
	
	public int insert(User user) {
		System.out.println(user.toString());
		return getSqlSession().insert("UserMapper.insert", user);
	}

	public User login(HashMap<String, String> hashmap) {
		return (User) getSqlSession()
				.selectOne("UserMapper.login", hashmap);
	}
	
	public int modify(User user) {
		return getSqlSession().update("UserMapper.modify", user);
	}
	
	public int changePasswd(User user) {
		return getSqlSession().update("UserMapper.changePasswd", user);
	}

	public int deleteUser(String email) {
		return getSqlSession().delete("UserMapper.deleteUser", email);
	}
	
	public User getUserByEmail(String email) {
		return (User) getSqlSession().selectOne("UserMapper.selectUserByEmail", email);
	}
	
}
