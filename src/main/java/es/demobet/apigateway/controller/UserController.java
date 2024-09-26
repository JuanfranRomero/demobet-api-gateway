package es.demobet.apigateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.demobet.apigateway.model.dto.UserDto;
import es.demobet.apigateway.model.entity.User;
import es.demobet.apigateway.utils.ObjectMapperUtils;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping("/me")
    public ResponseEntity<UserDto> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        return ResponseEntity.ok(ObjectMapperUtils.map(currentUser, UserDto.class));
    }
	
}
