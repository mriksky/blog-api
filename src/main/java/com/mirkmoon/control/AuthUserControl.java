package com.mirkmoon.control;


import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


/**
 *
 */
@Controller
public class AuthUserControl {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ApiResponse login(){
        return "";
    }

    @PostMapping("/logout")
    public String logout(){
        return "hello admin";
    }
}
