package com.Hotel.Hotel.controller;

import com.Hotel.Hotel.dto.LoginDto;
import com.Hotel.Hotel.dto.PropertyUserDto;
import com.Hotel.Hotel.entity.PropertyUser;
import com.Hotel.Hotel.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody PropertyUserDto propertyUserDto){
        PropertyUser propertyUser = userService.addUser(propertyUserDto);
        if (propertyUser!=null){
            return new ResponseEntity<>("Registration is successful", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        boolean status = userService.verifyLogin(loginDto);
        if (status){
            return new ResponseEntity<>("user signed in", HttpStatus.OK);
        }
        return new ResponseEntity<>("in valid credentials", HttpStatus.UNAUTHORIZED);
    }
}
