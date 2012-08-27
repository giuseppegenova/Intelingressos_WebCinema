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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
@NamedQuery(name="Cidade.findByNome", query="select c from Cidade c where c.nome = :nome")
public class Cidade implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2798405066468726147L;
	
	public static final String FIND_BY_NOME = "Cidade.findByNome";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="estado_id", nullable = false, insertable = false, updatable = false)
	private Estado estado;
	
	@OneToMany(mappedBy="cidade", orphanRemoval = true, cascade = CascadeType.ALL)  
	private Collection<Endereco> endereco;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(Collection<Endereco> endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		return Integer.parseInt(id.toString());
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Cidade){
			Cidade cidade = (Cidade) obj;
			return cidade.getId() == id;
		}
		return false;
	}

	@Override
	public String toString() {
		return nome;
	}

	
	
}
