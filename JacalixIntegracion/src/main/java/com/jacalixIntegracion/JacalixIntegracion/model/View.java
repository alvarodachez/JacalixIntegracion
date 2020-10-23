package com.jacalixIntegracion.JacalixIntegracion.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class View implements Serializable{

	int id;
	Product productViewed;
	LocalDate startView;
	LocalDate endView;
	
	public View() {
		super();
	}

	public View(int id,Product productViewed, LocalDate startView, LocalDate endView) {
		super();
		this.id = id;
		this.productViewed = productViewed;
		this.startView = startView;
		this.endView = endView;
	}

	public Product getProductViewed() {
		return productViewed;
	}

	public void setProductViewed(Product productViewed) {
		this.productViewed = productViewed;
	}

	public LocalDate getStartView() {
		return startView;
	}

	public void setStartView(LocalDate startView) {
		this.startView = startView;
	}

	public LocalDate getEndView() {
		return endView;
	}

	public void setEndView(LocalDate endView) {
		this.endView = endView;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
