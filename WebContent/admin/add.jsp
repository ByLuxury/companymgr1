<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/companymgr1/css/add.css">
	<meta charset="UTF-8">
	<title style="color: ">欢迎来到增值税管理系统</title>
	<script type="text/javascript" src="/companymgr1/js/add.js"></script>
</head>
<body style="overflow-y: hidden;">
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
		<div id="header" style="color:	#3C3C3C">
		<div id="logo" style="z-index: 5"></div>
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
			<div id="fade" class="black_overlay"> 
			</div>
		<div id="mainbody">
			<div id="tax">
				<!-- 加入servlet地址，相应名称项用注释给出-->
				<form action="/companymgr1/add"  method="post" >
					<table  border="1" cellpadding="0" cellspacing="0" align="center"  style="margin:50px -195px">
						<caption><h1>增值税专用发票</h1></caption>
						<tr align="center" style="height: 30px">
							<!-- 发票id vid/时间 createtime-->
							<td colspan="4">发票ID：<input type="text" name="vid" id="vid" onblur="checkvid()" size="37" placeholder="10位纯数字" style="border-style:none;color: "></td>
							<td colspan="4">时间：<input type="text" name="createtime" id="createtime" size="39" style="border-style:none" placeholder="XXXX-XX-XX" onblur="check()"></td>
						</tr>
						<tr align="center" style="height: 45px">
							<!-- 购买方 innname -->
							<td colspan="4">购买方名称:<input type="text" name="inname" id="username" onblur="checkformname()" size="33" style="border-style:none"><span id="sname" class="frbule"></span></td>
							<td colspan="4">密码区</td>
						</tr>
						<tr align="center" style="height: 30px">
							<!--  -->
							<td>货物或应税劳务名称</td><td >规格</td><td>单位</td><td>数量</td><td>单价</td><td>金额</td><td>税率</td><td>税额</td>
						</tr>
						<tr style="height: 50px">
							<!-- 名称 -->
							<td><input type="text" name="goods" id="" style="height: 50px;border-style:none"></td> 
							<!-- 规格 -->
							<td><input type="text" name="specifications" id="" size="4" style="height: 50px;border-style:none" ></td>
							<!-- 单位 -->
							<td><input type="text" name="unit" id="" size="3" style="height: 50px;border-style:none" ></td>
							<!-- 数量 -->
							<td><input type="text" name="vnum" id="" size="4" id="sl" style="height: 50px;border-style:none" ></td>
							<!-- 单价 -->
							<td><input type="text" name="price" id="" size="" id="dj" style="height: 50px;border-style:none" onblur="jee()" ></td>
							<!-- 金额 -->
							<td><input type="text" name="notamount" id="" size="10" id="je" style="height: 50px;border-style:none" ></td>
							<!-- 税率 -->
							<td><select  name="taxrate" style="height: 55px;border-style:none">
								<option>0.06</option>			
								<option>0.11</option>
								<option>0.13</option>
								<option>0.17</option>
							</select></td>
							<!-- 税额 -->
							<td><input type="text" name="aot" id="" size="9" style="height: 50px;border-style:none" style="border-style:none"></td>
						</tr>
						<tr align="center" style="height: 30px">
							<!-- 目前不确定是否要传入后端 -->
							<td colspan="2">价税合计</td><td colspan="6"><input type="text" id="sum" name="amount" size="80" style="border-style:none"> </td>
						</tr>
						<tr align="center" style="height: 30px">
							<td colspan="4">销售方名称：<input type="text" name="outname" size="31" style="border-style:none" ></td><td>发票种类:<select name="invoicetype">
							<option>进项发票</option>
							<option>销项发票</option>
						</select></td>
						<td colspan="3"><input type="submit" name="submit" value="提交" onclick="check()"  ></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>
</body>
</html>