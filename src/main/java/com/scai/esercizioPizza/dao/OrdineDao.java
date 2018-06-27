package com.scai.esercizioPizza.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

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

	@Transactional
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Transactional
	public Order getOrdine(int id) {
		Session session = getSession();
		Query<OrdineEntity> query= session.createQuery("from OrdineEntity where id= "+ id, OrdineEntity.class);
		OrdineEntity ordineEntity= query.getSingleResult();
		Order ordine = convertitoreService.convertOrdineEntityToOrdine(ordineEntity);
		return ordine;
	}

	@Transactional
	public Order createOrdine(Order orderAngular) {
		
		
		OrdineEntity ordineEntity= convertitoreService.convertOrdineToOrdineEntity(orderAngular);
		System.out.println(ordineEntity.getOrdinePizzeEntity());
		CustomerEntity customerEntity= ordineEntity.getCustomerEntity();
		
		State statoOrdineEntity = orderAngular.getState();
		Session session = getSession();
		
		StatoOrdineEntity stato = convertitoreService.convertStatoToStatoOerdineEntity(statoOrdineEntity);
		
		ordineEntity.setIndirizzoConsegna(customerEntity.getIndirizzo());
		ordineEntity.setOrderState(stato);
		
		
		customerEntity.add(ordineEntity);
		Order ordine = this.salvataggioOrdine(ordineEntity);
		
		return ordine;
	}
	

	
	
	public Order salvataggioOrdine(OrdineEntity ordineEntity){
		
		Session session = getSession();
		
		List<OrdinePizzeEntity> ordinePizzeEntity= ordineEntity.getOrdinePizzeEntity();
		List<OrdineBevandeEntity> ordineBevandeEntity= ordineEntity.getOrdineBevandeEntity();
		
		
		for (OrdinePizzeEntity ordinePizzeEntity2 : ordinePizzeEntity) {
			
			List<OrdineModificaPizza> ordineModifica = ordinePizzeEntity2.getOrdineModificaPizzaList();
			System.out.println(ordineModifica);
			
			//ordineEntity.add(ordinePizzeEntity2);
			ordinePizzeEntity2.setOrdineEntity(ordineEntity);
			session.save(ordinePizzeEntity2);
			this.prova(ordinePizzeEntity2,ordineModifica);
			
//			for (OrdineModificaPizza ordineModificaPizza : ordineModifica) {
//				ordineModificaPizza.add(ordinePizzeEntity2);
//				System.out.println("poco prima del save");
//				session.beginTransaction();
//				session.save(ordineModificaPizza);
//				session.close();
//				System.out.println("poco dopo del save");
//				
//			}
//			 
//			
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

	
	private void prova(OrdinePizzeEntity ordinePizzeEntity2, List<OrdineModificaPizza> ordineModifica) {
		
		Session session = getSession();
		
		for (OrdineModificaPizza ordineModificaPizza : ordineModifica) {
			ordineModificaPizza.add(ordinePizzeEntity2);
			
			System.out.println("poco prima del save");
//			session.beginTransaction();
//			String sql = String.format("insert into r_modifica_pizza_ordine values ("+ ordineModificaPizza.getId()+", "+ordineModificaPizza.getOrderPizzas().getId()
//					+", "+ordineModificaPizza.getIngrediente().getId()+", 1)");
//			session.createSQLQuery(sql).executeUpdate();
//			session.getTransaction().commit();
//			session.close();
//			Query query = session.createQuery("insert into r_modifica_pizza_ordine values ("+ ordineModificaPizza.getId()+", "+ordineModificaPizza.getOrderPizzas().getId()
//					+", "+ordineModificaPizza.getIngrediente().getId()+", 1)");
			
			
			session.merge(ordineModificaPizza);

			System.out.println("poco dopo del save");
			
		}
		
	}
	
	

}
