package com.scai.esercizioPizza.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scai.esercizioPizza.entity.CustomerEntity;
import com.scai.esercizioPizza.entity.DrinkEntity;
import com.scai.esercizioPizza.entity.IngredienteEntity;
import com.scai.esercizioPizza.entity.PizzaEntity;
import com.scai.esercizioPizza.entity.ordine.OrdineEntity;
import com.scai.esercizioPizza.entity.ordine.OrdineModificaPizza;
import com.scai.esercizioPizza.entity.ordine.OrdinePizzeEntity;
import com.scai.esercizioPizza.entity.ordine.StatoOrdineEntity;
import com.scai.esercizioPizza.entity.ordine.TipoModificaPizzaEntity;
import com.scai.esercizioPizza.model.Customer;
import com.scai.esercizioPizza.model.Drink;
import com.scai.esercizioPizza.model.Ingredient;
import com.scai.esercizioPizza.model.Order;
import com.scai.esercizioPizza.model.Order.State;
import com.scai.esercizioPizza.model.Pizza;

@Service
public class ConvertitoreService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PizzaEntity convertPizzaToPizzaEntity(Pizza pizza) {
		PizzaEntity pizzaEntity= getModelMapper().map(pizza, PizzaEntity.class);
		return pizzaEntity;}
	
	public Pizza convertPizzaEntityToPizza(PizzaEntity pizzaEntity) {
		getModelMapper().getConfiguration().setPropertyCondition(Conditions.isNotNull());
		getModelMapper().getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Pizza pizza= getModelMapper().map(pizzaEntity, Pizza.class);
		return pizza;}
	
	public List<PizzaEntity> convertListPizzaToListPizzaEntity(List<Pizza> listPizza) {
		
		java.lang.reflect.Type targetListType = new TypeToken<List<PizzaEntity>>() {}.getType();
		List<PizzaEntity> listPizzaEntity = getModelMapper().map(listPizza, targetListType);
		return listPizzaEntity;}
	
	public List<Pizza> convertListPizzaEntityToListPizza(List<PizzaEntity> listPizzaEntity) {
		
		getModelMapper().getConfiguration().setPropertyCondition(Conditions.isNotNull());
		getModelMapper().getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		java.lang.reflect.Type targetListType = new TypeToken<List<Pizza>>() {}.getType();
		List<Pizza> listPizza = getModelMapper().map(listPizzaEntity, targetListType);
		return listPizza;}
	
	
	public Customer convertCustomerEntityToCustomer(CustomerEntity customerEntity) {
		Customer customer = getModelMapper().map(customerEntity, Customer.class);
		return customer;
	}
	
	public CustomerEntity convertCustomerToCustomerEntity(Customer customer) {
		CustomerEntity customerEntity = getModelMapper().map(customer, CustomerEntity.class);
		return customerEntity;
	}

	public Order convertOrdineEntityToOrdine(OrdineEntity ordineEntity) {
		getModelMapper().getConfiguration().setPropertyCondition(Conditions.isNotNull());
		getModelMapper().getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		getModelMapper().getConfiguration().setAmbiguityIgnored(true);
		
		Order ordine= getModelMapper().map(ordineEntity, Order.class);
		return ordine;
	}
	
	public OrdineEntity convertOrdineToOrdineEntity(Order ordine) {
		
//		List<OrdineModificaPizza> ordineModifiList= new ArrayList<OrdineModificaPizza>();
//		List<Pizza> ordinePizze = ordine.getOrdinePizzeEntity();
//		OrdineModificaPizza modificaConver = null;
//		for (Pizza pizza : ordinePizze) {
//			if(pizza.getOrdineModificaPizzaList().size()!=0) {
//			List<Ingredient> ordineModifica = pizza.getOrdineModificaPizzaList();
//			for (Ingredient ingredient : ordineModifica) {
//				 modificaConver = this.convertListIngredientiToListModificaEntity(ingredient);
//				 PizzaEntity pizzaEntity = this.convertPizzaToPizzaEntity(pizza);
//				OrdinePizzeEntity ordinePizzaProva= new OrdinePizzeEntity();
//				ordinePizzaProva.setPizzaEntity(pizzaEntity);
//				 modificaConver.setOrderPizzas(ordinePizzaProva);
//				
//				 System.out.println("modifica Ordine "+modificaConver.getOrderPizzas().getPizzaEntity().getId());
//				 System.out.println("modifica Ordine pizza associata "+modificaConver.getIngrediente().getIdPizzaAssociata());
//				 //modificaConver.setOrderPizzas(pizza);
//				 if (modificaConver.getIngrediente().getIdPizzaAssociata()== pizza.getId()) {
//					 System.out.println("entrato nell if");
//					 ordineModifiList.add(modificaConver);
//				 }
//			}
//			}
//		}
		
		
		getModelMapper().getConfiguration().setPropertyCondition(Conditions.isNotNull());
		getModelMapper().getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		getModelMapper().getConfiguration().setAmbiguityIgnored(true);
		
		
		OrdineEntity ordineEntity= getModelMapper().map(ordine, OrdineEntity.class);
		
		for (Pizza ordinePizzeEntity : ordine.getOrdinePizzeEntity()) {
			if(ordinePizzeEntity.getOrdineModificaPizzaList().size()!=0) {
				for (Ingredient ingredienteModifica : ordinePizzeEntity.getOrdineModificaPizzaList()) {
					
					OrdineModificaPizza ordineModifica = this.convertIngredientiToModificaEntity(ingredienteModifica);
					System.out.println("ciao "+ordineModifica);
					for (OrdinePizzeEntity ordinePizzeEntity1 : ordineEntity.getOrdinePizzeEntity()) {
						if (ordinePizzeEntity1.getOrdineModificaPizzaList().size()!=0 && ordinePizzeEntity1.getPizzaEntity().getId()==ingredienteModifica.getIdPizzaAssociata()) {
							List<OrdineModificaPizza> ordineModificaPizzaList = new ArrayList<OrdineModificaPizza>();
							ordineModificaPizzaList.add(ordineModifica);
							ordinePizzeEntity1.setOrdineModificaPizzaList(ordineModificaPizzaList);
							
						}
				}
			}
		}
}
		
			

		
		List<OrdinePizzeEntity> ordinePizze1 = ordineEntity.getOrdinePizzeEntity();
//		for (OrdinePizzeEntity ordinePizzeEntity : ordinePizze1) {
//			ordinePizzeEntity.setOrdineModificaPizzaList(ordineModifiList);
//		}
		
		return ordineEntity;
	}

	private ModelMapper getModelMapper() {
		return modelMapper;
	}

	public List<Ingredient> convertListIngredientEntityToListIngrediente(
			List<IngredienteEntity> listIngredienteEntity) {
		getModelMapper().getConfiguration().setPropertyCondition(Conditions.isNotNull());
		getModelMapper().getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		java.lang.reflect.Type targetListType = new TypeToken<List<Ingredient>>() {}.getType();
		List<Ingredient> listIngredient = getModelMapper().map(listIngredienteEntity, targetListType);
		return listIngredient;
	}

	public List<Drink> convertListDrinkEntityToListDrink(List<DrinkEntity> listDrinkEntity) {
			getModelMapper().getConfiguration().setPropertyCondition(Conditions.isNotNull());
			getModelMapper().getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			java.lang.reflect.Type targetListType = new TypeToken<List<Drink>>() {}.getType();
			List<Drink> listDrink = getModelMapper().map(listDrinkEntity, targetListType);
			return listDrink;
		
	}
	
	
	
	public OrdineModificaPizza convertIngredientiToModificaEntity(Ingredient listIngredients) {
		
		
			
		IngredienteEntity ingrediente = this.convertIngredientToIngredientEntity(listIngredients);
		OrdineModificaPizza ordineModifica = new OrdineModificaPizza();
		ordineModifica.setId(listIngredients.getId());
		TipoModificaPizzaEntity tipoModificaPizzaEntity= new TipoModificaPizzaEntity();
		tipoModificaPizzaEntity.setDescrizione(listIngredients.getTipoModifica());
		ordineModifica.setIngrediente(ingrediente);
		ordineModifica.setTipoModificaPizzaEntry(tipoModificaPizzaEntity);
		

		return ordineModifica;
	
	}
	
	public OrdineModificaPizza convertIngredientEntityToModificaEntity(Ingredient listIngredients) {
		
		
		
		IngredienteEntity ingrediente = this.convertIngredientToIngredientEntity(listIngredients);
		OrdineModificaPizza ordineModifica = new OrdineModificaPizza();
		ordineModifica.setId(listIngredients.getId());
		TipoModificaPizzaEntity tipoModificaPizzaEntity= new TipoModificaPizzaEntity();
		tipoModificaPizzaEntity.setDescrizione(listIngredients.getTipoModifica());
		ordineModifica.setIngrediente(ingrediente);
		ordineModifica.setTipoModificaPizzaEntry(tipoModificaPizzaEntity);
		

		return ordineModifica;
	
	}
	
	
	public OrdineModificaPizza convertListIngredientiToListModificaEntity2(Ingredient listIngredients, String tipoModifica) {
		OrdineModificaPizza pizzaEntity= getModelMapper().map(listIngredients, OrdineModificaPizza.class);
		TipoModificaPizzaEntity tipoModificaPizzaEntity= new TipoModificaPizzaEntity();
		tipoModificaPizzaEntity.setDescrizione(tipoModifica);
		pizzaEntity.setTipoModificaPizzaEntry(tipoModificaPizzaEntity);
		return pizzaEntity;
	
	}
	
	
	
	
	
	public List<DrinkEntity> convertListDrinkToListDrinkEntity(List<Drink> listDrink) {
		getModelMapper().getConfiguration().setPropertyCondition(Conditions.isNotNull());
		getModelMapper().getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		java.lang.reflect.Type targetListType = new TypeToken<List<DrinkEntity>>() {}.getType();
		List<DrinkEntity> listDrinkEntity = getModelMapper().map(listDrink, targetListType);
		return listDrinkEntity;
	
	}
	
	public List<IngredienteEntity> convertListIngredientToListIngredienteEntity(List<Ingredient> listIngredients) {
		getModelMapper().getConfiguration().setPropertyCondition(Conditions.isNotNull());
		getModelMapper().getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		java.lang.reflect.Type targetListType = new TypeToken<List<IngredienteEntity>>() {}.getType();
		List<IngredienteEntity> listIngredienteEntities = getModelMapper().map(listIngredients, targetListType);
		return listIngredienteEntities;
	
	}
	
	public IngredienteEntity convertIngredientToIngredientEntity(Ingredient ingredient) {
		IngredienteEntity ingredienteEntity = getModelMapper().map(ingredient, IngredienteEntity.class);
		return ingredienteEntity;
	}
	
	
	

	
	public StatoOrdineEntity convertStatoToStatoOerdineEntity(Order.State stato) {
		
		StatoOrdineEntity statoOrdine= new StatoOrdineEntity();
		statoOrdine.setDescrizione(stato.name());
		if (statoOrdine.getDescrizione()=="RECEIVED") {
			
			statoOrdine.setId(1);
		}
		else if(statoOrdine.getDescrizione()=="WORKING") {
			statoOrdine.setId(2);
		}
		else if(statoOrdine.getDescrizione()=="DELIVERING") {
			statoOrdine.setId(3);
		}
		else if(statoOrdine.getDescrizione()=="ACCOMPLISCHED") {
			statoOrdine.setId(4);
		}
		return statoOrdine;}
	
	public Order.State convertStatoOrdineToStato(StatoOrdineEntity stato) {
			
			Order.State statoOrdine = State.RECEIVED;
			statoOrdine.equals(stato.getDescrizione());
			
			return statoOrdine;}

	
	

}
