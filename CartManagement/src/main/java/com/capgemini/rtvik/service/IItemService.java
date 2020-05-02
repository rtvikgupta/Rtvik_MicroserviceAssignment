package com.capgemini.rtvik.service;

import java.util.List;

import com.capgemini.rtvik.entities.Item;

public interface IItemService {
	
	public Item save(Item item);
	public Item findById(int itemId);
	public List<Item> findAll();
	public List<Item> findAllByUserId(String userId);
}
