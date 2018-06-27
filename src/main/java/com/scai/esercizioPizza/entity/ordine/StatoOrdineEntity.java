package com.scai.esercizioPizza.entity.ordine;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "d_stato_ordine", catalog = "pizzaweb")
public class StatoOrdineEntity implements Serializable 
{
	public StatoOrdineEntity() {}
	
	private static final long serialVersionUID = 1051668688432831796L;
	
	private long id;
	private String descrizione;
	
	@Id
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() 
	{
		return id;
	}
	public void setId(long id) 
	{
		this.id = id;
	}
	
	@Column(name = "descrizione", nullable = false)
	public String getDescrizione() 
	{
		return descrizione;
	}
	public void setDescrizione(String descrizione) 
	{
		this.descrizione = descrizione;
	}
	
	@Override
	public String toString() {
		return "StatoOrdineEntity [id=" + id + ", descrizione=" + descrizione + "]";
	}

}