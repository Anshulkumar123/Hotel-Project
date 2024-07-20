package com.Hotel.Hotel.service;

import com.Hotel.Hotel.dto.LoginDto;
import com.Hotel.Hotel.dto.PropertyUserDto;
import com.Hotel.Hotel.entity.PropertyUser;
import com.Hotel.Hotel.repository.PropertyUserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {
    private PropertyUserRepository userRepository;

    private JWTService jwtService;

    public UserService(PropertyUserRepository userRepository, JWTService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public PropertyUser addUser(PropertyUserDto propertyUserDto){
        PropertyUser user = new PropertyUser();
        user.setUserRole(propertyUserDto.getUserRole());
        user.setFirstName(propertyUserDto.getFirstName());
        user.setLastName(propertyUserDto.getLastName());
        user.setUsername(propertyUserDto.getUsername());
        user.setEmail(propertyUserDto.getEmail());
        user.setPassword(BCrypt.hashpw(propertyUserDto.getPassword(), BCrypt.gensalt(10)));
        PropertyUser savedUser = userRepository.save(user);
        return savedUser;
    }

    public String verifyLogin(LoginDto loginDto) {
        Optional<PropertyUser> opUser = userRepository.findByUsername(loginDto.getUsername());
        if (opUser.isPresent()){
            PropertyUser propertyUser = opUser.get();
            if(BCrypt.checkpw(loginDto.getPassword(),propertyUser.getPassword())){
                return jwtService.generateToken(propertyUser);
            }
        }
        return null;
    }
}
