package br.com.jcode.authentication.domain.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private Integer price;
	
	public ProductResponseDTO(Product product) {
		this.id = product.getId();
		this.name = product.getName();
	}
}
