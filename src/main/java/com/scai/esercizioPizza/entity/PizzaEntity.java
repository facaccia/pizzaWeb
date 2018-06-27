package com.scai.esercizioPizza.entity;

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
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_pizza", catalog = "pizzaweb")
public class PizzaEntity {

	private Long id;
	private String descrizione;
	private Double prezzo;

	private List<IngredienteEntity> ingredientiList;
	
	public PizzaEntity()
	{
		ingredientiList = new ArrayList<IngredienteEntity>();
	}
	
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

	@Column(name = "prezzo_base", precision=6, scale=2)
	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}


	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name= "r_pizza_ingredienti_base",
			joinColumns = @JoinColumn(name="id_pizza"),
			inverseJoinColumns = @JoinColumn( name="id_ingrediente")
	)
	public List<IngredienteEntity> getIngredientiList() {
		return ingredientiList;
	}


	public void setIngredientiList(List<IngredienteEntity> ingredientiList) {
		this.ingredientiList = ingredientiList;
	}

	@Override
	public String toString() {
		return "PizzaEntity [id=" + id + ", descrizione=" + descrizione + ", prezzo=" + prezzo + ", ingredientiList="
				+ ingredientiList + "]";
	}

}
