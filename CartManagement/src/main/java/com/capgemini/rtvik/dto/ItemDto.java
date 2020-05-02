package com.capgemini.rtvik.dto;

public class ItemDto {	
	
	private int itemId;
	private String userId;
	private String itemName;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	@Override
	public String toString() {
		return "ItemDto [itemId=" + itemId + ", userId=" + userId + ", itemName=" + itemName + "]";
	}
}
