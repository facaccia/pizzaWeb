package com.scai.esercizioPizza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scai.esercizioPizza.model.Ingredient;
import com.scai.esercizioPizza.service.IngredienteService;

@RestController
@RequestMapping("/ingredienti")
public class IngridienteController {
	
	@Autowired
	private IngredienteService ingredienteService;
	
	@RequestMapping("/getAll")
	public List<Ingredient> getAllIngredienti(){
		
		return ingredienteService.getAll();
		
	}
	
	

}
