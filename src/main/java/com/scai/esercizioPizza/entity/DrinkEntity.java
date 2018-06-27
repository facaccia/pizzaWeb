package com.scai.esercizioPizza.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "t_bevanda", catalog = "pizzaweb")
public class DrinkEntity {

	private Long id;
	private String descrizione;
	private Double prezzo;
	
	@Id
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@Column(name = "descrizione", length = 200)
	public String getDescrizione() 
	{
		return descrizione;
	}

	public void setDescrizione(String descrizione) 
	{
		this.descrizione = descrizione;
	}

	@Column(name = "prezzo", precision=6, scale=2)
	public Double getPrezzo() 
	{
		return prezzo;
	}

	public void setPrezzo(Double prezzo)
	{
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "DrinkEntity [id=" + id + ", descrizione=" + descrizione + ", prezzo=" + prezzo + "]";
	}
	
}
