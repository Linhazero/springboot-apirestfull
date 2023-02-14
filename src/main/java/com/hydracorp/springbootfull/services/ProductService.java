package com.hydracorp.springbootfull.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hydracorp.springbootfull.model.Product;
import com.hydracorp.springbootfull.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.finfAll();
	}
	
	public Optional<Product> findById(Integer id) {
		return productRepository.findById(id);
	}
	
	public Product insert (Product product) {
		return productRepository.insert(product);
	}
	public void delete(Integer id) {
		productRepository.delete(id);
	}
	public Product update(Integer id, Product product) {
		product.setId(id);
		return productRepository.update(product);
	}
}
