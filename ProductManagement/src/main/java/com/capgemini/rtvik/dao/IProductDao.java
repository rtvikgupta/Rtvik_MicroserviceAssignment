package com.capgemini.rtvik.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.rtvik.entities.Product;

@Repository
public interface IProductDao extends JpaRepository<Product, Integer> {

}
