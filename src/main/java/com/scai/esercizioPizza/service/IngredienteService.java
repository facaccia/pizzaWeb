package com.scai.esercizioPizza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scai.esercizioPizza.dao.IngredienteDao;
import com.scai.esercizioPizza.model.Ingredient;

@Service
public class IngredienteService {
	
	@Autowired
	private IngredienteDao ingredienteDao;

	public List<Ingredient> getAll() {
		return ingredienteDao.getAll();
		
	}
	
	

}
