package com.wmp.sprestmember.dao;

import java.util.HashMap;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wmp.sprestmember.model.Sprestmember;
import com.wmp.sprestmember.model.User;

@Repository("sprestmember")
public class SprestmemberDao extends SqlSessionDaoSupport {
	
	public Sprestmember getByS_no(int s_no) {
		return (Sprestmember) getSqlSession().selectOne("SprestMapper.selectByS_no", s_no);
	}
	
}
