package br.com.jcode.authentication.domain.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String name;
	private Double price;
	
	public Product(ProductRequestDTO productRequestDTO) {
		this.name = productRequestDTO.getName();
		this.price = productRequestDTO.getPrice();
	}
}
