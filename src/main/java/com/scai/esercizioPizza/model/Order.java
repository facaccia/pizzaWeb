package com.scai.esercizioPizza.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	public enum State implements Serializable{
		
		RECEIVED, WORKING, DELYVERING, ACCOMPLISHED;
	}
	
	private Long id;
	private Customer customer;
	private String indirizzoConsegna;
	private Double extraDeliveryPrice;
	private List<Pizza> ordinePizzeEntity;
	private List<Drink> ordineBevandeEntity;
	private Date date;
	private Date lastModifyTime;
	private State state;
	
	public Order() {
		ordinePizzeEntity = new ArrayList<Pizza>();
		ordineBevandeEntity= new ArrayList<Drink>();
	} 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

	public String getIndirizzoConsegna() {
		return indirizzoConsegna;
	}

	public void setIndirizzoConsegna(String indirizzoConsegna) {
		this.indirizzoConsegna = indirizzoConsegna;
	}

	public Double getExtraDeliveryPrice() {
		return extraDeliveryPrice;
	}

	public void setExtraDeliveryPrice(Double extraDeliveryPrice) {
		this.extraDeliveryPrice = extraDeliveryPrice;
	}



	public List<Pizza> getOrdinePizzeEntity() {
		return ordinePizzeEntity;
	}

	public void setOrdinePizzeEntity(List<Pizza> ordinePizzeEntity) {
		this.ordinePizzeEntity = ordinePizzeEntity;
	}



	public List<Drink> getOrdineBevandeEntity() {
		return ordineBevandeEntity;
	}

	public void setOrdineBevandeEntity(List<Drink> ordineBevandeEntity) {
		this.ordineBevandeEntity = ordineBevandeEntity;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public Double calculatePrice() {
		Double total = new Double(0);
		
		
		for (Pizza p: getOrdinePizzeEntity()) {
			total += p.getPrezzo();
		}
		
		for (Drink p: getOrdineBevandeEntity()) {
			total += p.getPrezzo();
		}

		
		
		
		return total;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", deliveryAddress=" + indirizzoConsegna
				+ ", extraDeliveryPrice=" + extraDeliveryPrice + ", pizzas=" + ordinePizzeEntity + ", drinks=" + ordineBevandeEntity + ", date="
				+ date + ", lastModifyTime=" + lastModifyTime + ", state=" + state + "]";
	}

}
