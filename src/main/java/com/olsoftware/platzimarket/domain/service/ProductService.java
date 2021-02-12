package com.olsoftware.platzimarket.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olsoftware.platzimarket.domain.Product;
import com.olsoftware.platzimarket.domain.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository; 
	
	public List<Product> getAll(){
		return productRepository.getAll();
	}

	public Optional<List<Product>> getByCategory(int categoryId){
		return productRepository.getByCategory(categoryId);
	}

	public Optional<List<Product>> getScarseProducts(int quantity){
		return productRepository.getScarseProducts(quantity);
	}

	public Optional<Product> getProduct(int productId){
		return productRepository.getProduct(productId);
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}

	public boolean delete(int productId) {
		return getProduct(productId).map(product -> {
			productRepository.delete(productId);
			return true;
		}).orElse(false);
	}


}
