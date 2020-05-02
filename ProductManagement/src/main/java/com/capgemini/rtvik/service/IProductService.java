package com.capgemini.rtvik.service;

import java.util.List;

import com.capgemini.rtvik.entities.Product;

public interface IProductService {

	public Product findById(int id);
	public Product save(Product product);
	public List<Product> findAll();
}
