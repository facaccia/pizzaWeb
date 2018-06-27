package com.scai.esercizioPizza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scai.esercizioPizza.model.Drink;
import com.scai.esercizioPizza.service.DrinkService;

@RestController
@RequestMapping("/drink")
public class DrinkController {

	
	@Autowired
	private DrinkService drinkService;
	
	@RequestMapping("/getAll")
	public List<Drink> getAll(){
		
		
		
		return drinkService.getAll();
	}
}
