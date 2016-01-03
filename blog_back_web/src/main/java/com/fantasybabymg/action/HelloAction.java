package com.fantasybabymg.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fantasybabymg.action.common.BaseAction;

@Controller
@RequestMapping("/hello")
@Scope("prototype")
public class HelloAction extends BaseAction{
	@RequestMapping("/helloworld")
	public String helloWord(){
		req.setAttribute("hello", "刘曦");
		return "hello";
	}

}
