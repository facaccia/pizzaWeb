package com.scai.esercizioPizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scai.esercizioPizza.dao.CustomerDao;
import com.scai.esercizioPizza.model.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	
	public Customer login(String nome, String numero) {
		return customerDao.login(nome,numero);
	}


	public Customer salvaUser(Customer user) {
		// TODO Auto-generated method stub
		return customerDao.salvaUser(user);
	}
	
	

}
