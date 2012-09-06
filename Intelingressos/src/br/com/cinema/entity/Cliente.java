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

/**
 *
 * @author lgenova
 */
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
        int hash = 7;
        hash = 61 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 61 * hash + (this.cpf != null ? this.cpf.hashCode() : 0);
        hash = 61 * hash + (this.ingressoCompra != null ? this.ingressoCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.cpf == null) ? (other.cpf != null) : !this.cpf.equals(other.cpf)) {
            return false;
        }
        if (this.ingressoCompra != other.ingressoCompra && (this.ingressoCompra == null || !this.ingressoCompra.equals(other.ingressoCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", cpf=" + cpf + ", ingressoCompra=" + ingressoCompra + '}';
    }

	

	
}
