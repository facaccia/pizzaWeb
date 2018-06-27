package com.scai.esercizioPizza.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scai.esercizioPizza.entity.CustomerEntity;
import com.scai.esercizioPizza.entity.ordine.OrdineBevandeEntity;
import com.scai.esercizioPizza.entity.ordine.OrdineEntity;
import com.scai.esercizioPizza.entity.ordine.OrdineModificaPizza;
import com.scai.esercizioPizza.entity.ordine.OrdinePizzeEntity;
import com.scai.esercizioPizza.entity.ordine.StatoOrdineEntity;
import com.scai.esercizioPizza.model.Order;
import com.scai.esercizioPizza.model.Order.State;
import com.scai.esercizioPizza.service.ConvertitoreService;

@Repository
public class OrdineDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private ConvertitoreService convertitoreService;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

	public Order getOrdine(int id) {
		Session session = getSession();
		Query<OrdineEntity> query= session.createQuery("from OrdineEntity where id= "+ id, OrdineEntity.class);
		OrdineEntity ordineEntity= query.getSingleResult();
		Order ordine = convertitoreService.convertOrdineEntityToOrdine(ordineEntity);
		return ordine;
	}

	public Order createOrdine(Order orderAngular) {
		
		
		OrdineEntity ordineEntity= convertitoreService.convertOrdineToOrdineEntity(orderAngular);
		System.out.println(ordineEntity.getOrdinePizzeEntity());
		CustomerEntity customerEntity= ordineEntity.getCustomerEntity();
		List<OrdinePizzeEntity> ordinePizzeEntity= ordineEntity.getOrdinePizzeEntity();
		List<OrdineBevandeEntity> ordineBevandeEntity= ordineEntity.getOrdineBevandeEntity();
		
		State statoOrdineEntity = orderAngular.getState();
		Session session = getSession();
		
		StatoOrdineEntity stato = convertitoreService.convertStatoToStatoOerdineEntity(statoOrdineEntity);
		
		ordineEntity.setIndirizzoConsegna(customerEntity.getIndirizzo());
		ordineEntity.setOrderState(stato);
//		ordineEntity.getOrdinePizzeEntity()
		
		
		customerEntity.add(ordineEntity);
		session.save(ordineEntity);
		
		
		for (OrdinePizzeEntity ordinePizzeEntity2 : ordinePizzeEntity) {
			
			List<OrdineModificaPizza> ordineModifica = ordinePizzeEntity2.getOrdineModificaPizzaList();
			System.out.println(ordineModifica);
			
			//ordineEntity.add(ordinePizzeEntity2);
			ordinePizzeEntity2.setOrdineEntity(ordineEntity);
			session.save(ordinePizzeEntity2);
			
			for (OrdineModificaPizza ordineModificaPizza : ordineModifica) {
				//ordineModificaPizza.add(ordinePizzeEntity2);
				session.save(ordineModificaPizza);
				
			}
			
			
		}
		
		for (OrdineBevandeEntity ordineBevandeEntity2 : ordineBevandeEntity) {
			ordineBevandeEntity2.setOrdineEntity(ordineEntity);
			session.save(ordineBevandeEntity2);
		}

		StatoOrdineEntity stato2 = ordineEntity.getOrderState();
		State statoOrdine = convertitoreService.convertStatoOrdineToStato(stato2);
		Order ordine = convertitoreService.convertOrdineEntityToOrdine(ordineEntity);
		ordine.setState(statoOrdine);
		
		
		
		return ordine;
	}
	
	

}
