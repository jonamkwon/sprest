package com.wmp.sprestmember.service;

import java.util.HashMap;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.wmp.sprestmember.dao.SprestmemberDao;
import com.wmp.sprestmember.model.Sprestmember;
import com.wmp.sprestmember.model.User;

@Service("SprestmemberService")
public class SprestmemberService {
	
	@Autowired
	private SprestmemberDao sprestmember; 
	
	//이메일로 회원를 찾는다.
	
	public Sprestmember getByS_no(int s_no){
		return sprestmember.getByS_no(s_no);
	}
	
}
