package com.wmp.sprestmember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wmp.sprestmember.model.Sprestmember;
import com.wmp.sprestmember.service.SprestmemberService;



@Controller
public class SprestmemberController {
	
	@Autowired
	private SprestmemberService sprestmemberService;
	
	/*
	 * POST to Create
	 */
	@RequestMapping(value="/sprestmember/new", method=RequestMethod.POST)
	@ResponseBody
	public int newSprestmember(@RequestBody Sprestmember sprestmember) {
		return sprestmemberService.insertSprestmember(sprestmember);
	}
	
	/*
	 * GET to Retrieve
	 * sprestmember의 리스트
	 */
	@RequestMapping(value="/sprestmember", method=RequestMethod.GET)
	@ResponseBody
	public List<Sprestmember> getSprestmemberList() {
		List<Sprestmember> list = sprestmemberService.selectSprestmember();
	    return list;
	}

	/*
	 * GET to Retrieve
	 * sprestmember 하나의 row
	 */
	@RequestMapping(value="/sprestmember/{s_no}", method=RequestMethod.GET)
	@ResponseBody
	public Sprestmember getSprestmember(@PathVariable("s_no") int s_no) {
		
	    return sprestmemberService.getByS_no(s_no);
	}

	/*
	 * PUT to Update
	 * sprestmember 하나의 row 업데이트
	 */
	@RequestMapping(value="/sprestmember/", method=RequestMethod.PUT)
	@ResponseBody
	public int updateSprestmember(@RequestBody Sprestmember sprestmember) {
		System.out.println(sprestmember.toString());
		int result = sprestmemberService.updateSprestmember(sprestmember);
		return result;
	}
	
	/*
	 * DELETE to Delete
	 * sprestmember 하나의 row 삭제
	 */
	@RequestMapping(value="/sprestmember/{s_no}", method=RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteSprestmember(@PathVariable("s_no") int s_no) {
		boolean result = sprestmemberService.deleteSprestmember(s_no);
		return result;
	}
	
}
