package br.com.cinema.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "taxa")
public class Taxa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8591405745435451645L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Double valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode(){
		return Integer.parseInt(id.toString());
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Taxa){
			Taxa taxa = (Taxa)obj;
			return taxa.getId() == id;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return valor.toString();
	}
	
}
