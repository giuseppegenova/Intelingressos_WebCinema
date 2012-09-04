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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
@NamedQuery(name="Cliente.findByNome", query="select c from Cliente c where c.nome = :nome")
public class Cliente extends Usuario implements Serializable{

	private static final long serialVersionUID = -8089433058728405137L;

	public static final String FIND_BY_NOME = "Cliente.findByNome";	
	
		
	public Cliente(String nome, String email, String telefone, String celular, String senha, String cpf) {
		super(nome, email, telefone, celular, senha);	
		this.cpf = cpf;
	}

	public Cliente() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String cpf;	
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id", unique = true)
	private Collection<IngressoCompra> ingressoCompra;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Collection<IngressoCompra> getIngressoComprado() {
		return ingressoCompra;
	}

	public void setIngressoComprado(Collection<IngressoCompra> ingressoCompra) {
		this.ingressoCompra = ingressoCompra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((ingressoCompra == null) ? 0 : ingressoCompra.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Cliente)) {
			return false;
		}
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null) {
				return false;
			}
		} else if (!cpf.equals(other.cpf)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (ingressoCompra == null) {
			if (other.ingressoCompra != null) {
				return false;
			}
		} else if (!ingressoCompra.equals(other.ingressoCompra)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cpf=" + cpf + ", ingressoCompra="
				+ ingressoCompra + "]";
	}

	
}
