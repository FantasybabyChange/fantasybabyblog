package com.fantasybabymg.action;

import java.util.List;

import javax.validation.Valid;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fantasybabymg.action.common.BaseAction;
import com.fantasybabymg.service.back.vo.UserLoginVO;
@Controller
@RequestMapping("/login")
@Scope("prototype")
public class LoginAction extends BaseAction{
	@RequestMapping(value="/show",method=RequestMethod.GET)
	public String showLogin(){
		//TODO
		
		return "login";
	}
	@RequestMapping(value="/validateLoginAjax",method=RequestMethod.POST)
	public String validateLoginAjax(){
		return null;
	}
	@RequestMapping(value="/validateLogin",method=RequestMethod.POST)
	public String validateLogin(@ModelAttribute("userLogin") @Valid UserLoginVO userlogin,BindingResult result,@RequestParam("sessionid")String sessionid){
		//TODO
		if(!session.getId().equals(sessionid)){
			return "login";
		}
		if(result.hasErrors()){
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError objectError : allErrors) {
				System.out.println(objectError.getDefaultMessage());
			}
//			req.setAttribute("errors", result.get);
			return "login";
		}
		System.out.println(userlogin.getRemember());
		if(session.getId().equals(sessionid)){
			return "/index";
		}
		return "/index";
	}
}
