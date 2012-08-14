package br.com.cinema.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "assossiado")
public class Assossiado extends Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4025231778594725316L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String cnpj;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cinema_id", unique = true)
	private Collection<Cinema> cinema;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "plano_id", unique = true)
	private Plano plano;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Collection<Cinema> getCinema() {
		return cinema;
	}

	public void setCinema(Collection<Cinema> cinema) {
		this.cinema = cinema;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	@Override
	public String toString() {
		return "Assossiado [id=" + id + ", cnpj=" + cnpj + ", cinema=" + cinema
				+ ", plano=" + plano + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cinema == null) ? 0 : cinema.hashCode());
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((plano == null) ? 0 : plano.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Assossiado))
			return false;
		Assossiado other = (Assossiado) obj;
		if (cinema == null) {
			if (other.cinema != null)
				return false;
		} else if (!cinema.equals(other.cinema))
			return false;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (plano == null) {
			if (other.plano != null)
				return false;
		} else if (!plano.equals(other.plano))
			return false;
		return true;
	}
	
	
}
