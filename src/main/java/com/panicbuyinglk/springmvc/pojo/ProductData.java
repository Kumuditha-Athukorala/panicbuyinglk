package com.panicbuyinglk.springmvc.pojo;

public class ProductData {

	private String productName;

	private Double unitPrice;

	private int qyt;

	private byte[] image;
	
	private String description;

	private int status;
	
	private String category;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQyt() {
		return qyt;
	}

	public void setQyt(int qyt) {
		this.qyt = qyt;
	}	

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
