<%@page import="com.fantasybabymg.enumerate.SymbolEnum"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="utf-8"/>
<meta name="MobileOptimized" content="320">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<%
 String contextPath = request.getContextPath(); 
 String commonJSPath = contextPath + SymbolEnum.SLASH.getValue()+"js"+SymbolEnum.SLASH.getValue();
 String commonCssPath = contextPath +SymbolEnum.SLASH.getValue()+ "css"+SymbolEnum.SLASH.getValue();
 String commonImagePath = contextPath +SymbolEnum.SLASH.getValue()+ "image"+SymbolEnum.SLASH.getValue();
%>
<link rel="icon" href="<%=commonImagePath %>logo_small.ico" mce_href="assets/img/logo_small.ico" type="image/x-icon">
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="<%=commonJSPath%>plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="<%=commonJSPath %>bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
