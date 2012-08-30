package br.com.cinema.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ingressoCompra")
public class IngressoCompra {

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
		return Integer.parseInt(id.toString());
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IngressoCompra){
			IngressoCompra ingressoCompra = (IngressoCompra) obj;
			return ingressoCompra.getId() == id;
		}
		return false;
	}

	@Override
	public String toString() {
		return ingresso.getProtocolo().toString();
	}

	
}
