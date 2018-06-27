package com.scai.esercizioPizza.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scai.esercizioPizza.entity.PizzaEntity;
import com.scai.esercizioPizza.model.Pizza;
import com.scai.esercizioPizza.service.ConvertitoreService;

@Repository
public class PizzaDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private ConvertitoreService convertitoreService;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    
    public List<Pizza> getAllPizza(){
    	Session session1= getSession();
		Query <PizzaEntity> query = session1.createQuery("from  PizzaEntity", PizzaEntity.class);
		 
		List<PizzaEntity> listPizzaEntity= query.getResultList();
		List<Pizza> listPizza= convertitoreService.convertListPizzaEntityToListPizza(listPizzaEntity);
		return listPizza;	
    }
    
	public Pizza getPizza(int id) {
		
		Session session = getSession();
		Query<PizzaEntity> query= session.createQuery("from PizzaEntity where id= "+ id, PizzaEntity.class);
		PizzaEntity pizzaEntity= query.getSingleResult();
		Pizza pizza = convertitoreService.convertPizzaEntityToPizza(pizzaEntity);
		
		return pizza;
	}

}
