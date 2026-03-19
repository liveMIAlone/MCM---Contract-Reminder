package com.EacStudentPort.springboot.EAC1.controller;

import com.EacStudentPort.springboot.EAC1.model.Upload;
import com.EacStudentPort.springboot.EAC1.service.UploadService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController {

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    private final UploadService uploadService;

    @Autowired
    public UploadController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @GetMapping("/Upload")
    public String showUploadPage(Model model) {
        List<Upload> uploads = uploadService.getAllUploads();
        model.addAttribute("uploads", uploads);
        return "upload";
    }

    @GetMapping("/HomePage")
    public String showHomePage(Model model) {
        List<Upload> uploads = uploadService.getAllUploads();
        model.addAttribute("uploads", uploads);
        return "home";
    }
   

    @PostMapping("/Upload")
    public String submitProject(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("projectType") String projectType,
            @RequestParam("fileInput") MultipartFile file,
            RedirectAttributes redirectAttributes) {

        logger.info("Received form submission - Title: {}, Description: {}, Project Type: {}", title, description, projectType);

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "File is empty");
            logger.warn("Empty file submitted");
            return "redirect:/Upload";
        }

        try {
            // Save the file using the upload service
            uploadService.saveProjectWithFile(title, description, projectType, file);
            redirectAttributes.addFlashAttribute("successMessage", "Successfully uploaded");
            logger.info("File uploaded successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error uploading file: " + e.getMessage());
            logger.error("Error uploading file: " + e.getMessage());
        }

        return "redirect:/Upload";
    }
}
