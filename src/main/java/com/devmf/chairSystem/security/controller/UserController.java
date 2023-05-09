package com.devmf.chairSystem.security.controller;

import com.devmf.chairSystem.dto.Message;
import com.devmf.chairSystem.security.dto.JwtDto;
import com.devmf.chairSystem.security.dto.LoginDto;
import com.devmf.chairSystem.security.dto.UserDto;
import com.devmf.chairSystem.security.jwt.JwtProvider;
import com.devmf.chairSystem.security.model.User;
import com.devmf.chairSystem.security.service.implementation.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtProvider jwtProvider;

    @GetMapping("")
    public ResponseEntity<?> usersList(){
        return new ResponseEntity<>(
                userService.getAllUsers(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") long id) {
        UserDto result = userService.getUserById(id);
        if(userService.validateUser(result)) {
            new ResponseEntity<>(new Message("Not found user"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto){
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userService.saveUser(userDto);
        return new ResponseEntity<>(new Message("Saved user"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody UserDto userDto) {
        UserDto result = userService.getUserById(id);
        if (userService.validateUser(result)){
            return new ResponseEntity<>(new Message("Not found user"), HttpStatus.BAD_REQUEST);
        }
        userDto.setDui(userDto.getDui());
        userService.updateUser(userDto);

        return new ResponseEntity<>(new Message("Updated user"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
        UserDto result = userService.getUserById(id);
        if (result == null){
            return new ResponseEntity<>(new Message("Not found user"), HttpStatus.BAD_REQUEST);
        }
        userService.deleteUser(result);

        return new ResponseEntity<>(new Message("Deleted user"), HttpStatus.OK);
    }

}
