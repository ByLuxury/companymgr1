package com.stx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.stx.entity.DateTime;
import com.stx.entity.InTvid;
import com.stx.entity.OutTvid;

public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String selected = request.getParameter("option");
		DateTime date = new DateTime();
		date.setStartDate(startDate);
		date.setEndDate(endDate);
		System.out.println(startDate);
		// //查询进项数据.
		List<InTvid> invids = new ArrayList();
		InvidDao indao = new InvidDao();
		invids = indao.getinvidByDate(Date.valueOf(startDate), Date.valueOf(endDate));
		Gson gson = new Gson();
		String result = gson.toJson(invids);// 将查询出的数据转换成json字符串
		//查询销项数据
		List<OutTvid> outvids = new ArrayList();
		OutvidDao outvidDao=new OutvidDao();
		outvids=outvidDao.getsum(Date.valueOf(startDate), Date.valueOf(endDate));
		 String outResult=gson.toJson(outvids);
		switch (selected) {
		case "in":
			pw.write(result);
			pw.flush();
			break;
		case "out":	
			pw.write(outResult);
			pw.flush();
			break;
		}

		System.out.println("进项发票:"+result); // 打印发送到客户端到结果
		System.out.println("销项数据:"+outResult);// 打印被选中项
		System.out.println(startDate);// 开始日期
		System.out.println(endDate);// 结束日期
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
