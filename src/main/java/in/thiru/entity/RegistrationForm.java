package in.thiru.entity;

import lombok.Data;

@Data

public class RegistrationForm {
	
	@Id
	private String name;
	private String email;
	private long phno;

}
