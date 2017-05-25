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
<link rel="stylesheet" type="text/css" href="/companymgr1/css/add.css">
<meta charset="UTF-8">
<title style="color: ">欢迎来到增值税管理系统</title>
<script src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="js/add.js"></script>

</head>
<body style="overflow-y: hidden;">
	<div id="all">
		<div id="menu">
			<ul>
				<li><a href="#">在线帮助</a></li>
				<li class="menuDiv"></li>
				<li><a href="#">联系我们</a></li>
				<li class="menuDiv"></li>
				<li><a href="#">退出</a></li>
				<li class="menuDiv"></li>
			</ul>
		</div>
		<div id="header" style="color: #3C3C3C">
			<div id="logo" style="z-index: 5"></div>
		</div>
		<div id="mainbody">
			<div id="tax">
				<!-- 加入servlet地址，相应名称项用注释给出-->
				<form action="/companymgr1/videdit" method="post">
					<table border="1" cellpadding="0" cellspacing="0"
						style="margin: 10px -150px">
						<caption>
							<h1>增值税专用发票</h1>
						</caption>
						<tr align="center" style="height: 30px">
							<!-- 发票id vid/时间 createtime-->
							<td colspan="4">发票ID：<input type="text" name="vid" id="vid"
								onblur="checkvid()" size="25" placeholder="10位纯数字"
								style="border-style: none; color:"><input type="button"
								name="sure" value="查询" onclick="checkUp()"></td>
							<td colspan="4">时间：<input type="text" id="createtime"
								name="createtime" size="39" style="border-style: none"
								placeholder="XXXX-XX-XX" onblur="check()"></td>
						</tr>
						<tr align="center" style="height: 45px">
							<!-- 购买方 innname -->
							<td colspan="4">购买方名称:<input type="text" name="inname"
								id="username" onblur="checkformname()" size="33"
								style="border-style: none"><span id="sname"
								class="frbule"></span></td>
							<td colspan="4">密码区</td>
						</tr>
						<tr align="center" style="height: 30px">
							<!--  -->
							<td>货物或应税劳务名称</td>
							<td>规格</td>
							<td>单位</td>
							<td>数量</td>
							<td>单价</td>
							<td>金额</td>
							<td>税率</td>
							<td>税额</td>
						</tr>
						<tr style="height: 50px">
							<!-- 名称 -->
							<td><input type="text" name="goods" id="goods"
								style="height: 50px; border-style: none"></td>
							<!-- 规格 -->
							<td><input type="text" name="Specifications"
								id="specifications" size="4"
								style="height: 50px; border-style: none"></td>
							<!-- 单位 -->
							<td><input type="text" name="unit" id="unit" size="3"
								style="height: 50px; border-style: none"></td>
							<!-- 数量 -->
							<td><input type="text" name="vnum" id="vnum" size="4"
								style="height: 50px; border-style: none"></td>
							<!-- 单价 -->
							<td><input type="text" name="price" id="price" size=""
								style="height: 50px; border-style: none"></td>
							<!-- 金额 -->
							<td><input type="text" name="notamount" id="notamount"
								size="10" style="height: 50px; border-style: none"></td>
							<!-- 税率 -->
							<td><select id="taxvid" name="taxrate"
								style="height: 55px; border-style: none">
									<option id="1" value=".06">0.06</option>
									<option id="2" value=".11">0.11</option>
									<option id="3" value=".13">0.13</option>
									<option id="4" value=".17">0.17</option>
									<lect></td>
							<!-- 税额 -->
							<td><input type="text" name="aot" id="aot" size="9"
								style="height: 50px; border-style: none"
								style="border-style:none"></td>
						</tr>

						<tr align="center" style="height: 30px">
							<!-- 目前不确定是否要传入后端 -->
							<td colspan="2">价税合计</td>
							<td colspan="6"><input type="text" id="sum" name="amount"
								size="80" style="border-style: none"></td>
						</tr>
						<tr align="center" style="height: 30px">
							<td colspan="4">销售方名称：<input type="text" id="outname"
								name="outname" size="31" style="border-style: none"></td>
							<td>发票种类:<select name="invoicetype" id="vidtype">
									<option value="进项发票">进项发票</option>
									<option value="销项发票">销项发票</option>
							</select></td>
							<td colspan="3"><input type="submit" name="submit"
								value="确认修改" onclick="check()"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
<script>
	function checkUp() {
		var val = document.getElementById("vid").value;
		//获取下拉框中的值
		var index = document.getElementById("vidtype").selectedIndex;
		var type = document.getElementById("vidtype").options[index].value;
		$.ajax({
			url : '/companymgr1/updatecheckservlet',
			type : 'post',
			data : {
				vid : val,
				vidtype : type
			},
			datatype : "json",//"xml", "html", "script", "json", "jsonp", "text".           
			success : function(data) {

				var array = new Array();
				array = data.split(",");//将字符串数据切割成数组
				document.getElementById("username").value = array[1];//改变买方文本框中的值
				document.getElementById("outname").value = array[2];
				document.getElementById("goods").value = array[3];
				document.getElementById("price").value = array[4];
				document.getElementById("specifications").value = array[5];
				document.getElementById("unit").value = array[6];
				document.getElementById("vnum").value = array[7];
				document.getElementById("aot").value = array[9];
				document.getElementById("notamount").value = array[10];
				document.getElementById("sum").value = array[11];
				document.getElementById("createtime").value = array[12];
				//下拉框tax
				var alloption = document.getElementById("taxvid").options;//获取所有option
				for (var x = 0; x < alloption.length; x++) {
					if (alloption[x].value == array[8]) {
						alloption[x].selected = true;//将默认设置为该数据。
					}
				}
			}
		});
	}
</script>