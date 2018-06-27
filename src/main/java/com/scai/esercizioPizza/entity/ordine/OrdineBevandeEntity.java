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
import javax.persistence.Table;

import com.scai.esercizioPizza.entity.DrinkEntity;

@Entity
@Table(name = "r_ordine_bevande", catalog = "pizzaweb")
public class OrdineBevandeEntity implements Serializable
{
	public OrdineBevandeEntity() {}
	
	private static final long serialVersionUID = 8286690650314548176L;
	
	private Long id;
	private DrinkEntity drinkEntity;
	private OrdineEntity ordineEntity; 
	
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
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST} )
	@JoinColumn(name = "id_ordine", nullable = false)
	public OrdineEntity getOrdineEntity() 
	{
		return ordineEntity;
	}
	
	public void setOrdineEntity(OrdineEntity order) 
	{
		this.ordineEntity = order;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
	@JoinColumn(name = "id_bevanda", nullable = false)
	public DrinkEntity getDrinkEntity() {
		return drinkEntity;
	}
	
	public void setDrinkEntity(DrinkEntity drinkEntity) {
		this.drinkEntity = drinkEntity;
	}
	
	@Override
	public String toString() {
		return "OrdineBevandeEntity [id=" + id + ", drinkEntity=" + drinkEntity + ", ordineEntity=" + ordineEntity
				+ "]";
	}
	
}
