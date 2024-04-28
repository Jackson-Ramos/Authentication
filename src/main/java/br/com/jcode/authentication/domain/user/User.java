package br.com.jcode.authentication.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "uaers")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String login;
	private String password;
	private String role;
}
