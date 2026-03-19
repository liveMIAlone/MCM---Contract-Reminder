package com.EacStudentPort.springboot.EAC1.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.EacStudentPort.springboot.EAC1.model.Upload;
import com.EacStudentPort.springboot.EAC1.repository.UploadRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UploadService {
	
	
    private UploadRepository uploadRepository;

    private static final Logger logger = LoggerFactory.getLogger(UploadService.class);
    private static final String UPLOAD_DIR = "uploads";

    @Autowired
    public UploadService(UploadRepository uploadRepository) {
        this.uploadRepository = uploadRepository;
    }

    public void saveUpload(Upload upload) {
        uploadRepository.save(upload);
    }

    public List<Upload> getAllUploads() {
        return uploadRepository.findAll();
    }

    public List<Upload> getUploadsByType(String type) {
        return uploadRepository.findByProjectType(type);
    }

    @Transactional
    public void saveProjectWithFile(String title, String description, String projectType, MultipartFile file) {
        try {
            if (file != null && !file.isEmpty() && file.getBytes().length > 0) {
                Path uploadPath = Paths.get(UPLOAD_DIR).toAbsolutePath();
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                Path filePath = uploadPath.resolve(file.getOriginalFilename());
                Files.write(filePath, file.getBytes());

                Upload project = new Upload();
                project.setTitle(title);
                project.setDescription(description);
                project.setProjectType(projectType);
                project.setFilePath(filePath.toString());
                uploadRepository.save(project);
                logger.info("Project saved successfully with file: {}", project.getFilePath());
            } else {
                throw new IllegalArgumentException("File is empty or null");
            }
        } catch (IOException e) {
            logger.error("Error saving project with file: {}", e.getMessage());
            throw new RuntimeException("Error saving project with file", e);
        }
    }
}
