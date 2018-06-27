package com.scai.esercizioPizza.model;

import java.io.Serializable;

public class Drink implements Serializable {

	private static final long serialVersionUID = -1059933595858605674L;
	
	private Long id;
	private String descrizione;
	private Double prezzo;
	
	public Long getId() 
	{
		return id;
	}
	
	public void setId(Long id) 
	{
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Drink [id=" + id + ", descrizione=" + descrizione + ", prezzo=" + prezzo + "]";
	}
	
	

}
