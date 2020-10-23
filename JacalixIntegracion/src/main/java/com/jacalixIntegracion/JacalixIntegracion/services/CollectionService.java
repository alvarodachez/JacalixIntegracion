package com.jacalixIntegracion.JacalixIntegracion.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jacalixIntegracion.JacalixIntegracion.model.Customer;
import com.jacalixIntegracion.JacalixIntegracion.model.Product;
import com.jacalixIntegracion.JacalixIntegracion.model.Subscription;
import com.jacalixIntegracion.JacalixIntegracion.model.View;

@Service
public class CollectionService {

	public Customer createCustomer(Customer c, List<Customer> customers){
		if(c.getSub() == null) {
			c.setSub(new Subscription());
		}
		if(c.getViews()== null) {
			c.setViews(new ArrayList<View>());
		}
		customers.add(c);
		
		return c;
	}
	
	public List<Customer> getCustomers(List<Customer> customers){
		return customers;
	}
	
	public Customer updateCustomer(Customer c1, List<Customer> customers) {
		customers.stream().filter(c -> c.getId() == c1.getId()).forEach((c2)->{
			if(c1.getName()!=null) {
				c2.setName(c1.getName());
			}
			if(c1.getSurname()!=null) {
				c2.setSurname(c1.getSurname());
			}
			if(c1.getDni() !=null) {
				c2.setDni(c1.getDni());
			}
			if((Integer)c1.getAge()!=null) {
				c2.setAge(c1.getAge());
			}
		});
		
		return c1;
	}
	
	public List<Customer> deleteCustomer(Customer c2,List<Customer> customers) {
		customers.stream().filter(c -> c.getId() == c2.getId()).forEach((c1)->{
			customers.remove(customers.indexOf(c1));
		});
		
		return customers;
	}
	
	public Product createProduct(Product p, List<Product> products){
		products.add(p);
		
		return p;
	}
	
	public List<Product> getProducts(List<Product> products){
		return products;
	}
	
	public Product getProduct(int id, List<Product> products) {
		Product aux = new Product();
		
		for(Product p : products) {
			if(p.getId() == id) {
				aux = p;
			}
		}
		
		return aux;
	}
	
	public Product updateProduct(Product p, List<Product>products) {
		products.stream().filter(c -> c.getId() == p.getId()).forEach((p2)->{
			if(p.getName()!=null) {
				p2.setName(p.getName());
			}
			if(p.getDescription()!=null) {
				p2.setDescription(p.getDescription());
			}
			if(p.getCat()!=null) {
				p2.setCat(p.getCat());
			}
			if(p.getRent()!=null) {
				p2.setRent(p.getRent());
			}
		});
		
		return p;
	}
	
	public List<Product> deleteProduct(Product p2,List<Product> products) {
		products.stream().filter(c -> c.getId() == p2.getId()).forEach((c1)->{
			products.remove(products.indexOf(c1));
		});
		
		return products;
	}
	
	
}
