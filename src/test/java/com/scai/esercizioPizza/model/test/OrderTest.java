package com.scai.esercizioPizza.model.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.scai.esercizioPizza.model.Drink;
import com.scai.esercizioPizza.model.Ingredient;
import com.scai.esercizioPizza.model.Order;
import com.scai.esercizioPizza.model.Pizza;

public class OrderTest {

	@Test
	public void testCalculatePriceWithOnlyPizzas() {
		
		Order order = new Order();
		Pizza margherita = new Pizza();
		
		final Double prezzo = new Double(5.00);
		margherita.setPrezzo(prezzo);
		order.getOrdinePizzeEntity().add(margherita);
		
		assertEquals(prezzo, order.calculatePrice());
		
	}
	
	@Test
	public void testCalculatePriceWithPizzasAndDrinks() {
		
		Order order = new Order();
		Pizza margherita = new Pizza();
		Ingredient carciofi = new Ingredient();
		Double prezzoTotale = new Double(0.00);
		
		Double prezzoPizza = new Double(5.00);
		margherita.setPrezzo(prezzoPizza);
		
		final Double prezzoDrink = new Double(3.50);
		Drink birra= new Drink();
		birra.setPrezzo(prezzoDrink);
		order.getOrdineBevandeEntity().add(birra);
		
		final Double prezzoIngrediente = new Double(1.00);
		carciofi.setPrezzoExtra(prezzoIngrediente);
		carciofi.setTipoModifica("A");
		margherita.addOrdineModificaPizzaList(carciofi);
		
		System.out.println(prezzoPizza);
		
		order.getOrdinePizzeEntity().add(margherita);
		prezzoTotale+=prezzoDrink+prezzoPizza;
		
		assertEquals(prezzoTotale, order.calculatePrice());
		
	}


}
