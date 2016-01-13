package com.fantasybabymg.action.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseAction {
   protected static HttpServletRequest req;
   protected static HttpServletResponse res;
   protected static HttpSession session;
   
   @ModelAttribute
	public void setReqAndRes(HttpServletRequest request,
			HttpServletResponse response) {
		req = request;
		res = response;
		session = request.getSession();
	}
}
