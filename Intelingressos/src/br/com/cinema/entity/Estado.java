package br.com.cinema.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
@NamedQuery(name="Estado.findByNome", query="select e from Estado e where e.nome = :nome")
public class Estado implements Serializable{

	private static final long serialVersionUID = 6690237651440887930L;
	
	public static final String FIND_BY_NOME = "Estado.findByNome";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String nome;
	
	@Column(nullable = false, unique = true, length = 2)
	private String sigla;
	
	@OneToMany(mappedBy="estado", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)  
	private Collection<Cidade> cidades;

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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	
	public Collection<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(Collection<Cidade> cidades) {
		this.cidades = cidades;
	}

	@Override
	public int hashCode(){
		return Integer.parseInt(id.toString());
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Estado){
			Estado estado = (Estado)obj;
			return estado.getId() == id;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return nome;
	}
}
