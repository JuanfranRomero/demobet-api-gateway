package es.demobet.users.service;

import es.demobet.users.model.dto.request.LoginRequest;
import es.demobet.users.model.dto.request.RegisterRequest;
import es.demobet.users.model.entity.User;

public interface AuthenticationService {

	public User signup(RegisterRequest registerRequest) ;
	
    public User login(LoginRequest loginRequest);
    
}
