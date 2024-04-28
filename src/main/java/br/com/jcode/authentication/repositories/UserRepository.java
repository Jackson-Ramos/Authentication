package br.com.jcode.authentication.repositories;

import br.com.jcode.authentication.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	UserDetails findByLogin(String login);
}
