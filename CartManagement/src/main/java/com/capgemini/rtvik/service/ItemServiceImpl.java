package com.capgemini.rtvik.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.rtvik.dao.ICartItemDao;
import com.capgemini.rtvik.entities.Item;

@Service
@Transactional
public class ItemServiceImpl implements IItemService {

	private ICartItemDao dao;
	
	
	public ICartItemDao getDao() {
		return dao;
	}

	@Autowired
	public void setDao(ICartItemDao dao) {
		this.dao = dao;
	}

	@Override
	public Item save(Item item) {
		// TODO Auto-generated method stub
		dao.save(item);
		return item;
	}

	@Override
	public Item findById(int itemId) {
		// TODO Auto-generated method stub
		Optional<Item> optional = dao.findById(itemId);
		if(optional.isPresent()) {
			Item item = optional.get();
			return item;
		}
		return null;
	}

	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		List<Item> list = dao.findAll();
		return list;
	}

	@Override
	public List<Item> findAllByUserId(String userId) {
		// TODO Auto-generated method stub
		List<Item> list = dao.findAllByUserId(userId);
		return list;
	}

}
