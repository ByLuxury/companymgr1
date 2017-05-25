package com.stx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditSaleServlet
 */
public class EditSaleServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String salename=request.getParameter("salename");
		//将salename 添加到request
		request.setAttribute("salename", salename);
		request.getRequestDispatcher("/editSale.jsp").forward(request, response);
	}

}
