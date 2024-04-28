package br.com.jcode.authentication.domain.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name = "product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String name;
	private Integer price;
	
	public Product(ProductRequestDTO productRequestDTO) {
		this.name = productRequestDTO.getName();
		this.price = productRequestDTO.getPrice();
	}
}
