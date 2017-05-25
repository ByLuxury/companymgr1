package com.stx.entity;

import java.sql.Date;

public class AllInfo {
private String vid;
private String outname;//销货公司
private String price;//税价
private String amount;//总金额
private String date;//开票日期
//private String type;//发票类别
private String goods;
private String tax;
private String specifications;//规格
public String getVid() {
	return vid;
}
public void setVid(String vid) {
	this.vid = vid;
}

public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getAmount() {
	return amount;
}
public void setAmount(String amount) {
	this.amount = amount;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
/*public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}*/
public String getGoods() {
	return goods;
}
public void setGoods(String goods) {
	this.goods = goods;
}
public String getSpecifications() {
	return specifications;
}
public void setSpecifications(String specifications) {
	this.specifications = specifications;
}
public String getTax() {
	return tax;
}
public void setTax(String tax) {
	this.tax = tax;
}
public String getOutname() {
	return outname;
}
public void setOutname(String outname) {
	this.outname = outname;
}

}
