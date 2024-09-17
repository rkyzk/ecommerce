package com.api.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.ecommerce.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {
	@Autowired
	private ProductService productService;
	
    @GetMapping("api/1.0/products")
    public ResponseEntity<?> getProducts() {
//    	try {
    	    return ResponseEntity.ok(productService.findAll());
//    	} catch (Exception e) {
//    	}  	
    }
}
