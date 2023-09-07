package com.telus.ims.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telus.ims.service.FeaturesService;

@RestController
@RequestMapping("/ims")
public class FeaturesController {
   
    public FeaturesController(FeaturesService featuresService) {
        this.featuresService = featuresService;
    }
    
    private final Logger log = LoggerFactory.getLogger(SubscriberController.class);
    private FeaturesService featuresService;
	
    @GetMapping("/features/all")
    public ResponseEntity<?> findAll() {
        return featuresService.findAll();
    }
}
