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

                 @Autowired
	private final EmailService emailService;

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("registrationForm", new RegistrationForm());
		System.out.println("yes showRegistrationForm its executed first");
		System.out.println("showRegistrationForm method is executing");

		return "registration";
	}

	@PostMapping("/register")
	public String processRegistration(RegistrationForm registrationForm) {
		// Perform form validation here if needed
		System.out.println("processRegistration() method executing here");
		// Send email
		emailService.sendRegistrationEmail(registrationForm.getEmail());

		return "success"; // Create a success.html template
	}
}
