package com.stx.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.dao.InvidDao;
import com.stx.dao.OutvidDao;
import com.stx.entity.InTvid;
import com.stx.entity.OutTvid;



public class DelVidServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取要删除的销售名信息
		String vidid = request.getParameter("vid");
		String type = request.getParameter("invoicetype");
		//判断类型{
		if(type.equals("进项发票")){
			InTvid vid = new InTvid();
			vid.setVid(vidid);
			// 删除销售信息
			InvidDao dao = new InvidDao();
			boolean s = dao.delinvid(vid);
		}else{
			OutTvid vid = new OutTvid();
			vid.setVid(vidid);
			// 删除销售信息
			OutvidDao dao = new OutvidDao();
			boolean s = dao.deloutvid(vid);
		}
		
		
//		// 获得所有销售点信息
//		List<TSales> saleslist = dao.getAllSales();
//		request.setAttribute("saleslist", saleslist);
//		//请求转发到web层。
		request.getRequestDispatcher("/admin/home.jsp").forward(request, response);
	}

}
