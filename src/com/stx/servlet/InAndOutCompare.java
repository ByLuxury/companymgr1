package com.stx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.stx.dao.InvidDao;
import com.stx.dao.OutvidDao;

/**
 * Servlet implementation class InAndOutCompare
 */
public class InAndOutCompare extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		InvidDao invidDao=new InvidDao();
		OutvidDao outvidDao=new OutvidDao();
		List listIn=invidDao.getsum();
		List listOut=outvidDao.getsum();
		List list=new ArrayList<>();
		list.add(listIn);
		list.add(listOut);
		Gson gson=new Gson();
		String s=gson.toJson(list);
		pw.write(s);
		pw.flush();
		System.out.println(list.size());
		System.out.println(s);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
