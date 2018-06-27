package com.scai.esercizioPizza.entity.ordine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.scai.esercizioPizza.entity.PizzaEntity;

@Entity
@Table(name = "r_ordine_pizze", catalog = "pizzaweb")
public class OrdinePizzeEntity implements Serializable
{
	public OrdinePizzeEntity() {}
	
	private static final long serialVersionUID = -3663367171343991721L;
	
	private Long id;
	private OrdineEntity ordineEntity;
	private PizzaEntity pizzaEntity;
	private List<OrdineModificaPizza> ordineModificaPizzaList = new ArrayList<OrdineModificaPizza>(); 
	
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
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="id_ordine")
	public OrdineEntity getOrdineEntity() 
	{
		return ordineEntity;
	}
	public void setOrdineEntity(OrdineEntity order) 
	{
		this.ordineEntity = order;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
	@JoinColumn(name="id_pizza_base")
	public PizzaEntity getPizzaEntity() 
	{
		return pizzaEntity;
	}
	public void setPizzaEntity(PizzaEntity pizza) 
	{
		this.pizzaEntity = pizza;
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="id_ordine_pizza")
	public List<OrdineModificaPizza> getOrdineModificaPizzaList() 
	{
		return ordineModificaPizzaList;
	}
	
	public void setOrdineModificaPizzaList(List<OrdineModificaPizza> ordineModificaPizzaList) 
	{
		this.ordineModificaPizzaList = ordineModificaPizzaList;
	}
	
	@Override
	public String toString() {
		return "OrdinePizzeEntity [id=" + id + ", pizzaEntity=" + pizzaEntity
				+ ", ordineModificaPizzaList=" + ordineModificaPizzaList + "]";
	}
	
	
	public void add(OrdineModificaPizza ordineModificaPizza1) {
		if (ordineModificaPizzaList==null) {
			ordineModificaPizzaList = new ArrayList<OrdineModificaPizza>();
		}

		ordineModificaPizzaList.add(ordineModificaPizza1);
		ordineModificaPizza1.setOrderPizzas(this);
		
	}
}
