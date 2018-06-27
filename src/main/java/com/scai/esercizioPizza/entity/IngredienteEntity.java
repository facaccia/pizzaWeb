package com.scai.esercizioPizza.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_ingrediente", catalog = "pizzaweb")
public class IngredienteEntity {

	private Long id;
	private String descrizione;
	private Double prezzoExtra;
	private int idPizzaAssociata;

	@Id
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "descrizione", length = 200)
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Column(name = "prezzo_extra", precision=6, scale=2)
	public Double getPrezzoExtra() {
		return prezzoExtra;
	}

	public void setPrezzoExtra(Double prezzoExtra) {
		this.prezzoExtra = prezzoExtra;
	}
	

	public int getIdPizzaAssociata() {
		return idPizzaAssociata;
	}

	public void setIdPizzaAssociata(int idPizzaAssociata) {
		this.idPizzaAssociata = idPizzaAssociata;
	}

	@Override
	public String toString() {
		return "IngredienteEntity [id=" + id + ", descrizione=" + descrizione + ", prezzoExtra=" + prezzoExtra
				+ ", idPizzaAssociata=" + idPizzaAssociata + "]";
	}


	
}
