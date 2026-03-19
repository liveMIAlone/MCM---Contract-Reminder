package com.EacStudentPort.springboot.EAC1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.EacStudentPort.springboot.EAC1.model.Profile;
import com.EacStudentPort.springboot.EAC1.service.ProfileService;

@Controller
public class ProfileController {

    private final ProfileService profileService;
    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/Profile")
    public String showProfilePage(Model model) {
        // Retrieve profile data from the service layer
        Profile profile = profileService.getProfile();
        // Add the profile object to the model
        model.addAttribute("profile", profile);
        // Return the view name
        return "profile";
    }

    @PostMapping("/Profile/save")
    public String saveProfile(@ModelAttribute Profile profile,
                              @RequestParam("file") MultipartFile file,
                              RedirectAttributes redirectAttributes) {
        try {
            // Check if the file is empty
            if (!file.isEmpty()) {
                // Set profile picture data
                profile.setProfilePicture(file.getBytes());
            }

            // Call the service method to save the profile
            profileService.saveProfile(profile);

            // Add a success message
            redirectAttributes.addFlashAttribute("successMessage", "Profile saved successfully");
            logger.info("Profile saved successfully");
        } catch (Exception e) {
            // If an error occurs, add an error message
            redirectAttributes.addFlashAttribute("errorMessage", "Error saving profile: " + e.getMessage());
            logger.error("Error saving profile: {}", e.getMessage());
        }

        // Redirect back to the profile page
        return "redirect:/Profile";
    }
}
