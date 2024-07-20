package com.Hotel.Hotel.service;

import com.auth0.jwt.algorithms.Algorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JWTService {
    @Value("${jwt.algorithm.key}")
    private String algorithmKey;
    @Value("${jwt.issuer}")
    private String issuer;
    @Value("${jwt.expiry.duration}")
    private int expiryTime;
    private Algorithm algorithm;

    @PostConstruct
    public void postConstruct(){
        System.out.println(algorithmKey);
        System.out.println(issuer);
        System.out.println(expiryTime);
    }
}
