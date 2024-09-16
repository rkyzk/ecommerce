package com.api.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/** product name*/
	private String name;
	
	/** category */
	private String category;
	
	/** image url */
	private String imgUrl;
	
	/** available colors */
	private String colors;
	
	/** product description */
	private String description;
}
