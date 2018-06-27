package com.scai.esercizioPizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scai.esercizioPizza.model.Customer;
import com.scai.esercizioPizza.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value= "/login", method = RequestMethod.POST, headers="Accept=application/json")
	public Customer login(
			@RequestBody Customer customerAngular) {
		
		
		String nome = customerAngular.getNome();
		String numero = customerAngular.getTelefono();
		
		Customer customer= customerService.login(nome, numero);
		
		return customer;}
	

}
