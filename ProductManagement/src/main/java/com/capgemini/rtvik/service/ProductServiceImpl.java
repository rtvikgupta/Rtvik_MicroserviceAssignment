package com.capgemini.rtvik.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.rtvik.dao.IProductDao;
import com.capgemini.rtvik.entities.Product;
import com.capgemini.rtvik.exceptions.ProductNotFoundException;

@Service
@Transactional
public class ProductServiceImpl implements IProductService{

	private IProductDao dao;
	
	public IProductDao getDao() {
		return dao;
	}

	@Autowired
	public void setDao(IProductDao dao) {
		this.dao = dao;
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		Optional<Product> optional = dao.findById(id);
		if(optional.isPresent()) {
			Product product = optional.get();
			return product;
		}
		throw new ProductNotFoundException("Product not found for id: "+id);
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		dao.save(product);
		return product;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		List<Product> products = dao.findAll();
		return products;
	}

}
