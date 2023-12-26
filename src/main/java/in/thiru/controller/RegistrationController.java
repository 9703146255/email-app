package in.thiru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

//RegistrationController.java

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.thiru.entity.RegistrationForm;
import in.thiru.service.EmailService;

@Controller
public class RegistrationController {

	private final EmailService emailService;

	public RegistrationController(EmailService emailService) {
		this.emailService = emailService;
	}
	
	
	
	

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("registrationForm", new RegistrationForm());
		return "registration";
	}

	@PostMapping("/register")
	public String processRegistration(RegistrationForm registrationForm) {
		// Perform form validation here if needed

		// Send email
		emailService.sendRegistrationEmail(registrationForm.getEmail());

		return "success"; // Create a success.html template
	}
}
