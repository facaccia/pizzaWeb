package com.scai.esercizioPizza.entity.ordine;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "d_tipo_modifica_pizza", catalog = "pizzaweb")
public class TipoModificaPizzaEntity implements Serializable
{
	public TipoModificaPizzaEntity() {}
	
	private static final long serialVersionUID = 1945180467182956760L;
	
	private Long id;
	private String tipoModifica;
	
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
	
	@Column(name = "descrizione", nullable = false)
	public String getDescrizione()
	{
		return tipoModifica;
	}
	public void setDescrizione(String descrizione)
	{
		this.tipoModifica = descrizione;
	}
	@Override
	public String toString() {
		return  tipoModifica;
	}
	
	
}
