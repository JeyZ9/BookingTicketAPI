package com.demo.newairport.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/api")
    public ResponseEntity<Object> getCountries() {
        String apiUrl = "https://restcountries.com/v3.1/all";
        return restTemplate.getForEntity(apiUrl, Object.class);
    }
}
