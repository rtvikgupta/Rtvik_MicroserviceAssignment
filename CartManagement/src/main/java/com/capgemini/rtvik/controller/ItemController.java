package com.capgemini.rtvik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.rtvik.dto.ItemDto;
import com.capgemini.rtvik.dto.ProductDto;
import com.capgemini.rtvik.entities.Item;
import com.capgemini.rtvik.service.IItemService;

@RestController
@EnableTransactionManagement
@RequestMapping("/items")
public class ItemController {

	@Autowired
	IItemService itemService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${productservice.baseurl}")
	private String baseProductServiceUrl;

	@GetMapping
	public ResponseEntity<List<Item>> fetchAll(){
		List<Item> list = itemService.findAll();
		ResponseEntity<List<Item>> response= new ResponseEntity<List<Item>>(list,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/findByUserId/{id}")
	public ResponseEntity<List<Item>> getItem(@PathVariable("id") String userId){
		List<Item> list = itemService.findAllByUserId(userId);
		ResponseEntity<List<Item>> response = new ResponseEntity<List<Item>>(list,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Item> addItem(@PathVariable("id") int itemId){
		Item item = itemService.findById(itemId);
		ResponseEntity<Item> response = new ResponseEntity<Item>(item,HttpStatus.OK);
		return response;
	}
	
	public Item convert(ItemDto dto) {
		Item item = new Item();
		item.setItemId(dto.getItemId());
		item.setUserId(dto.getUserId());
		item.setItemName(dto.getItemName());
		return item;
	}
	
	@PostMapping("/add/{pid}")
	public ResponseEntity<Item> addCart(@PathVariable("pid") int productId,@RequestBody ItemDto dto){
		ProductDto product = fetchProductById(productId);
		if(product!=null) {
			Item item = convert(dto);
			item.setItemprice(product.getProductPrice());
			itemService.save(item);
			ResponseEntity<Item> response = new ResponseEntity<Item>(item,HttpStatus.OK);
		return response;
		}
		return null;
	}
	
	public ProductDto fetchProductById(int productId) {
        String url = baseProductServiceUrl + "/get/" + productId;
        ProductDto productDto = restTemplate.getForObject(url, ProductDto.class);
        return productDto;

    }

}
