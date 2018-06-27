package com.scai.esercizioPizza.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scai.esercizioPizza.model.Pizza;
import com.scai.esercizioPizza.service.PizzaService;




@RequestMapping("pizze")
@RestController
public class PizzaController {
	

	@Autowired
	private PizzaService pizzaService;

	@Autowired
	private EntityManager entityManager;

	    private Session getSession() {
	        return entityManager.unwrap(Session.class);
	    }
	    
	    
	@RequestMapping("/welcome")
	public String welcome(HttpSession response) {
		
		
		return "welcome";
	}

	@RequestMapping("/getAll")
	public List<Pizza>	getAllPizza(){
		
		List<Pizza> listPizza= pizzaService.getAllPizza();
	
		return listPizza;
		
	}
	
	
	@RequestMapping("/getPizza/{id}")
	public Pizza getPizza(
			@PathVariable("id") int id,
					HttpServletRequest request) {
		
		Pizza pizza = pizzaService.getPizza(id);
		return pizza;
		}
	
	@RequestMapping("/createPizza")
	public Pizza createPizza(Pizza pizza){
		
		
		return null;
		
	}
	
	
}
