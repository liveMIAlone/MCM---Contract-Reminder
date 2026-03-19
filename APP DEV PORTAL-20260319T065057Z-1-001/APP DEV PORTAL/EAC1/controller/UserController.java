// UserController.java
package com.EacStudentPort.springboot.EAC1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.EacStudentPort.springboot.EAC1.model.User;
import com.EacStudentPort.springboot.EAC1.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @GetMapping("/Forgot")
    public String showUserPage(Model model) {
        model.addAttribute("user", new User());
        return "Forgot";
    }

    // Remove the showAdminHomePage method from here// 
    @PostMapping("/login/validate")
    public String findByEmailAddress(@RequestParam String email, 
    								 @RequestParam String password,RedirectAttributes redi){
    	User u = service.findByEmail(email);
    	if (u == null) {
    		redi.addFlashAttribute("message", "Email not found..");
    		return "redirect:/login";
    	}
    	System.out.println(u.getEmail() + " " + u.getPassword());
    	boolean checkPassword = BCrypt.checkpw(password, u.getPassword());
    	System.out.println(password);
    	if (!checkPassword) {
    		redi.addFlashAttribute("message", "Invalid login Credentials...");
    		return "redirect:/login";
    	}
    	else {
    		redi.addFlashAttribute("message", "Login Successfully");
    		return "redirect:/Home";
    	}
    	
    }
   
    @PostMapping("/user/Forgot")
    public String registerUser(User user, RedirectAttributes redi) {
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10));
        user.setPassword(hashedPassword);
        String[] emailParts = user.getEmail().split(",");
        user.setEmail(emailParts[0]);
        service.save(user);
        redi.addFlashAttribute("message", "User has been registered successfully!");
        return "redirect:/login";
    }

    }

