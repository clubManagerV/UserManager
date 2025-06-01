package de.club.usermanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {


    @GetMapping("/v1/health")
    public ResponseEntity<String> isHealthCheck() {
        return ResponseEntity.ok(" UserManager Application is up and running");
    }
}
