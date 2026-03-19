package com.EacStudentPort.springboot.EAC1.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class FileDownload {

    @GetMapping("/downloadFile")
    @ResponseBody
    public ResponseEntity<byte[]> downloadFile(@RequestParam String filePath) throws IOException {
        // Load the file content
        byte[] content = Files.readAllBytes(Paths.get(filePath));

        // Set the headers for downloading the file
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setContentDispositionFormData("attachment", "data.json");

        // Return the file content with appropriate headers
        return ResponseEntity.ok()
                .headers(headers)
                .body(content);
    }
}
