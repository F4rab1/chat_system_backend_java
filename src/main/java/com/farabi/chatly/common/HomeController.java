package com.farabi.chatly.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    @Value("${spring.application.name}")
    private String appName;

    @GetMapping()
    public ResponseEntity<String> index() {
        return ResponseEntity.ok(appName);
    }
}
