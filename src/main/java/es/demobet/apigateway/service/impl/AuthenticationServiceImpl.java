package es.demobet.apigateway.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import es.demobet.apigateway.model.dto.request.LoginRequest;
import es.demobet.apigateway.model.entity.User;
import es.demobet.apigateway.repository.UserRepository;
import es.demobet.apigateway.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public User login(LoginRequest loginRequest) {
		authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        return userRepository.getByUsername(loginRequest.getUsername()).orElseThrow();
	}

}
