package br.com.cinema.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author lgenova
 */
@Entity
@Table(name = "ingressoCompra")
public class IngressoCompra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7122171510047164732L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@Column(nullable = false)
	private Integer quantidade;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ingresso_id")
	private Ingresso ingresso;	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ingressoTipo_id", unique = true)
	private IngressoTipo ingressoTipo;

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ingresso getIngresso() {
		return ingresso;
	}

	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}

	public IngressoTipo getIngressoTipo() {
		return ingressoTipo;
	}

	public void setIngressoTipo(IngressoTipo ingressoTipo) {
		this.ingressoTipo = ingressoTipo;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 29 * hash + (this.quantidade != null ? this.quantidade.hashCode() : 0);
        hash = 29 * hash + (this.ingresso != null ? this.ingresso.hashCode() : 0);
        hash = 29 * hash + (this.ingressoTipo != null ? this.ingressoTipo.hashCode() : 0);
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
        final IngressoCompra other = (IngressoCompra) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.quantidade != other.quantidade && (this.quantidade == null || !this.quantidade.equals(other.quantidade))) {
            return false;
        }
        if (this.ingresso != other.ingresso && (this.ingresso == null || !this.ingresso.equals(other.ingresso))) {
            return false;
        }
        if (this.ingressoTipo != other.ingressoTipo && (this.ingressoTipo == null || !this.ingressoTipo.equals(other.ingressoTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "IngressoCompra{" + "id=" + id + ", quantidade=" + quantidade + ", ingresso=" + ingresso + ", ingressoTipo=" + ingressoTipo + '}';
    }


	
}
