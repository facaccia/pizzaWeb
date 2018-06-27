package com.scai.esercizioPizza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scai.esercizioPizza.dao.PizzaDao;
import com.scai.esercizioPizza.model.Pizza;

@Service
public class PizzaService {
	
	@Autowired
	private PizzaDao pizzaDao;

	public List<Pizza> getAllPizza() {
		return pizzaDao.getAllPizza();
	}

	public Pizza getPizza(int id) {
		
		return  pizzaDao.getPizza(id);
		
		
	}

}
