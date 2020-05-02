package com.capgemini.rtvik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.rtvik.dto.ProductDto;
import com.capgemini.rtvik.entities.Product;
import com.capgemini.rtvik.service.IProductService;

@RestController
@EnableTransactionManagement
@RequestMapping("/products")
public class ProductController {

	private IProductService service;

	public IProductService getService() {
		return service;
	}
	@Autowired
	public void setService(IProductService service) {
		this.service = service;
	}
	
	public Product convertProductDto(ProductDto productDto) {
		Product product = new Product();
		product.setProductName(productDto.getProductName());
		product.setProductPrice(productDto.getProductPrice());
		product.setItemCount(productDto.getItemCount());
		return product;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody ProductDto productDto){
		Product product = convertProductDto(productDto);
		service.save(product);
		ResponseEntity<Product> response = new ResponseEntity<Product>(product, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") int id){
		Product product = service.findById(id);
		ResponseEntity<Product> response = new ResponseEntity<Product>(product, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Product>> fetchAllProduct(){
		List<Product> list= service.findAll(); 
		ResponseEntity<List<Product>> response= new ResponseEntity<List<Product>>(list,HttpStatus.OK);
		return response;
	}
	
	
	
}
