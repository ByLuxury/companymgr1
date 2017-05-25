package com.stx.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.stx.dao.InvidDao;
import com.stx.dao.OutvidDao;
import com.stx.entity.InTvid;
import com.stx.entity.OutTvid;
public class VideditServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取客户端信息
				String id = request.getParameter("vid");//发票id
				String inname= request.getParameter("inname");//购货公司名字
				String outname= request.getParameter("outname");//销货公司名字
				String goods=request.getParameter("goods");//劳务名称
				String price= request.getParameter("price");//单价
				String specifications=request.getParameter("Specifications");//规格
				String unit=request.getParameter("unit");//单位
				String vnum= request.getParameter("vnum");//数量
				String tax= ("0"+request.getParameter("taxrate"));//税率 jsp中value为.11  .17 前面要加〇
				String aot= request.getParameter("aot");//税额
				String notamount=request.getParameter("notamount");//不含税
				String amount= request.getParameter("amount");//总金额
				String createtime= request.getParameter("createtime");//时间
				String type= request.getParameter("invoicetype");//类型
				
				if(type.equals("进项发票")){
					InTvid vid =new InTvid();
					vid.setAmount(amount);
					vid.setAot(aot);
					vid.setCreatetime(Date.valueOf(createtime));
					vid.setInname(inname);
					vid.setPrice(price);
					vid.setOutname(outname);
					vid.setTax(tax);
					vid.setVid(id);
					vid.setVnum(vnum);
					vid.setUnit(unit);
					vid.setGoods(goods);
					vid.setNotamount(notamount);
					vid.setSpecifications(specifications);//dsssssssssss
					//添加发票信息
					InvidDao dao1= new InvidDao();
					boolean isupdate=dao1.updateInvid(id, vid);
				}else{
					OutTvid vid =new OutTvid();
					vid.setAmount(amount);
					vid.setAot(aot);
					vid.setCreatetime(createtime);
					vid.setInname(inname);
					vid.setPrice(price);
					vid.setOutname(outname);
					vid.setTax(tax);
					vid.setVid(id);
					vid.setVnum(vnum);
					vid.setUnit(unit);
					vid.setGoods(goods);
					vid.setNotamount(notamount);
					vid.setSpecifications(specifications);
					//添加发票信息
					OutvidDao dao1= new OutvidDao();
					boolean isupdate=dao1.updateOutvid(id, vid);
				}

		// 请求转发到web层。
		request.getRequestDispatcher("/admin/home.jsp").forward(request, response);
	}

}
