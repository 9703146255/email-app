package in.thiru.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private final JavaMailSender javaMailSender;

	public void sendRegistrationEmail(String toEmail) {
		System.out.println("first added here");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toEmail);
		message.setSubject("Registration Successful");
		message.setText("Thank you for registering. Your registration is successful.");
		

		javaMailSender.send(message);
	}

	public void m2()
	{
	   int x=1000;
	   int y=2000;
	//logic
	}
