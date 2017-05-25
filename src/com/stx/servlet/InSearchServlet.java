package com.stx.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.dao.InvidDao;
import com.stx.entity.InTvid;

public class InSearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查询数据.
		List<InTvid> invids = new ArrayList();
		InvidDao indao=new InvidDao();
		invids = indao.getsum();
		//将invid传到request中
		request.setAttribute("invids", invids);
		//请求转发
		request.getRequestDispatcher("/admin/search.jsp").forward(request, response);;
	}

}
