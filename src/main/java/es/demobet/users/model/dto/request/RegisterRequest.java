package es.demobet.users.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

	private String name;
	
	private String surname;
	
	private String phoneNumber;
	
	private String username;
	
	private String password;
	
}
