package com.api.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ProductsController {
	
    @GetMapping("api.1.0/products")
    public ResponseEntity<?> getProducts() {
    	try {
    	    return productService.getProductList();
    	} catch (Exception e) {
    		// return;
    	}  	
    }
}
