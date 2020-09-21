package com.shweta.model;

import java.util.Date;

public class EProduct {

	private int pId;
	private String name;
	private double price;
	private Date creationDate;
	private Date expireDate;
	
	public EProduct() {}
	
	public EProduct(String name, double price, Date creationDate, Date expireDate) {
		this.name = name;
		this.price = price;
		this.creationDate = creationDate;
		this.expireDate = expireDate;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	
	
	
	
}
