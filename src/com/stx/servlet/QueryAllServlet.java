package com.stx.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.stx.dao.InvidDao;
import com.stx.dao.OutvidDao;
import com.stx.dao.QueryAllDao;
import com.stx.entity.AllInfo;
import com.stx.entity.InTvid;
import com.stx.entity.OutTvid;

/**
 * Servlet implementation class QueryAllServlet
 */
public class QueryAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryAllServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		// response.sendRedirect(arg0)
		String pagenow = request.getParameter("pagenow");
		String queryType = request.getParameter("queryType");
		Gson gson = new Gson();
		PrintWriter pw = response.getWriter();
		// //查询
		List<AllInfo> invids = new ArrayList();
		invids = QueryAllDao.queryAll(pagenow,queryType);
		String result = gson.toJson(invids);// 将查询出的数据转换成json字符串
		pw.write(result);
		System.out.println("pagenow:"+pagenow+","+"pagenow:"+queryType);
		System.out.println(result);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
