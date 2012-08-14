package br.com.cinema.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "filme")
public class Filme implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1808765237432372920L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;		
	
	@Column(nullable = false, unique = true)
	private String titulo;
	
	@Column(nullable = false)
	private String sinopse;
	
	@Column
	private String siteOficial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getSiteOficial() {
		return siteOficial;
	}

	public void setSiteOficial(String siteOficial) {
		this.siteOficial = siteOficial;
	}

	@Override
	public String toString() {
		return "Filme [id=" + id + ", titulo=" + titulo + ", sinopse="
				+ sinopse + ", siteOficial=" + siteOficial + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((sinopse == null) ? 0 : sinopse.hashCode());
		result = prime * result
				+ ((siteOficial == null) ? 0 : siteOficial.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Filme))
			return false;
		Filme other = (Filme) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sinopse == null) {
			if (other.sinopse != null)
				return false;
		} else if (!sinopse.equals(other.sinopse))
			return false;
		if (siteOficial == null) {
			if (other.siteOficial != null)
				return false;
		} else if (!siteOficial.equals(other.siteOficial))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
}
