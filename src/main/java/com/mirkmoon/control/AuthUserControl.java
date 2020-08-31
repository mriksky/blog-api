package com.mirkmoon.control;



import com.mirkmoon.components.utils.JwtUtil;
import com.mirkmoon.dto.ApiResponse;
import com.mirkmoon.vo.JwtResponse;
import com.mirkmoon.vo.LoginRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Slf4j
@RestController
@RequestMapping("/")
public class AuthUserControl {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 构造一个自定义的API返回
     * @param loginRequest  状态返回信息
     * @return ApiResponse
     */
    @PostMapping("/login")
    public ApiResponse login(@Valid @RequestBody LoginRequest loginRequest){
        //
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));
        //
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.createJWT(authentication, loginRequest.getRememberMe());
        return ApiResponse.ofSuccess(new JwtResponse(jwt));
    }

    /**
     * 构造一个自定义的API返回
     * @param request  状态返回信息
     * @return ApiResponse
     */
    @PostMapping("/logout")
    public ApiResponse logout(HttpServletRequest request){
        return null;
    }
}
