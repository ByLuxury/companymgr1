<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat,java.util.Date" %>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/companymgr1/css/home.css">
	<meta charset="UTF-8">
	<title>欢迎来到增值税系统操作界面</title>
	<script type="text/javascript" src="/companymgr1/js/home.js"></script>
</head>
<body>
	<div id="all">
			<div id="menu">
				<ul>
				<li><a href="javascript:void(0)" onclick="link()">在线帮助</a>
				<li class="menuDiv">
				<li><a href="javascript:void(0)" onclick="link()">联系我们</a>
				<li class="menuDiv">
				<li><a href="/companymgr1/return">退出</a>
				<li class="menuDiv">
			</ul>
			</div>
			<div id="header">
				<div id="logo">
				</div>	
			</div>
			<div id="light" class="white_content"> 
			<a href="javascript:void(0)" onclick="tip()"> 
						<div id="close"></div>
					</a>
				<div id="online">		
					<div id="inform">
					<h2 style="color: #FFFFE0">联系人：丑八怪</h2>
					<h3 style="color: #FFFFE0">联系电话：123456789</h3>
					<h3 style="color: #FFFFE0">QQ：123456789</h3>
				</div>
				</div>
			</div> 
		<div id="fade"  class="black_overlay">
		</div>
		<div id="mainbody">
			<div id="leftbody">
				<ul style="margin-top: 50px">
				<%			//登录时间
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date d =new Date(session.getCreationTime()); %>
					<li><h2 style="color: #505050">欢迎来到管理员界面</h2></li>
					<li><h3>姓名：<%=session.getAttribute("username") %></h3></li>
					<li><h3>工号：<%=session.getAttribute("userid") %></h3></li>
					<li><h3>登陆时间：<br><%=sdf.format(d)%></h3></li>
				</ul>
			</div>
			<div id="middle">
				<hr size=330 width="1" color="#999999">
			</div>
			<div  id="rightbody">
					<div id="add"><a href="/companymgr1/admin/add.jsp" ><span style="position: absolute;top: 210px;left: 80px;font-size: 20px">增加</span></a></div>
					<div id="del"><a href="/companymgr1/admin/del.jsp" ><span style="position: absolute;top: 210px;left: 330px;font-size: 20px">删除</span></a></div>
					<div id="update"><a href="/companymgr1/admin/update.jsp" ><span style="position: absolute;top: 210px;left: 550px;font-size: 20px">修改</span></a></div>
					<div id="check"><a href="/companymgr1/admin/search.jsp" ><span style="position: absolute;top: 210px;left: 815px;font-size: 20px">查询</span></a></div>
			</div>
		</div>
	</div>
</body>

</html>