package com.scai.esercizioPizza.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;
@Component
public class Customer implements Serializable {

	private static final long serialVersionUID = 828600077434665805L;
	private Long id;
	private String nome;
	private String cognome;
	private String indirizzo;
	private String telefono;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	



	@Override
	public String toString() {
		return "Customer [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", indirizzo=" + indirizzo
				+ ", telefono=" + telefono + "]";
	}

	

	
}
