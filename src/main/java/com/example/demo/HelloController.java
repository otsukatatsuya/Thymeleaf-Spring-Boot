package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "🎉 ホットリロードが効いています！");
        model.addAttribute("name", "Spring Boot with DevTools");
        return "hello";
    }
} 