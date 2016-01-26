package com.fantasybabymg.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fantasybabymg.action.common.BaseAction;
import com.fantasybabymg.service.back.vo.UserLoginVO;
@Controller
@Scope("prototype")
@RequestMapping("index")
public class IndexAction extends BaseAction{
	@RequestMapping(value="/show",method=RequestMethod.GET)
	public String showLogin(){
		//TODO
		return "index";
	}
}
