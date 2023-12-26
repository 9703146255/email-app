package in.thiru.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private final JavaMailSender javaMailSender;

	public void sendRegistrationEmail(String toEmail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toEmail);
		message.setSubject("Registration Successful");
		message.setText("Thank you for registering. Your registration is successful.");
		message.setText("you have a better future mr thiru");
		System.out.println("sendRegistrationEmail() method is executing");
		javaMailSender.send(message);
	}
}
