package br.com.jcode.authentication.controller;

import br.com.jcode.authentication.domain.product.Product;
import br.com.jcode.authentication.domain.product.ProductRequestDTO;
import br.com.jcode.authentication.domain.product.ProductResponseDTO;
import br.com.jcode.authentication.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public ResponseEntity list() {
		return ResponseEntity.ok(
				productRepository.findAll()
						.stream()
						.map(ProductResponseDTO::new).toList()
		);
	}
	
	@PostMapping()
	public ResponseEntity create(@RequestBody ProductRequestDTO productRequestDTO) {
		Product product = productRepository.save(new Product(productRequestDTO));
		return ResponseEntity.ok(product);
	}
}
