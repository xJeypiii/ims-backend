package com.telus.ims.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class FeaturesDTO {
	
	public FeaturesDTO(Features features) {
		this.id = features.getId();
		this.callForwardNoReply = features.getCallForwardNoReply();
	}
	
	@NonNull
	@JsonIgnore
	private Integer id;
	@NonNull
	private Details callForwardNoReply;

}
