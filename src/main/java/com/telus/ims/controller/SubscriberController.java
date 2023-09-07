package com.telus.ims.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telus.ims.model.Subscriber;
import com.telus.ims.service.SubscriberService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/ims")
public class SubscriberController {
	
    public SubscriberController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }
    
    private final Logger log = LoggerFactory.getLogger(SubscriberController.class);
    private SubscriberService subscriberService;
	
    @GetMapping("/subscriber/all")
    public ResponseEntity<?> findAll() {
        return subscriberService.findAll();
    }
    
    @GetMapping("subscriber/{phoneNumber}")
    public ResponseEntity<?> findById(@PathVariable String phoneNumber) {
        return subscriberService.findById(phoneNumber);
    }
    
    @PutMapping("subscriber/{phoneNumber}")
    public ResponseEntity<?> save(@PathVariable String phoneNumber,@Valid @RequestBody Subscriber subscriber) {
        return subscriberService.save(phoneNumber, subscriber);
    }

}
