package com.hydracorp.springbootfull.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hydracorp.springbootfull.model.Product;
import com.hydracorp.springbootfull.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public Optional<Product> findById(@PathVariable Integer id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Product insert(@RequestBody Product product) {
		return service.insert(product);
	}
	
	@DeleteMapping(value = "{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "Produto com id: " + id + " deletado com sucesso!";
	}
	
	@PutMapping(value = "{id}")
	public Product update(@RequestBody Product product, @PathVariable Integer id) {
		return service.update(id, product);
	}
}
