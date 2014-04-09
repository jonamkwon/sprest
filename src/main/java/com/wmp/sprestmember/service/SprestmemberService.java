package com.wmp.sprestmember.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wmp.sprestmember.dao.SprestmemberDao;
import com.wmp.sprestmember.model.Sprestmember;

@Service("SprestmemberService")
public class SprestmemberService {
	
	@Autowired
	private SprestmemberDao sprestmemberDao; 
	
	public Sprestmember getByS_no(int s_no){
		return sprestmemberDao.getByS_no(s_no);
	}

	public List<Sprestmember> selectSprestmember() {
		return sprestmemberDao.selectSprestmember();
	}

	public boolean deleteSprestmember(int s_no) {
		int checkDel = sprestmemberDao.deleteSprestmember(s_no);
		if(checkDel == 1){
			return true;
		}
		return false;
	}

	public int updateSprestmember(Sprestmember sprestmember) {
		return sprestmemberDao.updateSprestmember(sprestmember);
		
	}

	public int insertSprestmember(Sprestmember sprestmember) {
		return sprestmemberDao.insertSprestmember(sprestmember);
	}
	
}
