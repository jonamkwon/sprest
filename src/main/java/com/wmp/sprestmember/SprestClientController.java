package com.wmp.sprestmember;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.wmp.sprestmember.model.Sprestmember;


@Controller
public class SprestClientController {
	
	@Resource(name="restTemplate")
	protected RestTemplate restTemplate;
	
	public void goList(Model model) {
		String url = "http://192.168.0.140:8080/sprest/sprestmember";
		List<Sprestmember> list = restTemplate.getForObject(url, ArrayList.class);
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value="/goServer")
	public String goServer(Model model) {
	
		goList(model);
		return "index";
	}
	
	@RequestMapping(value="/goView", method=RequestMethod.POST)
	public String goView(@RequestParam(value="s_no", defaultValue="0") int s_no, 
			Model model) {
		HashMap<String, String> result = new HashMap<String, String>();
		String rs = "";
		if(s_no != 0) {
			String url = "http://192.168.0.140:8080/sprest/sprestmember/"+s_no;
			rs = restTemplate.getForObject(url, String.class);
		    result = restTemplate.getForObject(url, HashMap.class);
		    model.addAttribute("rs", rs);
		    model.addAttribute("s_no", s_no);
			model.addAttribute("result", result);
		}

		goList(model);
		return "index";
	}
	
	@RequestMapping(value="/goUpdate", method=RequestMethod.POST)
	public String goUpdate(@RequestParam(value="getName", required=false) String name,
			@RequestParam(value="getAge", defaultValue="0") int age,
			@RequestParam(value="getS_no", defaultValue="0") int s_no,
			Model model) {
		Sprestmember sprestmember = new Sprestmember();
		HashMap<String, String> result = new HashMap<String, String>();
		
		sprestmember.setName(name);
		sprestmember.setAge(age);
		sprestmember.setS_no(s_no);
		
		
		//System.out.println(sprestmember.toString());
		if(name != null || age != 0) {
			String url = "http://192.168.0.140:8080/sprest/sprestmember/";
			restTemplate.put(url, sprestmember);
			result.put("name", sprestmember.getName());
			result.put("age", ""+sprestmember.getAge());
			result.put("s_no", ""+sprestmember.getS_no());
			model.addAttribute("message", "updatecomplete");
		}
		goList(model);
		return "index";
	}
	
	@RequestMapping(value="/goInsert", method=RequestMethod.POST)
	public String goInsert(@RequestParam(value="getName", required=false) String name,
			@RequestParam(value="getAge", defaultValue="0") int age,
			Model model) {
	
		Sprestmember sprestmember = new Sprestmember();
		HashMap<String, String> result = new HashMap<String, String>();
		
		sprestmember.setName(name);
		sprestmember.setAge(age);
		
		//System.out.println(sprestmember.toString());
		if(name != null || age != 0) {
			String url = "http://192.168.0.140:8080/sprest/sprestmember/new";
			restTemplate.postForLocation(url, sprestmember);
			model.addAttribute("message", "insertcomplete");
		
		}
		goList(model);
		return "index";
	}
	
	@RequestMapping(value="/goDelete", method=RequestMethod.POST)
	public String goDelete(@RequestParam(value="getS_no", defaultValue="0") int s_no, 
			Model model) {
		
		if(s_no != 0) {
			String url = "http://192.168.0.140:8080/sprest/sprestmember/"+s_no;
			restTemplate.delete(url);
			model.addAttribute("message", "deletecomplete");
		}
		goList(model);
		return "index";
	}
	
}
