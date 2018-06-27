package com.scai.esercizioPizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scai.esercizioPizza.dao.OrdineDao;
import com.scai.esercizioPizza.model.Order;

@Service
public class OrdineService {
	
	@Autowired
	private OrdineDao ordineDao;

	public Order getOrdine(int id) {
		// TODO Auto-generated method stub
		return ordineDao.getOrdine(id);
	}

	public Order createOrdine(Order orderAngular) {
		// TODO Auto-generated method stub
		return ordineDao.createOrdine(orderAngular);
	}

	
	
}
