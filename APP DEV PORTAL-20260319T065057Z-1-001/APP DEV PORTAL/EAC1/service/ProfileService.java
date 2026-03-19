package com.EacStudentPort.springboot.EAC1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.EacStudentPort.springboot.EAC1.model.Profile;
import com.EacStudentPort.springboot.EAC1.repository.ProfileRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.UUID;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private static final Logger logger = LoggerFactory.getLogger(ProfileService.class);

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile saveProfile(Profile profile) {
        if (profile == null) {
            throw new IllegalArgumentException("Profile cannot be null");
        }
        logger.info("Saving profile without file");
        return profileRepository.save(profile);
    }

    public void saveProfileWithFile(Profile profile, MultipartFile file) {
        try {
            if (profile == null) {
                throw new IllegalArgumentException("Profile is null");
            }

            // Set profile picture if file is not empty
            if (file != null && !file.isEmpty()) {
                profile.setProfilePicture(file.getBytes());
            }

            // Save the profile to the database
            profileRepository.save(profile);
            
            logger.info("Profile saved successfully with file: {}", profile.getEmail());
        } catch (IOException e) {
            logger.error("Error saving profile with file: {}", e.getMessage());
            throw new RuntimeException("Error saving profile with file", e);
        }
    }

    public Profile getProfile() {
        // Implement method to retrieve default profile from the database
        // For now, returning a new Profile instance to avoid null values
        return new Profile();
    }
}
