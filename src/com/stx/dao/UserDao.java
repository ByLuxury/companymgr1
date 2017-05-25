package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stx.entity.TUser;
import com.stx.jdbc.JdbcUtil;
import com.stx.jdbc.StringUtil;

/**
 * 对用户的增删改查操作
 * @author Administrator
 *
 */
//增加用户
public class UserDao {
	public boolean adduser(TUser user) {
		Connection con = null;
		PreparedStatement pst =null;
		try {
			con=JdbcUtil.getCon();
			//添加用户到数据库
		pst = con.prepareStatement("insert into tb_user(uname,upwd,position) values(?,?,?) ");	
		//pst = con.prepareStatement("insert into tb_user values(seq_user1.nextval,?,?,?) ");	
		pst.setString(1,user.getUname() );//用户名
		pst.setString(2,StringUtil.getMd5(user.getUpwd()) );//密码
		pst.setString(3, user.getPosition());//职位
		pst.executeUpdate();
		return true;
		} catch (ClassNotFoundException | SQLException e) {	
			e.printStackTrace();
		}finally {
			JdbcUtil.closeCon(con, pst);
		}
		return false;
	}
	//删除
	public boolean delUser(TUser user) {
		Connection con=null;
		PreparedStatement  pst =null;
		try {
			//获取连接
			con = JdbcUtil.getCon();
			//删除数据
			pst=con.prepareStatement("delete from tb_user where uname=?");
			pst.setString(1, user.getUname());
			pst.executeUpdate();
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.closeCon(null, pst);
		}
		return false;	
	}

	//修改用户信息
		public boolean updateUser(TUser user){
			//定义数据库操作
			Connection con = null;
			PreparedStatement pst=null;
			//创建连接
			try {
				con=JdbcUtil.getCon();
				//修改信息
				pst=con.prepareStatement("update compnay set upwd=? where cname=? ");
				pst.setString(1,StringUtil.getMd5(user.getUpwd()));
				pst.setString(2, user.getUname());
				pst.executeUpdate();
				return true;
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JdbcUtil.closeCon(con, pst);
			}
			
			return false;
		}
	/**
	 * 根据用户uname和upwd，查找用户是否存在
	 * @param com
	 * @return null 企业不存在
	 * 		   else 返回包含用户id的用户对象
	 */
	public TUser queryCompany(TUser user) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = JdbcUtil.getCon();
			pst= con.prepareStatement("select * from tb_user where uname=? and upwd=?");
			pst.setString(1, user.getUname());
			pst.setString(2, StringUtil.getMd5(user.getUpwd()));
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String userid = rs.getString("userid");
				String uname = rs.getString("uname");
				String upwd = rs.getString("upwd");
				String work =rs.getString("position");
				TUser tUser = new TUser();
				tUser.setUserid(userid);
				tUser.setUname(uname);
				tUser.setUpwd(upwd);
				tUser.setPosition(work);
				return tUser;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtil.closeCon(con, pst);
		}
		return null;
	}
	
	/**
	 * 查询返回所有的企业信息
	 * @return 企业集合
	 */
	public List<TUser> queryUser() {
		Connection con = null;
		Statement st = null;
		List<TUser> users = new ArrayList<TUser>();
		try {
			con = JdbcUtil.getCon();
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select userid,uname,position from tb_user");
			while (rs.next()) {
				TUser user = new TUser();
				user.setUserid(rs.getString("userid"));
				user.setUname(rs.getString("uname"));
				user.setPosition(rs.getString("position"));
				users.add(user);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeCon(con, st);
		}
		return users ;
	}
	// 检查用户账户密是否存在
		public String checkUser(String uname) {
			Connection con = null;
			PreparedStatement pst = null;
			try {
				con = JdbcUtil.getCon();
				pst = con.prepareStatement("select uname from tb_user where uname=?");
				pst.setString(1, uname);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					return rs.getString("uname");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JdbcUtil.closeCon(null, pst);
			}
			return null;
		}
}
