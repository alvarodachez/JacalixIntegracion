package com.jacalixIntegracion.JacalixIntegracion.model;


public class Product {
	
	private int id;
	private String name;
	private String description;
	private SubscriptionType rent;
	private Category cat;
	
	
	
	public Product () {
		
	}
	
	public Product (int id,String name,String description,SubscriptionType rent,Category cat) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.rent = rent;
		this.cat = cat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SubscriptionType getRent() {
		return rent;
	}

	public void setRent(SubscriptionType rent) {
		this.rent = rent;
	}

	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}
	
	
	
	
	
	

}
