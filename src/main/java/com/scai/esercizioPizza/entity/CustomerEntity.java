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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.scai.esercizioPizza.entity.ordine.OrdineEntity;

@Entity
@Table(name = "t_cliente", catalog = "pizzaweb")
public class CustomerEntity {
	private Long id;
	private String cognome;
	private String nome;
	private String indirizzo;
	private String telefono;
	private List<OrdineEntity> ordine;
	
	@Id
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "cognome", length = 100)
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	@Column(name = "nome", length = 100)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "indirizzo", length = 100)
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	@Column(name = "telefono", length = 100)
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "CustomerEntity [id=" + id + ", cognome=" + cognome + ", nome=" + nome + ", indirizzo=" + indirizzo
				+ ", telefono=" + telefono + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((indirizzo == null) ? 0 : indirizzo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerEntity other = (CustomerEntity) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (indirizzo == null) {
			if (other.indirizzo != null)
				return false;
		} else if (!indirizzo.equals(other.indirizzo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}
	
	
	@OneToMany(mappedBy = "customerEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	public List<OrdineEntity> getOrdine() {
		return ordine;
	}

	public void setOrdine(List<OrdineEntity> ordine) {
		this.ordine = ordine;
	}

	
	public void add(OrdineEntity ilCorso) {
			if (ordine==null) {
				ordine = new ArrayList<OrdineEntity>();
		}

		ordine.add(ilCorso);
		ilCorso.setCustomerEntity(this);
	}
	
}