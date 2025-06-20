package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "🎉 ホットリロードが効いています！");
        model.addAttribute("name", "Spring Boot with DevTools");
        model.addAttribute("form", new NameForm());
        return "hello";
    }

    @PostMapping("/hello")
    public String postHello(@ModelAttribute("form") NameForm form, Model model) {
        model.addAttribute("message", "こんにちは、" + form.getUsername() + "さん！");
        model.addAttribute("name", "Spring Boot with DevTools");
        model.addAttribute("form", form);
        return "hello";
    }
} 