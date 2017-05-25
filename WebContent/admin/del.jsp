<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/companymgr1/css/del.css">
	<meta charset="UTF-8">
	<title>欢迎来到增值税管理系统</title>
	<link rel="stylesheet" type="text/css" href="/companymgr1/css/tu.css">
	<script type="text/javascript" src="/companymgr1/js/tu.js"></script>
</head>
<body>
	<div id="all">
		<div id="menu">
			<ul>
				<li><a href="javascript:void(0)" onclick="link()">在线帮助</a></li>
				<li class="menuDiv"></li>
				<li><a href="javascript:void(0)" onclick="link()">联系我们</a></li>
				<li class="menuDiv"></li>
				<li><a href="/companymgr1/return">退出</a></li>
				<li class="menuDiv"></li>
			</ul>
		</div>
		<div id="header">
			<div id="logo" style="z-index: 5"></div>
		</div>
		<div id="light" class="white_content"> 
		<a href="javascript:void(0)" onclick="tip()"> 
						<div id="close"></div>
					</a>
				<div id="online">
					<h2 style="color: #FFFFE0">联系人：丑八怪</h2>
					<h3 style="color: #FFFFE0">联系电话：123456789</h3>
					<h3 style="color: #FFFFE0">QQ：123456789</h3>
					
				</div>
			</div> 
			<div id="fade" class="black_overlay"> 
			</div>

		<div id="mainbody">
			<div id="tax">
				<form action="/companymgr1/del" method="post">
					发票ID：<input type="text" name="vid" onblur="checkformvid()" id="vid"><span id="vvid"></span><br><br>
					发票种类：<select name="invoicetype">
					<option>进项发票</option>
					<option>销项发票</option>
				</select><br><br>
					<input type="submit" name="submit" value="确认删除">
				</form>
			</div>
		</div>
	</div>
</body>
</html>