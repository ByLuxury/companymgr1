<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<meta charset="UTF-8">
	<title>增值税管理系统首页</title>
	<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
	<div id="all">
		<div id="mainbody">
			<h2 style="padding-left: 90px;padding-top: 20px;color: #383838">增值税管理系统首页</h2>
			<div id="fmbody">
				<h3 style="color: #383838">用户名:</h3>
				<form action="/companymgr1/login" method="post">
					<input placeholder="请输入4~15位的账号" type="text" name="uname" id="username"  onblur="checkformname()"><span id="sname" class="frbule"></span><br>
					<h3 style="color: #383838">密码:</h3>
					<input placeholder="请输入密码:4~20位" type="password" name="pwd" id="pwd" onblur ="checkpwd()"><span id="spwd" class="frbule"></span>
					<br><br>
					<!-- <input type="radio" name="work" value="财务人员">财务人员
					<input type="radio" name="work" value="管理层">管理层<br><br> -->
					<input type="submit" value="登陆">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<button type="submit" formaction="/companymgr1/reg" method="post">注册</button>
				</form>
			</div>
		</div>
	
	</body>
</html>