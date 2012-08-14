package br.com.cinema.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ingresso")
public class Ingresso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7626515563012062095L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private int protocolo;
	
	@Column(nullable = false)
	private double valorTotal;
	
	@Column(nullable = false)
	private String cartaoCredito;
	
	@Column(nullable = false)
	private Date validadeCartao;
		
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ingressoCompra_id", unique = true)
	private IngressoCompra ingressoCompra;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ingressoTipo_id", unique = true)
	private Set<IngressoTipo> ingressoTipo;
	
	private boolean valido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(int protocolo) {
		this.protocolo = protocolo;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(String cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

	public Date getValidadeCartao() {
		return validadeCartao;
	}

	public void setValidadeCartao(Date validadeCartao) {
		this.validadeCartao = validadeCartao;
	}

	public boolean isValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

	public IngressoCompra getIngressoComprado() {
		return ingressoCompra;
	}

	public void setIngressoComprado(IngressoCompra ingressoCompra) {
		this.ingressoCompra = ingressoCompra;
	}

	public Set<IngressoTipo> getIngressoTipo() {
		return ingressoTipo;
	}

	public void setIngressoTipo(Set<IngressoTipo> ingressoTipo) {
		this.ingressoTipo = ingressoTipo;
	}

	@Override
	public String toString() {
		return "Ingresso [id=" + id + ", protocolo=" + protocolo
				+ ", valorTotal=" + valorTotal + ", cartaoCredito="
				+ cartaoCredito + ", validadeCartao=" + validadeCartao
				+ ", ingressoCompra=" + ingressoCompra + ", ingressoTipo="
				+ ingressoTipo + ", valido=" + valido + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cartaoCredito == null) ? 0 : cartaoCredito.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((ingressoCompra == null) ? 0 : ingressoCompra.hashCode());
		result = prime * result
				+ ((ingressoTipo == null) ? 0 : ingressoTipo.hashCode());
		result = prime * result + protocolo;
		result = prime * result
				+ ((validadeCartao == null) ? 0 : validadeCartao.hashCode());
		result = prime * result + (valido ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(valorTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Ingresso))
			return false;
		Ingresso other = (Ingresso) obj;
		if (cartaoCredito == null) {
			if (other.cartaoCredito != null)
				return false;
		} else if (!cartaoCredito.equals(other.cartaoCredito))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ingressoCompra == null) {
			if (other.ingressoCompra != null)
				return false;
		} else if (!ingressoCompra.equals(other.ingressoCompra))
			return false;
		if (ingressoTipo == null) {
			if (other.ingressoTipo != null)
				return false;
		} else if (!ingressoTipo.equals(other.ingressoTipo))
			return false;
		if (protocolo != other.protocolo)
			return false;
		if (validadeCartao == null) {
			if (other.validadeCartao != null)
				return false;
		} else if (!validadeCartao.equals(other.validadeCartao))
			return false;
		if (valido != other.valido)
			return false;
		if (Double.doubleToLongBits(valorTotal) != Double
				.doubleToLongBits(other.valorTotal))
			return false;
		return true;
	}
}
