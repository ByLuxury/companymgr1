package com.stx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.dao.InvidDao;
import com.stx.dao.OutvidDao;
import com.stx.entity.InTvid;
import com.stx.entity.OutTvid;

/**
 * Servlet implementation class UpdateCheckServlet
 */
public class UpdateCheckServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vid = request.getParameter("vid");
		String type = request.getParameter("vidtype");
		//创建 Dao查询信息
		if(type.equals("进项发票")){
			InvidDao dao = new InvidDao();
			//获取一个发票数据
			InTvid invid = dao.getvid(vid);
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			//将数据传到jsp
			response.getWriter().print(invid.getVid()+","+invid.getInname()+","
					+invid.getOutname()+","+invid.getGoods()+","+invid.getPrice()+","
					+invid.getSpecifications()+","+invid.getUnit()+","+invid.getVnum()
					+","+invid.getTax()+","+invid.getAot()+","+invid.getNotamount()
					+","+invid.getAmount()+","+invid.getCreatetime());
		}
		if(type.equals("销项发票")){
			OutvidDao dao = new OutvidDao();
			OutTvid invid = dao.getvid(vid);
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(invid.getVid()+","+invid.getInname()+","
					+invid.getOutname()+","+invid.getGoods()+","+invid.getPrice()+","
					+invid.getSpecifications()+","+invid.getUnit()+","+invid.getVnum()
					+","+invid.getTax()+","+invid.getAot()+","+invid.getNotamount()
					+","+invid.getAmount()+","+invid.getCreatetime());//将0传到浏览器代表可以注册
		}
	}

}
