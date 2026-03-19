package com.EacStudentPort.springboot.EAC1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.EacStudentPort.springboot.EAC1.model.Upload;
import com.EacStudentPort.springboot.EAC1.service.UploadService;

@Controller
public class HomeController {

    private final UploadService uploadService;

    @Autowired
    public HomeController(UploadService uploadService) {
        this.uploadService = uploadService;
    }
    
    @GetMapping("/Home")
    public String showHomePage(Model model) {
        // Retrieve all uploads
        List<Upload> uploads = uploadService.getAllUploads();
        model.addAttribute("uploads", uploads);

        // Retrieve publicity uploads if needed
        // List<Upload> publicityUploads = uploadService.getUploadsByType("publicity");
        // model.addAttribute("publicityUploads", publicityUploads);

        return "Home"; // Make sure the view name matches your HTML file name
    }
}
