package com.jacalixIntegracion.JacalixIntegracion.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jacalixIntegracion.JacalixIntegracion.model.Customer;
import com.jacalixIntegracion.JacalixIntegracion.model.Subscription;
import com.jacalixIntegracion.JacalixIntegracion.model.View;
import com.jacalixIntegracion.JacalixIntegracion.services.CollectionService;
import com.jacalixIntegracion.JacalixIntegracion.services.CustomerService;

@RestController
@RequestMapping(path="/jacalix/customers")
@CrossOrigin(origins = "*")
public class CustomerController {
	
	@Autowired
	private CollectionService cService;
	
	@Autowired
	private CustomerService cusService;
	private List<Customer> customers = new ArrayList<>();
	
	@PostMapping
	public ResponseEntity<?> createCustomer(@RequestBody Customer c){
//		customers.add(c);
		return ResponseEntity.status(HttpStatus.CREATED).body(cService.createCustomer(c, this.customers));
		
	}
	
	@GetMapping
	public ResponseEntity<?> getCustomers(){
		if(customers!=null && !customers.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(cService.getCustomers(this.customers));
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
	}
	
	@PutMapping
	public ResponseEntity<?> updateCustomer(@RequestBody Customer c1){
		
		if(this.customers != null && !this.customers.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(cService.updateCustomer(c1,this.customers));
			
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteCustomer(@RequestBody Customer c2){
		if(this.customers!=null && !this.customers.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(cService.deleteCustomer(c2, this.customers));
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
		
	}
	
	@PutMapping(path="/subs/")
	public ResponseEntity<?> addSubscription(@RequestBody Subscription s, @RequestParam int id){
		if (this.customers!=null && !this.customers.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(cusService.addSubscription(s, id, this.customers));
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("HOLAAA");
		}
	}
	
	@PutMapping(path="/view/")
	public ResponseEntity<?> addView(@RequestBody View v,@RequestParam int id,@RequestParam int idP){
		if (this.customers!=null && !this.customers.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(cusService.addView(v, id, this.customers,idP));
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
	}

}
