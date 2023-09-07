package com.telus.ims.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class SubscriberDTO {
	
	public SubscriberDTO(Subscriber subscriber) {
		this.phoneNumber = subscriber.getPhoneNumber();
		this.username = subscriber.getUsername();
		this.password = subscriber.getPassword();
		this.domain = subscriber.getDomain();
		this.status = subscriber.getStatus();
		this.features = new FeaturesDTO(subscriber.getFeatures());
	}
	
	@NonNull
    private String phoneNumber;
	@NonNull
    private String username;
	@NonNull
    private String password;
	@NonNull
    private String domain;
	@NonNull
    private String status;
	@NonNull
    private FeaturesDTO features;
}
