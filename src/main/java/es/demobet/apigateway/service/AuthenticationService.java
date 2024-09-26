package es.demobet.apigateway.service;

import es.demobet.apigateway.model.dto.request.LoginRequest;
import es.demobet.apigateway.model.dto.request.RegisterRequest;
import es.demobet.apigateway.model.entity.User;

public interface AuthenticationService {

	public User signup(RegisterRequest registerRequest) ;
	
    public User login(LoginRequest loginRequest);
    
}
