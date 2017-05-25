<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/companymgr1/css/reg.css">
<meta charset="UTF-8">
<title>注册页面</title>
<script type="text/javascript" src="/companymgr1/js/reg.js"></script>
<script src="<%=basePath%>js/jquery.js">
	//引入框架资源包
	//在要使用的ajax的页面写给予jQuery
</script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div id="mainbody">
		<!--主页-->
		<h3 style="padding-left: 160px; padding-top: 20px; color: #383838">注册页面</h3>
		<div id="fmbody">
			<span>${errorMSG }</span>
			<h3 style="color: #383838">用户名:</h3>
			<form action="/companymgr1/regist" method="post">
				<input placeholder="请输入4~20位的账号" type="text" id="username"
					name="uname" onblur="checkformname()"><span id="result"
					class="frbule"></span><br />
				<h3 style="color: #383838">密码:</h3>
				<input placeholder="请输入密码:4~20位" id="pwd" type="password" name="pwd"
					onblur="checkpwd()" onfocus="checkZh() " value=""> <span
					id="spwd" class="frbule"></span>
				<h3 style="color: #383838">确认密码:</h3>
				<input id="pwd2" type="password" name="twopwd" onblur="validate()"
					onfocus="checkZh()"><span id="tishi"></span><br>
				<br> <input type="radio" name="work" value="财务人员"
					onfocus="checkZh()">财务人员 <input type="radio" name="work"
					value="管理层" onfocus="checkZh()">管理层<br>
				<br>
				<!-- <input type="submit" value="提交">&nbsp&nbsp&nbsp&nbsp&nbsp -->
				<input type="submit" value="提交" onclick="check()" id="tj">
				<button type="submit" formaction="/companymgr1/login.jsp"
					method="post">返回</button>
			</form>
		</div>
	</div>
</body>

</html>
<script>
	function checkZh() {
		var val = document.getElementById("username").value;
		$
				.ajax({
					url : '/companymgr1/checkzh',
					type : 'post',
					data : {
						username : val
					},
					datatype : "json",//"xml", "html", "script", "json", "jsonp", "text".           
					success : function(data) {
						if (data == '2') {
							document.getElementById("result").innerHTML = "<font color='red'>×用户名不能为空</font>";
						}
						if (data == '0') {
							document.getElementById("result").innerHTML = "<font color='green'>√用户名可用!</font>";
						}
						if (data == '1') {
							document.getElementById("result").innerHTML = "<font color='red'>×用户名已存在</font>";
							//$("#submit").click(function(){ alert("dd");});

						}

					}

				});
	}
</script>