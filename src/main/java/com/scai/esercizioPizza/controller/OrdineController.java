package com.scai.esercizioPizza.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scai.esercizioPizza.model.Customer;
import com.scai.esercizioPizza.model.Order;
import com.scai.esercizioPizza.service.OrdineService;

@RestController
@RequestMapping("ordine")
public class OrdineController {
	
	@Autowired
	private OrdineService ordineService;
	
	@RequestMapping("/getOrdine/{id}")
	public Order getOrdine(
			@PathVariable("id") int id,
			HttpServletRequest request) {
		
		
		return ordineService.getOrdine(id);
		
	}
	
	@RequestMapping("/createOrder")
	public Order createOrder(
			@RequestBody Order orderAngular) {
		
		
		
		return ordineService.createOrdine(orderAngular);
		
	}

}
