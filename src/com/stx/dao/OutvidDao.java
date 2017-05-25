package com.stx.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stx.entity.InTvid;
import com.stx.entity.OutTvid;
import com.stx.jdbc.JdbcUtil;
import com.stx.jdbc.StringUtil;

public class OutvidDao {
	/**
	 * 对发票的增删改查操作
	 * 
	 * @author Administrator
	 * @throws SQLException
	 *
	 */
	// 增加发票
		public boolean addoutvid(OutTvid invid) {
			Connection con = null;
			PreparedStatement pst = null;
			try {
				con = JdbcUtil.getCon();
				pst = con.prepareStatement("insert into tb_outvid values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pst.setString(1, invid.getVid());// 发票ID
				pst.setString(2, invid.getInname());// 购货公司的名字
				pst.setString(3, invid.getOutname());//销货公司的名字
				pst.setString(4, invid.getGoods());//劳务名称
				pst.setString(5, invid.getPrice());// 单价
				pst.setString(6, invid.getSpecifications());//规格
				pst.setString(7, invid.getUnit());//单位
				pst.setString(8, invid.getVnum());// 数量
				pst.setString(9, invid.getTax());// 发票税率
				pst.setString(10, invid.getAot());// 发票税额
				pst.setString(11, invid.getNotamount());//不含税金额
				pst.setString(12, invid.getAmount());// 价税合计
				pst.setString(13, invid.getCreatetime());// 时间

				pst.executeUpdate();
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			} finally {
				JdbcUtil.closeCon(con, pst);
			}
			return false;
		}

	// 删除
	public boolean deloutvid(OutTvid vid) {
		Connection con = null;
		PreparedStatement pst = null;
		try {

			con = JdbcUtil.getCon();

			pst = con.prepareStatement("delete from tb_outvid where vid=?");
			pst.setString(1, vid.getVid());
			pst.executeUpdate();
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.closeCon(con, pst);
		}
		return false;
	}

	// 修改用户信息
		public boolean updateOutvid(String id, OutTvid invid) {
			// 定义数据库操作
			Connection con = null;
			PreparedStatement pst = null;
			// 创建连接
			try {
				con = JdbcUtil.getCon();
				// 修改信息
				pst = con.prepareStatement(
						"update tb_outvid set vid=?,inname=?,outname=?,goods=?,price=?,Specifications=?,unit=?,vnum=?,tax=?,aot=?,notamount=?,amount=?,createtime=? where vid=? ");
				pst.setString(1, invid.getVid());// 发票ID
				pst.setString(2, invid.getInname());// 购货公司的名字
				pst.setString(3, invid.getOutname());//销货公司的名字
				pst.setString(4, invid.getGoods());// 劳务名称
				pst.setString(5, invid.getPrice());// 单价
				pst.setString(6, invid.getSpecifications());// 规格
				pst.setString(7, invid.getUnit());// 单位
				pst.setString(8, invid.getVnum());// 数量
				pst.setString(9, invid.getTax());// 发票税率
				pst.setString(10, invid.getAot());//发票税额
				pst.setString(11, invid.getNotamount());//不含税金额
				pst.setString(12, invid.getAmount());//总金额
				pst.setString(13, invid.getCreatetime());//时间
				pst.setString(14, id);// 要被修改的id
				pst.executeUpdate();
				return true;
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			} finally {
				JdbcUtil.closeCon(con, pst);
			}

			return false;
		}
	/*
	 * 修改部分用户信息 通过输入的X 修改对应的数据
	 */
	public boolean updateinfo(int x, InTvid outvid) {
		// 定义数据库操作
		Connection con = null;
		PreparedStatement pst = null;
		// 创建连接
		try {
			con = JdbcUtil.getCon();
			// 修改信息
			switch (x) {
			// 修改id
			case 1:
				pst = con.prepareStatement("update tb_outvid set vid=? where vid=?");
				pst.setString(1, outvid.getVid());
				pst.setString(2, outvid.getVid());
				pst.executeUpdate();
				break;
			// 修改购货公司
			case 2:
				pst = con.prepareStatement("update tb_outvid set inname=? where vid=?");
				pst.setString(1, outvid.getInname());
				pst.setString(2, outvid.getVid());
				pst.executeUpdate();
				break;
			// 销货公司
			case 3:
				pst = con.prepareStatement("update tb_outvid set outname=? where vid=?");
				pst.setString(1, outvid.getOutname());
				pst.setString(2, outvid.getVid());
				pst.executeUpdate();
				break;
			// 金额
			case 4:
				pst = con.prepareStatement("update tb_outvid set amount=? where vid=?");
				pst.setString(1, outvid.getAmount());
				pst.setString(2, outvid.getVid());
				pst.executeUpdate();
				break;
			// 税率
			case 5:
				pst = con.prepareStatement("update tb_outvid set tax=? where vid=?");
				pst.setString(1, outvid.getTax());
				pst.setString(2, outvid.getVid());
				pst.executeUpdate();
				break;
			// 税额
			case 6:
				pst = con.prepareStatement("update tb_outvid set aot=? where vid=?");
				pst.setString(1, outvid.getAot());
				pst.setString(2, outvid.getVid());
				pst.executeUpdate();
				break;
			// 单价
			case 7:
				pst = con.prepareStatement("update tb_outvid set price=? where vid=?");
				pst.setString(1, outvid.getPrice());
				pst.setString(2, outvid.getVid());
				pst.executeUpdate();
				break;
			// 数量
			case 8:
				pst = con.prepareStatement("update tb_outvid set vnum=? where vid=?");
				pst.setString(1, outvid.getVnum());
				pst.setString(2, outvid.getVid());
				pst.executeUpdate();
				break;
			// 时间
			case 9:
				pst = con.prepareStatement("update tb_outvid set createtime=? where vid=?");
				pst.setDate(1, outvid.getCreatetime());
				pst.setString(2, outvid.getVid());
				pst.executeUpdate();
				break;
			// goods劳务名称
			case 10:
				pst = con.prepareStatement("update tb_outvid set goods=? where vid=?");
				pst.setString(1, outvid.getGoods());
				pst.setString(2, outvid.getVid());
				pst.executeUpdate();
				break;
			// 金额notAmount
			case 11:
				pst = con.prepareStatement("update tb_outvid set notamount=? where vid=?");
				pst.setString(1, outvid.getNotamount());
				pst.setString(2, outvid.getVid());
				pst.executeUpdate();
				break;
			// 单位unit
			case 12:
				pst = con.prepareStatement("update tb_outvid set unit=? where vid=?");
				pst.setString(1, outvid.getUnit());
				pst.setString(2, outvid.getVid());
				pst.executeUpdate();
				break;
			// 规格Specifications
			case 13:
				pst = con.prepareStatement("update tb_outvid set Specifications=? where vid=?");
				pst.setString(1, outvid.getSpecifications());
				pst.setString(2, outvid.getVid());
				pst.executeUpdate();
				break;
			}
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.closeCon(con, pst);
		}

		return false;
	}

	// 查询所有发票
	public List<InTvid> getAllOutvid() {
		Connection con = null;
		PreparedStatement pst = null;
		List<InTvid> outvids = new ArrayList<InTvid>();
		try {
			con = JdbcUtil.getCon();
			// 取得所有用户信息，用于视图层显示
			pst = con.prepareStatement(
					"select vid,inname,outname,createtime,price,vnum,tax,aot,amount,goods,notamount,unit,Specifications from tb_outvid");
			ResultSet rs = pst.executeQuery();
			// 将查询出来的数据转放到List中，供传递
			while (rs.next()) {
				InTvid outvid = new InTvid();
				outvid.setVid(rs.getString("vid"));
				outvid.setInname(rs.getString("inname"));
				outvid.setOutname(rs.getString("outname"));
				outvid.setCreatetime(rs.getDate("createtime"));
				outvid.setPrice(rs.getString("price"));
				outvid.setVnum(rs.getString("vnum"));
				outvid.setTax(rs.getString("tax"));
				outvid.setAot(rs.getString("aot"));
				outvid.setAmount(rs.getString("amount"));
				outvid.setAmount(rs.getString("amount"));
				outvid.setGoods(rs.getString("goods"));
				outvid.setNotamount(rs.getString("notamount"));
				outvid.setUnit(rs.getString("unit"));
				outvid.setSpecifications(rs.getString("Specifications"));
				outvids.add(outvid);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeCon(con, pst);
		}
		return outvids;
	}

	// 根据日期查询
	public List<OutTvid> getOutvid(String date1, String date2) {
		Connection con = null;
		PreparedStatement pst = null;
		List<OutTvid> outvids = new ArrayList<OutTvid>();
		try {
			con = JdbcUtil.getCon();
			// 取得所有用户信息，用于视图层显示
			pst = con.prepareStatement(
					"select vid,inname,outname,createtime,price,vnum,tax,aot,amount,goods,notamount,unit,Specifications  from tb_outvid  createtime between ? and ?");
			pst.setString(1, date1);
			pst.setString(2, date2);
			ResultSet rs = pst.executeQuery();
			// 将查询出来的数据转放到List中，供传递
			while (rs.next()) {
				OutTvid outvid = new OutTvid();
				outvid.setVid(rs.getString("vid"));
				outvid.setInname(rs.getString("inname"));
				outvid.setOutname(rs.getString("outname"));
				outvid.setCreatetime(rs.getString("createtime"));
				outvid.setPrice(rs.getString("price"));
				outvid.setVnum(rs.getString("vnum"));
				outvid.setTax(rs.getString("tax"));
				outvid.setAot(rs.getString("aot"));
				outvid.setAmount(rs.getString("amount"));
				outvid.setGoods(rs.getString("goods"));
				outvid.setNotamount(rs.getString("notamount"));
				outvid.setUnit(rs.getString("unit"));
				outvid.setSpecifications(rs.getString("Specifications"));
				outvids.add(outvid);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeCon(con, pst);
		}
		return outvids;
	}

	// 价税总额
	public List<OutTvid> getaot(String date1, String date2) {
		Connection con = null;
		PreparedStatement pst = null;
		List<OutTvid> outvids = new ArrayList<OutTvid>();
		try {
			con = JdbcUtil.getCon();
			// 取得所有用户信息，用于视图层显示
			pst = con.prepareStatement(
					"select createtime,sum(amount) from tb_outvid where createtime between ? and ? group by createtime order by createtime desc");
			pst.setString(1, date1);
			pst.setString(2, date2);
			ResultSet rs = pst.executeQuery();
			// 将查询出来的数据转放到List中，供传递
			while (rs.next()) {
				OutTvid outvid = new OutTvid();
				outvid.setAmount((rs.getString("sum(amount)")));
				outvids.add(outvid);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeCon(con, pst);
		}
		return outvids;
	}

	// 根据时间查询总金额
	public List<OutTvid> getsum(Date date1, Date date2) {
		Connection con = null;
		PreparedStatement pst = null;
		List<OutTvid> outsum = new ArrayList<OutTvid>();
		try {
			con = JdbcUtil.getCon();
			// 取得所有总金额，用于视图层显示
			pst = con.prepareStatement("SELECT  sum(amount) ,MONTH(createtime)"+ 
					"FROM tb_outvid  where Date(createtime)  between ? and ? GROUP BY MONTH(createtime)");
			pst.setDate(1, date1);
			pst.setDate(2, date2);
			ResultSet rs = pst.executeQuery();
			// 将查询出来的数据转放到List中，供传递
			while (rs.next()) {
				OutTvid Sum = new OutTvid();
				Sum.setAmount(rs.getString("sum(amount)"));
				Sum.setMonth(rs.getInt("MONTH(createtime)"));
				outsum.add(Sum);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeCon(con, pst);
		}
		return outsum;
	}

	// 查询总金额
		public List<OutTvid> getsum() {
			Connection con = null;
			PreparedStatement pst = null;
			List<OutTvid> outsum = new ArrayList<OutTvid>();
			try {
				con = JdbcUtil.getCon();
				// 取得所有总金额，用于视图层显示
				pst = con.prepareStatement(
						"  select MONTH(createtime),sum(amount) from tb_outvid group by MONTH(createtime)");
				ResultSet rs = pst.executeQuery();
				// 将查询出来的数据转放到List中，供传递
				while (rs.next()) {
					OutTvid Sum = new OutTvid();
					Sum.setAmount(rs.getString("sum(amount)"));
					Sum.setMonth(rs.getInt("MONTH(createtime)"));
					outsum.add(Sum);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.closeCon(con, pst);
			}
			return outsum;
		}

	// 查询单个发票信息
	public OutTvid getvid(String vid) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = JdbcUtil.getCon();
			// 取得所有用户信息，用于视图层显示
			pst = con.prepareStatement("select * from tb_outvid where vid=?");
			pst.setString(1, vid);
			ResultSet rs = pst.executeQuery();
			// 将查询出来的数据转放到List中，供传递
			while (rs.next()) {
				OutTvid invid = new OutTvid();
				invid.setVid(rs.getString("vid"));
				invid.setInname(rs.getString("inname"));
				invid.setOutname(rs.getString("outname"));
				invid.setCreatetime(rs.getString("createtime"));
				invid.setPrice(rs.getString("price"));
				invid.setVnum(rs.getString("vnum"));
				invid.setTax(rs.getString("tax"));
				invid.setAot(rs.getString("aot"));
				invid.setAmount(rs.getString("amount"));
				invid.setAmount(rs.getString("amount"));
				invid.setGoods(rs.getString("goods"));
				invid.setNotamount(rs.getString("notamount"));
				invid.setUnit(rs.getString("unit"));
				invid.setSpecifications(rs.getString("Specifications"));
				return invid;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeCon(con, pst);
		}
		return null;
	}

}