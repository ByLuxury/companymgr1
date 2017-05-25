package com.stx.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.stx.dao.UserDao;

import com.stx.entity.TUser;

/**
 * Servlet implementation class RegServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取数据信息	
		String name = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		String work=request.getParameter("work");
		if(name!=null&&pwd!=null&&work!=null){
			//创建公司对象
			TUser user=new TUser();
			user.setUname(name);
			user.setUpwd(pwd);
			user.setPosition(work);
			//查询企业信息是否已被注册
			UserDao dao = new UserDao();
			TUser user1=new TUser();
			//接收获获取到的公司
			user1=dao.queryCompany(user);
			if(user1!=null){
				//跳回注册页面
				request.setAttribute("errorMSG", "用户名已存在");
				request.getRequestDispatcher("/reg.jsp").forward(request, response);;
			}else{
				//添加注册信息到数据库
				boolean isreg = dao.adduser(user);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}else{
			//跳回注册页面
			request.getRequestDispatcher("/reg.jsp").forward(request, response);;
		}
		
		
	}

}
