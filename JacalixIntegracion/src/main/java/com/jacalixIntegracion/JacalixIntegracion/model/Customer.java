package com.jacalixIntegracion.JacalixIntegracion.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Serializable{

	private int id;
	private String name;
	private String surname;
	private String dni;
	private int age;
	private Subscription sub;
	private List<View>views;
	
	public Customer () {
		
	}
	
	public Customer (int id, String name, String surname, String dni, int age,Subscription sub) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.age = age;
		this.sub = sub;
		this.views = new ArrayList<>();
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Subscription getSub() {
		return sub;
	}

	public void setSub(Subscription sub) {
		this.sub = sub;
	}

	public List<View> getViews() {
		return views;
	}

	public void setViews(List<View> views) {
		this.views = views;
	}
	
	
	
//	public void addView(View v) {esto iria en el controller o en servicio
//		this.views.add(v);
//	}
	
	
}
