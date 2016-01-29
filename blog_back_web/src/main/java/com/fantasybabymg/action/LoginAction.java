package com.fantasybabymg.action;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fantasybabymg.action.common.BaseAction;
import com.fantasybabymg.bean.BlogUser;
import com.fantasybabymg.context.SystemContext;
import com.fantasybabymg.enumerate.ValidateStatusEnum;
import com.fantasybabymg.service.back.IUserService;
import com.fantasybabymg.service.back.vo.UserLoginVO;
import com.fantasybabymg.ubean.Criterion;
import com.fantasybabymg.util.constant.ActionReturnConst;
import com.fantasybabymg.util.constant.UserMessageConstant;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
@Controller
@RequestMapping("/login")
@Scope("prototype")
public class LoginAction extends BaseAction{
	@Autowired
	private  IUserService userService;
	@RequestMapping(value="/show",method=RequestMethod.GET)
	public String showLogin(){
		//TODO   has login logic
		
		return "login";
	}
	@RequestMapping(value="/validateLoginAjax",method=RequestMethod.POST)
	@ResponseBody
	public String validateLoginAjax(@ModelAttribute("userLogin") @Valid UserLoginVO userLogin,BindingResult result) throws JsonProcessingException{
		ObjectMapper om = new ObjectMapper();
		ObjectNode rebackJson = om.createObjectNode();
		rebackJson.put(UserMessageConstant.RETURN_ERROR_KEY, ValidateStatusEnum.NOTPASS.getValue());
		if(result.hasErrors()){
			List<ObjectError> allErrors = result.getAllErrors();
			rebackJson.put(UserMessageConstant.RETURN_ERROR_KEY, allErrors.get(0).getDefaultMessage());
			return om.writeValueAsString(rebackJson);
		}
		Criterion<Object> userCriterion = new Criterion<Object>();
		userCriterion.setCriterion(userLogin);
		SystemContext.setCriterionMap(userCriterion);
		BlogUser blogUser = userService.findUser();
		if(blogUser == null){
			rebackJson.put(UserMessageConstant.RETURN_ERROR_KEY,UserMessageConstant.USER_NOT_EXIST );
			return om.writeValueAsString(rebackJson);
		}else{
			if(userLogin.getPassword().equals(blogUser.getPassWord())){
				rebackJson.put(ValidateStatusEnum.PASS.name(),ValidateStatusEnum.PASS.getValue());
			}else{
				rebackJson.put(UserMessageConstant.RETURN_ERROR_KEY,UserMessageConstant.PASSWORD_NOT_RIGHT );
			}
			
			return om.writeValueAsString(rebackJson);
		}
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
