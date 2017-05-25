package com.stx.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.stx.dao.UserDao;

import com.stx.entity.TUser;
import com.stx.jdbc.StringUtil;

public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取客户端数据
		String name = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		String position = request.getParameter("work");
		String s = StringUtil.getMd5(pwd);// 加密
		List<TUser> userlist = new ArrayList();
		// 匹配账户密码
		TUser user = new TUser();
		user.setUpwd(pwd);
		user.setUname(name);
		user.setPosition(position);
		UserDao dao = new UserDao();
		// 接收dao返回查询后的值。
		TUser user1 = dao.queryCompany(user);
		if (user1 != null) {
			// 登录成功，往session中存入当前登录的用户ID和用户名
			request.getSession().setAttribute("userid", user1.getUserid());
			request.getSession().setAttribute("username", user1.getUname());
			// 请求跳转
			if (user1.getPosition() == null) {
				// 跳回原来登录界面
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
				try {
					if (user1.getPosition().equals("财务人员")) {
						// 从数据库中获取用户信息
						request.getRequestDispatcher("/admin/userhome.jsp").forward(request, response);
					}
					
					if(user1.getPosition().equals("管理层")){
						request.getRequestDispatcher("/admin/home.jsp").forward(request, response);
					}

				} catch (Exception e) {
					// 跳回原来登录界面
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
		
		} else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
