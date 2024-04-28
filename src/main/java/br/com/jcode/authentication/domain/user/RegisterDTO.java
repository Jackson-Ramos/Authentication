package br.com.jcode.authentication.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String login;
	private String password;
	private UserRole role;
}
