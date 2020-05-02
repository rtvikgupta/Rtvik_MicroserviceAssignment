package com.capgemini.rtvik.dto;

public class ProductDto {

	private String productName;
	private double productPrice;
	private int itemCount;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	@Override
	public String toString() {
		return "ProductDto [productName=" + productName + ", productPrice=" + productPrice + ", itemCount=" + itemCount
				+ "]";
	}
	
}
