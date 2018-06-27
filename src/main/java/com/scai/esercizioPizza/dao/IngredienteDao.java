package com.scai.esercizioPizza.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scai.esercizioPizza.entity.IngredienteEntity;
import com.scai.esercizioPizza.model.Ingredient;
import com.scai.esercizioPizza.service.ConvertitoreService;

@Repository
public class IngredienteDao {
	
	
	@Autowired 
	private ConvertitoreService convertitoreService;
	
	@Autowired
	private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

	public List<Ingredient> getAll() {

		Session session1= getSession();
		Query <IngredienteEntity> query = session1.createQuery("from  IngredienteEntity", IngredienteEntity.class);
		 
		List<IngredienteEntity> listIngredienteEntity= query.getResultList();
		List<Ingredient> listPizza= convertitoreService.convertListIngredientEntityToListIngrediente(listIngredienteEntity);
		
		
		return listPizza;
	}

}
