package com.scai.esercizioPizza.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class Ingredient implements Serializable {

	private static final long serialVersionUID = -1309939830689222252L;

	private Long id;
	private String descrizione;
	private Double prezzoExtra;
	private String tipoModifica;
	private int idPizzaAssociata;
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getPrezzoExtra() {
		return prezzoExtra;
	}
	public void setPrezzoExtra(Double prezzoExtra) {
		this.prezzoExtra = prezzoExtra;
	}
	
	
	public String getTipoModifica() {
		return tipoModifica;
	}
	public void setTipoModifica(String tipoModifica) {
		this.tipoModifica = tipoModifica;
	}
	
	public int getIdPizzaAssociata() {
		return idPizzaAssociata;
	}
	public void setIdPizzaAssociata(int idPizzaAssociata) {
		this.idPizzaAssociata = idPizzaAssociata;
	}
	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", descrizione=" + descrizione + ", prezzoExtra=" + prezzoExtra
				+ ", tipoModifica=" + tipoModifica + "]";
	}
	
	
	
}
