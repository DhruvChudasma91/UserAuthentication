package com.example.dhruv.UserAuthentication.controller;

import ch.qos.logback.core.model.Model;
import com.example.dhruv.UserAuthentication.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    // Make sure this method exists to handle GET requests to /register
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        // Add any model attributes if needed
        return "register"; // This should be the name of your registration template
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("user") User user) {
        // Registration processing logic
        return "redirect:/login";
    }
}
