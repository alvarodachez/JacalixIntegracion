package com.jacalixIntegracion.JacalixIntegracion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.jacalixIntegracion.JacalixIntegracion.controller","com.jacalixIntegracion.JacalixIntegracion.services"})
public class JacalixIntegracionApplication {

	public static void main(String[] args) {
		SpringApplication.run(JacalixIntegracionApplication.class, args);
	}

}
