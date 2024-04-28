package br.com.jcode.authentication.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String token;
}
