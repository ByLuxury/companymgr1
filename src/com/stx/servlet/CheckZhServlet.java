package com.stx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.dao.UserDao;


public class CheckZhServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取ajax当中传来的数值
		String username = request.getParameter("username");
		String isnull=(username+"2");//让空变成2
		if(isnull.equals("2")){
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			response.getWriter().print("2");//代表用户名为空
		}
		if(username!=null){
			//判断用户是否存在。
			UserDao dao = new UserDao();
			String name = dao.checkUser(username);
			if(name!=null){
				//用户名存在返回浏览器一个值表示用户名存在。
				response.setContentType("text/html");
				response.setCharacterEncoding("utf-8");
				response.getWriter().print("1");//1 表示用户已经存在
			}else{
				//用户名不存在返回浏览器一个值表示用户可以使用
				response.setContentType("text/html");
				response.setCharacterEncoding("utf-8");
				response.getWriter().print("0");//将0传到浏览器代表可以注册
			}
		}
		
	}

}
