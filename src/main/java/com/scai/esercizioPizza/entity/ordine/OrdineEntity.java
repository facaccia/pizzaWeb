package com.scai.esercizioPizza.entity.ordine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.scai.esercizioPizza.entity.CustomerEntity;

@Entity
@Table(name = "t_ordine", catalog = "pizzaweb")
public class OrdineEntity implements Serializable
{
	public OrdineEntity() {}
	
	private static final long serialVersionUID = 173690465454883553L;
	
	private Long id;
	private CustomerEntity customerEntity;
	private StatoOrdineEntity orderState;
	private String indirizzoConsegna;
	private Date dateOrder;
	private Date lastModifyTime;
	
	private List<OrdinePizzeEntity> ordinePizzeEntity;
	
	private List<OrdineBevandeEntity> ordineBevandeEntity;
	
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
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_ordine", nullable = false)
	public Date getDateOrder()
    {
		return dateOrder;
	}
	public void setDateOrder(Date dateOrder) 
	{
		this.dateOrder = dateOrder;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ultimo_cambiamento", nullable = true)
	public Date getLastModifyTime() {
		return lastModifyTime;
	}
	public void setLastModifyTime(Date lastModifyTime)
	{
		this.lastModifyTime = lastModifyTime;
	}
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name="id_stato")
	public StatoOrdineEntity getOrderState()
	{
		return orderState;
	}
	public void setOrderState(StatoOrdineEntity orderState)
	{
		this.orderState = orderState;
	}
	
	//@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	//@JoinColumn(name="id_ordine")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ordineEntity", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	public List<OrdinePizzeEntity> getOrdinePizzeEntity() 
	{
		return ordinePizzeEntity;
	}
	public void setOrdinePizzeEntity(List<OrdinePizzeEntity> ordinePizzeEntity) 
	{
		this.ordinePizzeEntity = ordinePizzeEntity;
	}
	
	//@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	//@JoinColumn(name="id_ordine")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ordineEntity", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	public List<OrdineBevandeEntity> getOrdineBevandeEntity() 
	{
		return ordineBevandeEntity;
	}
	public void setOrdineBevandeEntity(List<OrdineBevandeEntity> ordineBevandeEntity) 
	{
		this.ordineBevandeEntity = ordineBevandeEntity;
	}
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name="id_cliente")
	public CustomerEntity getCustomerEntity() 
	{
		return customerEntity;
	}
	
	public void setCustomerEntity(CustomerEntity customerEntity) 
	{
		this.customerEntity = customerEntity;
	}
	
	@Column(name = "indirizzo_consegna", nullable = false)
	public String getIndirizzoConsegna() {
		return indirizzoConsegna;
	}
	
	public void setIndirizzoConsegna(String indirizzoConsegna) {
		this.indirizzoConsegna = indirizzoConsegna;
	}
	
	
	
	@Override
	public String toString() {
		return "OrdineEntity [id=" + id  + ", orderState=" + orderState
				+ ", dateOrder=" + dateOrder + ", lastModifyTime=" + lastModifyTime + ", ordinePizzeEntity="
				+ ordinePizzeEntity + ", ordineBevandeEntity=" + ordineBevandeEntity + "]";
	}
	
	public void add(List<OrdinePizzeEntity> ilCorso, int numero) {
		
		for (int i = 0; i < ilCorso.size(); i++) {
			
			ordinePizzeEntity.add(ilCorso.get(i));
			ilCorso.get(i).setOrdineEntity(this);
		}
		
	}
	
	public void add(OrdinePizzeEntity ordinePizzeEntity1) {
			ordinePizzeEntity= new ArrayList<>();
			ordinePizzeEntity.add(ordinePizzeEntity1);
			ordinePizzeEntity1.setOrdineEntity(this);
	}
	
	public void add(OrdineBevandeEntity ordineBevandeEntity1) {
		ordineBevandeEntity= new ArrayList<>();
		ordineBevandeEntity.add(ordineBevandeEntity1);
		ordineBevandeEntity1.setOrdineEntity(this);
}
	
	

}