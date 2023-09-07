package com.telus.ims.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telus.ims.repository.FeaturesRepository;

@Service
public class FeaturesService {
	
    public FeaturesService(FeaturesRepository featuresRepository) {
        this.featuresRepository = featuresRepository;
    }
    
    private FeaturesRepository featuresRepository;
	
	
	   public ResponseEntity<?> findAll() {
	    	return ResponseEntity.ok().body(featuresRepository.findAll());
	    }

}
