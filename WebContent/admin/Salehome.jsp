<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,java.util.List,com.stx.entity.TCompany,com.stx.entity.TSales" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/salehome.css">
  <meta charset="UTF-8">
  <title>salehome</title>
</head>
<body>

  <div id="head">
    <h2>销售点信息表</h2>
    <div>
      <form action="/companymgr1/addSale.jsp" method="post">
        <input type="submit" value="增加销售点">&nbsp<a href="/companymgr1/Login.jsp"><input type="button" value="退出"></a><br><br>
      </form>
    </div>
  </div>
  <div id="body">
  <table border="1" align="center">
      <tr>
        <th>序号</th>
        <th>销售点id</th>
        <th>销售点名称</th>
        <th>时间</th>
        <th>操作</th>
      </tr>
      <%  List<TSales> saleslist =(List<TSales>)request.getAttribute("saleslist");
      	if(saleslist!=null){
      		for(TSales sale:saleslist) {
      %>
      <tr>
        <td><%=sale.getCid() %></td>
        <td><%=sale.getSaid() %></td>
        <td><%=sale.getSname() %><form action="/companymgr1/delSale" method="post"><input type="hidden" value="<%=sale.getSname()%>" name="salename">
        	<input type="hidden" value="<%=sale.getSname()%>" name="salenamedel"></td>
        <td><%=sale.getCraetetime() %></td>
        <td><button type="submit" formaction="/companymgr1/editSale" method="post">修改</button>&nbsp<input type="submit" value="删除" onclick="return window.confirm('确定要删除吗？')"></form></td>
      </tr>
      <%}} %>
    </table>
  </div>
</body>
</html>