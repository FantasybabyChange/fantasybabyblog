package com.fantasybabymg.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
@Scope("prototype")
public class HelloAction {
	@RequestMapping("/helloworld")
	public String helloWord(HttpServletRequest req, HttpServletResponse resp){
		req.setAttribute("hello", "刘曦");
		return "hello";
	}

}
