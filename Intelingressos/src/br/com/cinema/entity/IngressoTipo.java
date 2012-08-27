package br.com.cinema.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ingressoTipo")
public class IngressoTipo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -883509251960370255L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String nome;
	
	@Column(unique = true, nullable = false)
	private String preco;
	
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

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {		
		this.preco = preco;
	}	

	@Override
	public int hashCode(){
		return Integer.parseInt(id.toString());
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof IngressoTipo){
			IngressoTipo ingressoTipo = (IngressoTipo)obj;
			return ingressoTipo.getId() == id;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return nome;
	}
}
