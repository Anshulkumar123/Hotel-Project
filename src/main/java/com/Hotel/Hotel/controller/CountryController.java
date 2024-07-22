package com.Hotel.Hotel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {
    @RequestMapping("/addCountry")
    public String addCountry(){
        return "done";
    }
}
