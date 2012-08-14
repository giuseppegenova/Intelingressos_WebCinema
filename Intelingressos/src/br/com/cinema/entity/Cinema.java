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
	public String toString() {
		return "Cinema [id=" + id + ", nome=" + nome + ", programacao="
				+ programacao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((programacao == null) ? 0 : programacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Cinema))
			return false;
		Cinema other = (Cinema) obj;
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
		if (programacao == null) {
			if (other.programacao != null)
				return false;
		} else if (!programacao.equals(other.programacao))
			return false;
		return true;
	}
	
	
}
