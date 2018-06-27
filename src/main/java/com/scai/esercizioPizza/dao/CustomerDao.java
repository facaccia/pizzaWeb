package com.scai.esercizioPizza.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scai.esercizioPizza.entity.CustomerEntity;
import com.scai.esercizioPizza.model.Customer;
import com.scai.esercizioPizza.service.ConvertitoreService;

@Repository
public class CustomerDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private ConvertitoreService convertitoreService;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }


	public Customer login(String nome, String numero) {
		Session sessioneCorrente=getSession();	
		Customer risposta = new Customer();
		risposta.setNome(null);
		risposta.setCognome(null);
		risposta.setIndirizzo(null);
		
		
		//creare query 
		Query<CustomerEntity> query= sessioneCorrente.createQuery("from CustomerEntity", CustomerEntity.class);
		
		//eseguire la query
		
		List<CustomerEntity> customerEntity= query.getResultList();
		
		
		for (CustomerEntity customerEntity2 : customerEntity) {
			
			if(customerEntity2.getNome().toUpperCase().equals(nome.toUpperCase())&& customerEntity2.getTelefono().equals(numero)) {
				customerEntity2.setOrdine(null);
				risposta= convertitoreService.convertCustomerEntityToCustomer(customerEntity2);
				
				break;
		
				
			}
			  
			
			
		}
		return risposta;
		
		
	}


	public Customer salvaUser(Customer user) {
		//prendere sessione
				Session session= getSession();
			CustomerEntity customer = convertitoreService.convertCustomerToCustomerEntity(user);
				//salvare/modificare cliente
				session.saveOrUpdate(customer);
				user= convertitoreService.convertCustomerEntityToCustomer(customer);
				
		return user;
	}

}
