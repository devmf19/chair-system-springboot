package com.devmf.chairSystem.security.controller;

import com.devmf.chairSystem.dto.Message;
import com.devmf.chairSystem.security.dto.JwtDto;
import com.devmf.chairSystem.security.dto.LoginDto;
import com.devmf.chairSystem.security.jwt.JwtProvider;
import com.devmf.chairSystem.security.model.User;
import com.devmf.chairSystem.security.service.implementation.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginUser, BindingResult bindingResult){
        log.info("username: "+loginUser.getUsername());
        log.info("password: "+loginUser.getPassword());

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new Message("Usuario inválido"), HttpStatus.UNAUTHORIZED);
        }

        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                ));

        SecurityContextHolder.getContext().setAuthentication(auth);


        String jwt = jwtProvider.generateToken(auth);
        JwtDto token = new JwtDto(jwt);

        User customer = userService.getByUsername(loginUser.getUsername());

        HashMap<String, String> response = new HashMap<>();
        response.put("token", token.getToken());
        response.put("dui", customer.getDui());
        response.put("name", customer.getName());
        response.put("lastname", customer.getLastname());
        response.put("username", customer.getUsername());

        return new ResponseEntity<Object>(response, HttpStatus.ACCEPTED);
    }
}
