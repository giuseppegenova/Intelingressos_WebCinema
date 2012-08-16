package br.com.cinema.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "filme")
@NamedQuery(name="Filme.findByNome", query="select f from Filme f where f.nome = :nome")
public class Filme implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1808765237432372920L;
	
	public static final String FIND_FILME_BY_NOME = "Filme.findByNome";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;		
	
	@Column(nullable = false, unique = true, updatable = true)
	private String nome;
	
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sinopse == null) ? 0 : sinopse.hashCode());
		result = prime * result
				+ ((siteOficial == null) ? 0 : siteOficial.hashCode());
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
		Filme other = (Filme) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
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
		return true;
	}

	@Override
	public String toString() {
		return "Filme [id=" + id + ", nome=" + nome + ", sinopse=" + sinopse
				+ ", siteOficial=" + siteOficial + "]";
	}

	
}
