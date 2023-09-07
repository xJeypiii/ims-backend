package com.telus.ims.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "subscribers")
public class Subscriber {
	
	@Id
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
	@ManyToOne
    private Features features;
}
