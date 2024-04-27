package br.com.jcode.authentication.domain.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
	private String id;
	private String name;
	private BigDecimal price;
	
	public ProductResponseDTO(Product product) {
		this.id = product.getId();
		this.name = product.getName();
	}
}
