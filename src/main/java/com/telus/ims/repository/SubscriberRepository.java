package com.telus.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telus.ims.model.Subscriber;

public interface SubscriberRepository extends JpaRepository<Subscriber, String> {

}
