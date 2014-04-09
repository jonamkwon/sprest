package com.wmp.sprestmember.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.wmp.sprestmember.model.Sprestmember;

@Repository("sprestmember")
public class SprestmemberDao extends SqlSessionDaoSupport {
	
	public Sprestmember getByS_no(int s_no) {
		return (Sprestmember) getSqlSession().selectOne("SprestMapper.selectByS_no", s_no);
	}

	@SuppressWarnings("unchecked")
	public List<Sprestmember> selectSprestmember() {
		return getSqlSession().selectList("SprestMapper.selectSprestmember");
	}

	public int deleteSprestmember(int s_no) {
		return getSqlSession().delete("SprestMapper.deleteSprestmember", s_no);
	}

	public int updateSprestmember(Sprestmember sprestmember) {
		return getSqlSession().update("SprestMapper.updateSprestmember", sprestmember);
	}

	public int insertSprestmember(Sprestmember sprestmember) {
		return getSqlSession().insert("SprestMapper.insertSprestmember", sprestmember);
	}
	
}
