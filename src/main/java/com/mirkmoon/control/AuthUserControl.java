package com.mirkmoon.control;



import com.mirkmoon.components.utils.JwtUtil;
import com.mirkmoon.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class AuthUserControl {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ApiResponse login(LoginRequest loginRequest){
        return null;
    }

    @PostMapping("/logout")
    public String logout(){
        return "hello admin";
    }
}
