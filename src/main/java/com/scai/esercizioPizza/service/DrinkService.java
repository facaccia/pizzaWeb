package com.scai.esercizioPizza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scai.esercizioPizza.dao.DrinkDao;
import com.scai.esercizioPizza.model.Drink;

@Service
public class DrinkService {
	
	@Autowired
	private DrinkDao drinkDao;

	public List<Drink> getAll() {
		// TODO Auto-generated method stub
		return drinkDao.getAll();
	}
	
	

}
