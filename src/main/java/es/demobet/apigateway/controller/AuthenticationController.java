package es.demobet.apigateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.demobet.apigateway.model.dto.UserDto;
import es.demobet.apigateway.model.dto.request.LoginRequest;
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
	
	@GetMapping("/me")
    public ResponseEntity<UserDto> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        return ResponseEntity.ok(ObjectMapperUtils.map(currentUser, UserDto.class));
    }

    @PostMapping("/generate_token")
    public ResponseEntity<LoginResponse> generateToken(@RequestBody LoginRequest loginRequest) {
        User authenticatedUser = authenticationService.login(loginRequest);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
	
}
