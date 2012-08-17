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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4025231778594725316L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String cargo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cinema_id", unique = true)
	private Collection<Cinema> cinema;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Collection<Cinema> getCinema() {
		return cinema;
	}

	public void setCinema(Collection<Cinema> cinema) {
		this.cinema = cinema;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((cinema == null) ? 0 : cinema.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Funcionario))
			return false;
		Funcionario other = (Funcionario) obj;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (cinema == null) {
			if (other.cinema != null)
				return false;
		} else if (!cinema.equals(other.cinema))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", cargo=" + cargo + ", cinema="
				+ cinema + "]";
	}
			
}
