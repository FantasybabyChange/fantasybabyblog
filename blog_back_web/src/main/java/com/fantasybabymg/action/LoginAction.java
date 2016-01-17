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
import com.fantasybabymg.util.constant.ActionReturnConst;
@Controller
@RequestMapping("/login")
@Scope("prototype")
public class LoginAction extends BaseAction{
	@RequestMapping(value="/show",method=RequestMethod.GET)
	public String showLogin(){
		//TODO   has login logic
		
		return "login";
	}
	@RequestMapping(value="/validateLoginAjax",method=RequestMethod.POST)
	public String validateLoginAjax(@ModelAttribute("userLogin") @Valid UserLoginVO userlogin,BindingResult result){
		
		return null;
	}
	@RequestMapping(value="/validateLogin",method=RequestMethod.POST)
	public String validateLogin(@ModelAttribute("userLogin") @Valid UserLoginVO userlogin,BindingResult result,@RequestParam("sessionid")String sessionid){
		//TODO
		if(!session.getId().equals(sessionid)){
			return ActionReturnConst.REDIRECT+"show";
		}
		if(result.hasErrors()){
			List<ObjectError> allErrors = result.getAllErrors();
			req.setAttribute("errors", allErrors.get(0).getDefaultMessage());
			return "login";
		}
		return ActionReturnConst.REDIRECT+"/index/show";
	}
}
