package es.demobet.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.demobet.users.model.dto.UserDto;
import es.demobet.users.model.entity.User;
import es.demobet.users.service.UserService;
import es.demobet.users.utils.ObjectMapperUtils;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDto>> findAll() {
		List<User> personList = userService.findAll();
		return ResponseEntity.ok(ObjectMapperUtils.mapList(personList, UserDto.class));	
	}
	
	@GetMapping("/me")
    public ResponseEntity<UserDto> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        return ResponseEntity.ok(ObjectMapperUtils.map(currentUser, UserDto.class));
    }
	
}
