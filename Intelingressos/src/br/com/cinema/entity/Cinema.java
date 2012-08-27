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
@Table(name = "cinema")
public class Cinema implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1737339586735255940L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String nome;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "programacao_id", unique = true)
	private Collection<Programacao> programacao;

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

	public Collection<Programacao> getProgramacao() {
		return programacao;
	}

	public void setProgramacao(Collection<Programacao> programacao) {
		this.programacao = programacao;
	}

	@Override
	public int hashCode(){
		return Integer.parseInt(id.toString());
	}
	
	@Override
	public  boolean equals(Object obj){
		if(obj instanceof Cinema){
			Cinema cinema = (Cinema) obj;
			return cinema.getId()== id;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return nome;
	}
}
