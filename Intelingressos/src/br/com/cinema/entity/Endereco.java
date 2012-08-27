package br.com.cinema.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="endereco")
@NamedQuery(name="Endereco.findByLogradouro", query="select e from Endereco e where e.logradouro = :logradouro")
public class Endereco implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3563303293502325172L;
	
	public static final String FIND_BY_LOGRADOURO = "Endereco.findByLogradouro";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(nullable = false)
	private String logradouro;
	
	@Column
	private Integer numero;
	
	@Column
	private String complemento;	
	
	@Column
	private String cep;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="cidade_id", nullable = false, insertable = false, updatable = false)
	private Cidade cidade;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}	

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public int hashCode(){
		return Integer.parseInt(id.toString());
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Endereco){
			Endereco endereco = (Endereco)obj;
			return endereco.getId() == id;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return logradouro;
	}
}
