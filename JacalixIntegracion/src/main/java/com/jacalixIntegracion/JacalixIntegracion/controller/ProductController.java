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

import com.jacalixIntegracion.JacalixIntegracion.model.Product;
import com.jacalixIntegracion.JacalixIntegracion.model.Category;
import com.jacalixIntegracion.JacalixIntegracion.model.SubscriptionType;
import com.jacalixIntegracion.JacalixIntegracion.services.CollectionService;

@RestController
@RequestMapping(path="/jacalix/products")
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
	private CollectionService cService;
	
	private static List<Product> products= new ArrayList<>();
	
	
	@PostMapping
	public ResponseEntity<?> createProduct(@RequestBody Product p) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cService.createProduct(p, products));

	}
	
	@GetMapping
	public ResponseEntity<?> getProducts() {
		if(products!=null && !products.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(cService.getProducts(this.products));
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
	}
	@GetMapping(path = "/")
	public ResponseEntity<?> getProduct(@RequestParam int id){
		if(products!=null && !products.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(cService.getProduct(id,this.products));
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
	}
	
	@PutMapping
	public ResponseEntity<?> updateProduct(@RequestBody Product p){
		if(products!=null && !products.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(cService.updateProduct(p,this.products));

		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");

		}
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteProduct(@RequestBody Product p2){
		if(this.products!=null && !this.products.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(cService.deleteProduct(p2, this.products));
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
		
	}

	
	//METODO PROVISIONAL HASTA QUE HAYA BBDD
	public static List<Product>getProduct() {
		return products;
	}
	
}
