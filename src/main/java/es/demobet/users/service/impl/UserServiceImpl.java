package es.demobet.users.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.demobet.users.model.entity.User;
import es.demobet.users.repository.UserRepository;
import es.demobet.users.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User getByUsername(String username) {
		Optional<User> user = userRepository.getByUsername(username);
		return user.isPresent() ? user.get() : null;
	}


}
