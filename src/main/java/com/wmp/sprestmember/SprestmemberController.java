package com.wmp.sprestmember;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wmp.sprestmember.model.Sprestmember;
import com.wmp.sprestmember.model.User;
import com.wmp.sprestmember.service.SprestmemberService;



@Controller
public class SprestmemberController {
	
	@Autowired
	private SprestmemberService sprestmemberService;
	
	@RequestMapping(value="/sprestmember/{s_no}", method=RequestMethod.GET)
	@ResponseBody
	public Sprestmember getItem(@PathVariable("s_no") int s_no) {
		
	    return sprestmemberService.getByS_no(s_no);
	}
//
//	@RequestMapping(value="/users", method=RequestMethod.GET)
//	@ResponseBody
//	public List getItems() {
//	    return userService.selectItems();
//	}
}
