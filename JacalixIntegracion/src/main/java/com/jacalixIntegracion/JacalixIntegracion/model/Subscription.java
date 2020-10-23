package com.jacalixIntegracion.JacalixIntegracion.model;

import java.time.LocalDate;
import java.util.Date;

public class Subscription {

	int id;
	SubscriptionType rentType;
	LocalDate startSuscription;
	LocalDate endSuscription;
	int price;
	
	public Subscription() {
		
	}
	
	public Subscription(int id,SubscriptionType rentType, LocalDate startSuscription,LocalDate endSuscription,int price) {
		this.id = id;
		this.rentType = rentType;
		this.startSuscription = startSuscription;
		this.endSuscription = endSuscription;
		this.price = price;
	}

	public SubscriptionType getRentType() {
		return rentType;
	}

	public void setRentType(SubscriptionType rentType) {
		this.rentType = rentType;
	}

	public LocalDate getStartSuscription() {
		return startSuscription;
	}

	public void setStartSuscription(LocalDate startSuscription) {
		this.startSuscription = startSuscription;
	}

	public LocalDate getEndSuscription() {
		return endSuscription;
	}

	public void setEndSuscription(LocalDate endSuscription) {
		this.endSuscription = endSuscription;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
