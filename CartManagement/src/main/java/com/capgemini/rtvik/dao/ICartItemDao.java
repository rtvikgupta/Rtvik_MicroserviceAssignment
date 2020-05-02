package com.capgemini.rtvik.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.rtvik.entities.Item;

@Repository
public interface ICartItemDao extends JpaRepository<Item, Integer>{
	
	List<Item> findAllByUserId(String userId);
}
