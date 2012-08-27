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
	private Integer protocolo;
	
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

	public Integer getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(Integer protocolo) {
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
	public int hashCode() {
		return Integer.parseInt(id.toString());
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Ingresso){
			Ingresso ingresso = (Ingresso)obj;
			return ingresso.getId() == id;			
		}
		return false;
	}
		
	@Override
	public String toString(){
		return protocolo.toString();
	}
}
