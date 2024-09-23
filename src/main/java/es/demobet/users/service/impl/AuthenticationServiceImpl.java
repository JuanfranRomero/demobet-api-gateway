package es.demobet.users.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import es.demobet.users.model.dto.request.LoginRequest;
import es.demobet.users.model.dto.request.RegisterRequest;
import es.demobet.users.model.entity.User;
import es.demobet.users.repository.UserRepository;
import es.demobet.users.service.AuthenticationService;
import es.demobet.users.utils.ObjectMapperUtils;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public User signup(RegisterRequest registerRequest) {
		User user = ObjectMapperUtils.map(registerRequest, User.class);
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        return userRepository.save(user);
	}

	@Override
	public User login(LoginRequest loginRequest) {
		authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        return userRepository.getByUsername(loginRequest.getUsername()).orElseThrow();
	}

}
