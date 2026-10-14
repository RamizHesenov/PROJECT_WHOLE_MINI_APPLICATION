package com.ramiz.spring_boot_security.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.ramiz.spring_boot_security.Models.Users;
import com.ramiz.spring_boot_security.Services.RegisterService;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService service;

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Users user){
        if(service.exists(user.getUsername())){
            return "redirect:/register?error";
        }
        service.SaveUser(user);
        return "redirect:/login";
    }
}