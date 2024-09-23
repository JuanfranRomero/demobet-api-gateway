package es.demobet.users.service;

import java.util.List;

import es.demobet.users.model.entity.User;

public interface UserService {

	public List<User> findAll();
	
	public User getByUsername(String username);
	
}
