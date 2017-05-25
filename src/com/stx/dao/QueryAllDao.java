package com.stx.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.stx.entity.AllInfo;
import com.stx.jdbc.JdbcUtil;

public class QueryAllDao {

	public static List<AllInfo> queryAll(String pagenowStr,String type){
		String table = null;
		if("in".equals(type)){
			table="tb_invid";
		}
		if("out".equals(type)){
			table="tb_outvid";
		}
		try {
			Connection conn= JdbcUtil.getCon();
			//String sql="select vid,goods,price,Specifications,amount,createtime from tb_invid";
			
			String sql="select * from "+table;
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs=null;
			ResultSet rs1 = null;
			int count=0;//总行数
			int pagecount = 0;//总页数
			int pagenow=1;//当前页
			
			ArrayList<AllInfo> list=new ArrayList<AllInfo>();
		 if(pagenowStr!=null){
			 pagenow = Integer.parseInt(pagenowStr);
		 }
		  rs=pstmt.executeQuery();
		 rs.last();//光标移动到最后一个
		 count = rs.getRow();
		 if(count%5==0){
			 pagecount = count / 5;
		 } else {
				pagecount = count / 5 + 1;
			}  
		 rs1 = pstmt.executeQuery(sql+" limit "+(pagenow-1)*5+ "," + 5);//分页查询.每次查询5个
			while(rs1.next()){
				AllInfo allInfo=new AllInfo();
				
				allInfo.setTax(rs1.getString("tax"));
				allInfo.setVid(rs1.getString("vid"));
				allInfo.setPrice(rs1.getString("price"));
				allInfo.setAmount(rs1.getString("amount"));
				allInfo.setSpecifications(rs1.getString("Specifications"));
				allInfo.setOutname(rs1.getString("outname"));
				allInfo.setDate(new SimpleDateFormat("yyyy-MM-dd").format(rs1.getDate("createtime")));
				list.add(allInfo);
			}
			return list;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static List<AllInfo> queryAll1(){
		try {
			Connection conn= JdbcUtil.getCon();
			ArrayList<AllInfo> list=new ArrayList<AllInfo>();
			ResultSet rs1 = null;
			String sql="select vid,goods,price,amount,createtime from tb_invid";
			PreparedStatement pstmt=conn.prepareStatement(sql+"limit " +0 + "," + 5);
			 rs1 = pstmt.executeQuery();//分页查询.每次查询5个
				while(rs1.next()){
					AllInfo allInfo=new AllInfo();
					allInfo.setAmount(rs1.getString("amount"));
					allInfo.setVid(rs1.getString("vid"));
					list.add(allInfo);
				}
				return list;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
