package br.com.cinema.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ingressoCompra")
public class IngressoCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ingresso_id", unique = true)
	private Ingresso ingresso;	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ingressoTipo_id", unique = true)
	private IngressoTipo ingressoTipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ingresso getIngresso() {
		return ingresso;
	}

	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}

	public IngressoTipo getIngressoTipo() {
		return ingressoTipo;
	}

	public void setIngressoTipo(IngressoTipo ingressoTipo) {
		this.ingressoTipo = ingressoTipo;
	}

	@Override
	public String toString() {
		return "IngressoComprado [id=" + id + ", ingresso=" + ingresso
				+ ", ingressoTipo=" + ingressoTipo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((ingresso == null) ? 0 : ingresso.hashCode());
		result = prime * result
				+ ((ingressoTipo == null) ? 0 : ingressoTipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof IngressoCompra))
			return false;
		IngressoCompra other = (IngressoCompra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ingresso == null) {
			if (other.ingresso != null)
				return false;
		} else if (!ingresso.equals(other.ingresso))
			return false;
		if (ingressoTipo == null) {
			if (other.ingressoTipo != null)
				return false;
		} else if (!ingressoTipo.equals(other.ingressoTipo))
			return false;
		return true;
	}	
	
}
