package com.hydracorp.springbootfull.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.hydracorp.springbootfull.model.Product;

@Repository
public class ProductRepository {

	private List<Product> products = new ArrayList<Product>();
	private Integer ultimoId = 0;
	
	public List<Product> finfAll(){
		return products;
	}
	
	public Optional<Product> findById(Integer id) {
		return products.stream().filter(product -> product.getId() == id).findFirst();
	}
}
