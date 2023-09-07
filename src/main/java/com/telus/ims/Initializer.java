package com.telus.ims;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.telus.ims.model.Details;
import com.telus.ims.model.Features;
import com.telus.ims.model.Subscriber;
import com.telus.ims.repository.DetailsRepository;
import com.telus.ims.repository.FeaturesRepository;
import com.telus.ims.repository.SubscriberRepository;

@Component
public class Initializer implements CommandLineRunner {

	private final DetailsRepository detailsRepository;
	private final FeaturesRepository featuresRepository;
	private final SubscriberRepository subscriberRepository;

	public Initializer(DetailsRepository detailsRepository, FeaturesRepository featuresRepository, SubscriberRepository subscriberRepository) {
		this.detailsRepository = detailsRepository;
		this.featuresRepository = featuresRepository;
		this.subscriberRepository = subscriberRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		//populate details
		detailsRepository.save(new Details(true, "tel:+18675182800"));
		detailsRepository.save(new Details(false, "tel:+18675182800"));
		detailsRepository.save(new Details(true, "tel:+18675182811"));
		detailsRepository.save(new Details(false, "tel:+18675182811"));
				
		//populate features
		Details details = detailsRepository.findById(1).get();
		featuresRepository.save(new Features(details));
		Details details2 = detailsRepository.findById(2).get();
		featuresRepository.save(new Features(details2));
		Details details3 = detailsRepository.findById(3).get();
		featuresRepository.save(new Features(details3));
		Details details4 = detailsRepository.findById(4).get();
		featuresRepository.save(new Features(details4));
		
		//populate subscriber
		Features features = featuresRepository.findById(1).get();
		Subscriber subscriber = new Subscriber();
		subscriber.setPhoneNumber("18675181010");
		subscriber.setUsername("16045906403");
		subscriber.setPassword("p@ssw0rd!");
		subscriber.setDomain("ims.mnc660.mcc302.3gppnetwork.org");
		subscriber.setStatus("ACTIVE");
		subscriber.setFeatures(features);
		subscriberRepository.save(subscriber);
		

		subscriberRepository.findAll().forEach(System.out::println);

	}

}
