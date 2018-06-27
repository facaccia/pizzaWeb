package com.scai.esercizioPizza.entity.ordine;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.scai.esercizioPizza.entity.IngredienteEntity;



@Entity
@Table(name = "r_modifica_pizza_ordine", catalog = "pizzaweb")
public class OrdineModificaPizza implements Serializable 
{
	public OrdineModificaPizza() {}
	
	private static final long serialVersionUID = 539411400375987017L;

	private Long id;
	private OrdinePizzeEntity ordinePizzaEntity;
	private IngredienteEntity ingredienteEntity;
	private TipoModificaPizzaEntity tipoModificaPizzaEntity;

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
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name="id_ordine_pizza")
	public OrdinePizzeEntity getOrderPizzas() 
	{
		return ordinePizzaEntity;
	}
	public void setOrderPizzas(OrdinePizzeEntity orderPizzas) 
	{
		this.ordinePizzaEntity = orderPizzas;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name="id_tipo_modifica")
	public TipoModificaPizzaEntity getTipoModificaPizzaEntry() 
	{
		return tipoModificaPizzaEntity;
	}
	public void setTipoModificaPizzaEntry(TipoModificaPizzaEntity typeMod) 
	{
		this.tipoModificaPizzaEntity = typeMod;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_ingrediente")
	public IngredienteEntity getIngrediente() 
	{
		return ingredienteEntity;
	}
	public void setIngrediente(IngredienteEntity ingrediente) 
	{
		this.ingredienteEntity = ingrediente;
	}





	@Override
	public String toString() {
		return "OrdineModificaPizza [ingredienteEntity=" + ingredienteEntity + ", tipoModificaPizzaEntity="
				+ tipoModificaPizzaEntity + "]";
	}

	public void add(OrdinePizzeEntity ordinePizzeEntity2) {
		this.ordinePizzaEntity= ordinePizzeEntity2;
		
	}
	
	
	
}