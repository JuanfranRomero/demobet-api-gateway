package es.demobet.apigateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.demobet.apigateway.model.dto.UserDto;
import es.demobet.apigateway.model.dto.request.LoginRequest;
import es.demobet.apigateway.model.dto.request.RegisterRequest;
import es.demobet.apigateway.model.dto.response.LoginResponse;
import es.demobet.apigateway.model.entity.User;
import es.demobet.apigateway.service.AuthenticationService;
import es.demobet.apigateway.service.JwtService;
import es.demobet.apigateway.utils.ObjectMapperUtils;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/signup")
    public ResponseEntity<UserDto> register(@RequestBody RegisterRequest registerRequest) {
        User registeredUser = authenticationService.signup(registerRequest);

        return ResponseEntity.ok(ObjectMapperUtils.map(registeredUser, UserDto.class));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest loginRequest) {
        User authenticatedUser = authenticationService.login(loginRequest);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
	
}
