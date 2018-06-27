package com.scai.esercizioPizza.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pizza implements Serializable{

	private static final long serialVersionUID = -7442160532596212794L;

	private Long id;
	private String descrizione;
	private List<Ingredient> ingredientiList;
	private Double prezzo;
	private List<Ingredient> ordineModificaPizzaList;
	
	public Pizza()
	{
		ingredientiList = new ArrayList<Ingredient>();
		ordineModificaPizzaList = new ArrayList<Ingredient>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public List<Ingredient> getIngredientiList() {
		return ingredientiList;
	}

	public void setIngredientiList(List<Ingredient> ingredientiList) {
		this.ingredientiList = ingredientiList;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	public List<Ingredient> getOrdineModificaPizzaList() {
		return ordineModificaPizzaList;
	}

	public void setOrdineModificaPizzaList(List<Ingredient> ordineModificaPizzaList) {
		this.ordineModificaPizzaList = ordineModificaPizzaList;
	}

	public void addUnwantedIngredient(Ingredient ingredient)
	{
		getOrdineModificaPizzaList().add(ingredient);
	}
	
	public void addOrdineModificaPizzaList(Ingredient ingredient)
	{
		getOrdineModificaPizzaList().add(ingredient);
		
		if(ingredient.getTipoModifica().equals("A")) {
		setPrezzo(prezzo+ingredient.getPrezzoExtra());}
		
		System.out.println(prezzo);
	}
	

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", descrizione=" + descrizione + ", ingredientiList=" + ingredientiList + ", prezzo="
				+ prezzo + ", ordineModificaPizzaList=" + ordineModificaPizzaList + "]";
	}
	
	
	
	
	
}
