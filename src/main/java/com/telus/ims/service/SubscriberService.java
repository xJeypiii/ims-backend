package com.telus.ims.service;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telus.ims.model.Subscriber;
import com.telus.ims.model.SubscriberDTO;
import com.telus.ims.repository.SubscriberRepository;

@Service
public class SubscriberService {

	public SubscriberService(SubscriberRepository subscriberRepository) {
		this.subscriberRepository = subscriberRepository;
	}

	private SubscriberRepository subscriberRepository;

	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok().body(subscriberRepository.findAll());
	}

	public ResponseEntity<?> findById(String id) {
		Optional<Subscriber> subscriber = subscriberRepository.findById(id);
		return subscriber.map(response -> 
		 ResponseEntity.ok().body(new SubscriberDTO(response))
		)
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	public ResponseEntity<?> save(String id, Subscriber subscriber) {
		subscriber.setPhoneNumber(id);
		Optional<Subscriber> data = subscriberRepository.findById(id);

		if (data.isEmpty()) {
			Subscriber result = subscriberRepository.save(subscriber);
			try {
				return ResponseEntity.created(new URI("/ims/subscriber/" + result.getPhoneNumber())).body(result);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} else {
			Subscriber result = subscriberRepository.save(subscriber);
			return ResponseEntity.ok().body(result);
		}
	}

	public ResponseEntity<?> delete(String id) {
		Optional<Subscriber> data = subscriberRepository.findById(id);
		if (data.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			subscriberRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
	}

}
