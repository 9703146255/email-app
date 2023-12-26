package in.thiru.entity;

import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationForm {
	
	private String name;
	private String email;
	private long phno;

}
