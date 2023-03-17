package com.devmf.chairSystem.controller;

import com.devmf.chairSystem.dto.Message;
import com.devmf.chairSystem.dto.UserDto;
import com.devmf.chairSystem.service.implementation.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("")
    public ResponseEntity<?> usersList(){
        return new ResponseEntity<>(
                userService.getUsers(),
                HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") long id) {
        UserDto result = userService.getUserById(id);
        return result == null ?
                new ResponseEntity<>(new Message("Not found user"), HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
        return new ResponseEntity<>(new Message("Saved user"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody UserDto userDto) {
        UserDto result = userService.getUserById(id);
        if (result == null){
            return new ResponseEntity<>(new Message("Not found user"), HttpStatus.BAD_REQUEST);
        }
        userDto.setId(result.getId());
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
