package es.demobet.users.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.demobet.users.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public Optional<User> getByUsername(@Param("username") String username);
	
	public Optional<User> getByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
