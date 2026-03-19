package com.EacStudentPort.springboot.EAC1.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {

    @GetMapping("/download-json")
    public ResponseEntity<byte[]> downloadJSON() {
        // Your logic to retrieve JSON data
        String jsonData = "{\"key\": \"value\"}";

        // Convert JSON string to bytes
        byte[] jsonBytes = jsonData.getBytes();

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setContentDispositionFormData("attachment", "data.json");

        // Return ResponseEntity with JSON bytes and headers
        return ResponseEntity.ok()
                .headers(headers)
                .body(jsonBytes);
    }
}
