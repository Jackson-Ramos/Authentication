package br.com.jcode.authentication.controller;

import br.com.jcode.authentication.domain.user.AuthenticationDTO;
import br.com.jcode.authentication.domain.user.RegisterDTO;
import br.com.jcode.authentication.domain.user.User;
import br.com.jcode.authentication.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private final AuthenticationManager authenticationManager;
	
	@Autowired
	private final UserRepository userRepository;
	
	public AuthenticationController(AuthenticationManager authenticationManager, UserRepository userRepository) {
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
	}
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
		if (this.userRepository.findByLogin(data.getLogin()) != null) {
			return ResponseEntity.badRequest().build();
		}
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
		User newUser = new User(data.getLogin(), encryptedPassword, data.getRole());
		return ResponseEntity.ok().body(userRepository.save(newUser));
	}
}
