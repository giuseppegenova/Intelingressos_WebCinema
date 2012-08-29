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
		return Integer.parseInt(id.toString());
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Filme){
			Filme filme = (Filme) obj;
			return filme.getId() == id;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Filme [id=" + id + ", nome=" + nome + ", sinopse=" + sinopse
				+ ", siteOficial=" + siteOficial + "]";
	}

	

}
