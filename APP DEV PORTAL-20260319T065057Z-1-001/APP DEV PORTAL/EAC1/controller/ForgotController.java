package com.EacStudentPort.springboot.EAC1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.EacStudentPort.springboot.EAC1.model.User;
import com.EacStudentPort.springboot.EAC1.service.UserService;

@Controller
public class ForgotController {

    @Autowired
    private UserService service;

    @PostMapping("/user/login/validate")
    public String validateLogin(@RequestParam("email") String email,
                                @RequestParam("password") String password,
                                RedirectAttributes redi) {
        User u = service.findByEmail(email);
        if (u == null) {
            redi.addFlashAttribute("message", "Credentials not found...");
            return "redirect:/login";
        }

        boolean checkPassword = BCrypt.checkpw(password, u.getPassword());
        if (!checkPassword) {
            redi.addFlashAttribute("message", "Invalid login credentials...");
            return "redirect:/login";
        }

        return "redirect:/Home";
    }
    @PostMapping("/user/save")
    public String saveUserForm(User user, RedirectAttributes redi) {
        String salt = BCrypt.gensalt(10);
        String hashedPassword = BCrypt.hashpw(user.getPassword(), salt);
        user.setPassword(hashedPassword);
        redi.addFlashAttribute("message", "Credentials have been saved...");
        service.save(user);
        return "redirect:/login";
    }
    

}
