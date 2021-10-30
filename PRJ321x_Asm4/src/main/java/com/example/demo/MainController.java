package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	@Autowired
	private AccountRepository accRepo;

	// Homepage
	@GetMapping("")
	public String toHomePage() {
		return "index";
	}

	// To Sign Up page
	@GetMapping("/signup")
	public String showSignUpPage(Model model) {
		model.addAttribute("acc", new Account());

		return "signup";
	}
	
	// Sign Up Success Page
	@PostMapping("/process_signup_success")
	public String processSignUp(Account acc) {
		// Encode password
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(acc.getPassword());
	    // Set encoded pass to account
	    acc.setPassword(encodedPassword);
	     
	    accRepo.save(acc);
	     
	    return "signup_success";
	}
	
	@GetMapping("/account")
	public String showAccount(Model model) {
		return "account";
	}
}
