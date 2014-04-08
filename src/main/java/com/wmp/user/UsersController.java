package com.wmp.user;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wmp.user.model.User;
import com.wmp.user.service.UserService;



@Controller
public class UsersController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/users/{userId}", method=RequestMethod.GET)
	@ResponseBody
	public User getItem(@PathVariable("userId") String userId) {
		
	    return userService.getUserByEmail(userId);
	}
//
//	@RequestMapping(value="/users", method=RequestMethod.GET)
//	@ResponseBody
//	public List getItems() {
//	    return userService.selectItems();
//	}
}
