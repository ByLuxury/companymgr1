package com.stx.entity;

import java.sql.Date;

public class InTvid {
	private String vid;
	private String inname;
	private String outname;
	private Date createtime;
	private String price;
	private String vnum;
	private String tax;
	private String aot;
	private String goods;
	private String unit;
	private String amount;
	private String notamount;
	private String Specifications;
	private int month;
	
	public String getNotamount() {
		return notamount;
	}
	public void setNotamount(String notamount) {
		this.notamount = notamount;
	}
	public String getSpecifications() {
		return Specifications;
	}
	public void setSpecifications(String specifications) {
		Specifications = specifications;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	public String getInname() {
		return inname;
	}
	public void setInname(String inname) {
		this.inname = inname;
	}
	public String getOutname() {
		return outname;
	}
	public void setOutname(String outname) {
		this.outname = outname;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getVnum() {
		return vnum;
	}
	public void setVnum(String vnum) {
		this.vnum = vnum;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getAot() {
		return aot;
	}
	public void setAot(String aot) {
		this.aot = aot;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
}
