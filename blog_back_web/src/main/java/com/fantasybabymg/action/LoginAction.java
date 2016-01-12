package com.fantasybabymg.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fantasybabymg.action.common.BaseAction;
import com.fantasybabymg.bean.BlogUser;
@Controller
@Scope("prototype")
public class LoginAction extends BaseAction{
	@RequestMapping(name="/login/show",method=RequestMethod.GET)
	public String showLogin(){
		//TODO
		
		return "login";
	}
	@RequestMapping(name="/login/validateAjax",method=RequestMethod.POST)
	public String validateLoginAjax(){
		return null;
	}
	@RequestMapping(name="/login/validateAjax",method=RequestMethod.POST)
	public String validateLogin(@ModelAttribute(value) BlogUser bloguser){
		return null;
	}
}
