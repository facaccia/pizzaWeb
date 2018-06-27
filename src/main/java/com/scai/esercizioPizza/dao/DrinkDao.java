package com.scai.esercizioPizza.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scai.esercizioPizza.entity.DrinkEntity;
import com.scai.esercizioPizza.model.Drink;
import com.scai.esercizioPizza.service.ConvertitoreService;

@Repository
public class DrinkDao {
	
	
	@Autowired
	private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
    
    @Autowired
    private ConvertitoreService convertitoreService;


	public List<Drink> getAll() {
		
		Session session= getSession();
		
		Query<DrinkEntity> query= session.createQuery("from DrinkEntity", DrinkEntity.class);
		
		List<DrinkEntity> drinkEntities= query.getResultList();
		System.out.println(drinkEntities);
//		System.out.println(convertitoreService.convertListDrinkEntityToListDrink(drinkEntities));
		
		return convertitoreService.convertListDrinkEntityToListDrink(drinkEntities);
	}

}
