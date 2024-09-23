package es.demobet.users.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.demobet.users.model.dto.request.RegisterRequest;

@RestController
@RequestMapping("/test")
public class TestController {

	@PostMapping
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok("Test OK");
    }
	
}
