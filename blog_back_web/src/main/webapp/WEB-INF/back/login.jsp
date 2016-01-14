<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- BEGIN HEAD -->
<head>
<title>Admin Login</title>
	<meta content="" name="description"/>
	<meta content="" name="author"/>
	<%@include file="common/head.jsp" %>
	<!-- BEGIN THEME STYLES -->
	<link href="<%=commonCssPath %>style-conquer.css" rel="stylesheet" type="text/css"/>
	<link href="<%=commonCssPath %>style.css" rel="stylesheet" type="text/css"/>
	<link href="<%=commonCssPath %>style-responsive.css" rel="stylesheet" type="text/css"/>
	<link href="<%=commonCssPath %>plugins.css" rel="stylesheet" type="text/css"/>
	<link href="<%=commonCssPath %>themes/blue.css" rel="stylesheet" type="text/css" id="style_color"/>
	<link href="<%=commonCssPath %>pages/login.css" rel="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->
</head>
<body>
<!-- BEGIN BODY -->
<body class="login">
<!-- BEGIN LOGO -->
<div class="logo">
	<img src="<%=commonImagePath%>logo.png" alt="fantasybaby"/>
</div>
<!-- END LOGO -->
<!-- BEGIN LOGIN -->
<div class="content">
	<!-- BEGIN LOGIN FORM -->
	<form class="login-form" action="validateLogin?redirectURL=" method="post">
		<h3 class="form-title">登陆到管理员</h3>
		<div class="alert alert-error display-hide">
			<button class="close" data-close="alert"></button>
			<span>
				 Enter any username and password.
			</span>
		</div>
		<div class="form-group">
			<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
			<label class="control-label visible-ie8 visible-ie9">Username</label>
			<div class="input-icon">
				<i class="fa fa-user"></i>
				<input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="用户名" name="username"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label visible-ie8 visible-ie9">Password</label>
			<div class="input-icon">
				<i class="fa fa-lock"></i>
				<input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="密码" name="password"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label visible-ie8 visible-ie9">Password</label>
			<div class="input-icon">
				<i class="fa fa-lock"></i>
				<input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="验证码" name="verifycode"/>
				<input type="hidden" name="sessionid" value="<%=session.getId() %>"/>
			</div>
		</div>
		<div class="form-actions">
			<label class="checkbox">
			<input type="checkbox" name="remember" value="1"/> Remember me </label>
			<button type="submit" class="btn btn-info pull-right">
			Login </button>
		</div>
	</form>
	<!-- END LOGIN FORM -->
</div>
<!-- END LOGIN -->
<%@include file="common/copy_right.jsp" %>
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="assets/plugins/respond.min.js"></script>
<script src="assets/plugins/excanvas.min.js"></script> 
<![endif]-->
<script src="<%=commonJSPath %>jquery/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="<%=commonJSPath %>bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=commonJSPath %>plugins/jquery.blockui.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="<%=commonJSPath %>plugins/jquery-validation/jquery.validate.min.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="<%=commonJSPath %>back/login.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
jQuery(document).ready(function() {     
  Login.init();
});
</script>
<!-- END JAVASCRIPTS -->
</body>
</html>