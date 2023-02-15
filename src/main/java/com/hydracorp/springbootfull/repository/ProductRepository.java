package com.hydracorp.springbootfull.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.hydracorp.springbootfull.model.Product;
import com.hydracorp.springbootfull.model.exceptions.ResourceNotFoundException;

@Repository
public class ProductRepository {

	private List<Product> products = new ArrayList<Product>();
	private Integer ultimoId = 0;
	
	// Metodo para buscar todos produtos na lista
	public List<Product> finfAll(){
		return products;
	}
	
	// Metodo para buscar produtor por id
	public Optional<Product> findById(Integer id) {
		return products.stream().filter(product -> product.getId() == id).findFirst();
	}
	
	// Metodo para adicionar produto na lista
	public Product insert (Product product) {
		ultimoId ++;
		product.setId(ultimoId);
		products.add(product);
		return product;
	}
	
	// Metodo para remover produto por id
	public void delete(Integer id) {
		products.removeIf(product -> product.getId()== id);
	}
	
	public Product update(Product product) {
		//Encontra produto na lista
		Optional<Product> produtoEncontrado = findById(product.getId());
		if(produtoEncontrado.isEmpty()) {
			throw new ResourceNotFoundException("No product!");
		}
		//Eu tenho que remover o produto antigo da lista
		 delete(product.getId());
		 
		//Depois tenho que adicionar um novo produto
		 products.add(product);
		 return product;
	}
}
