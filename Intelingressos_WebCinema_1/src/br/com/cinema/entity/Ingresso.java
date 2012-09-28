package br.com.cinema.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "ingresso")
public class Ingresso implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7626515563012062095L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private Integer protocolo;
    
    @Column(nullable = false)
    private double valorTotal;
    
    @Column(nullable = false)
    private String cartaoCredito;
    
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date validadeCartao;
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "ingressoCompra_id", unique = true, updatable = true, insertable = true)
    private IngressoCompra ingressoCompra;  
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL) 
    @JoinColumn(name="sessao_id",nullable=false, unique=true, referencedColumnName="id")
    private Sessao sessao;
    
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

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
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

    public IngressoCompra getIngressoCompra() {
        return ingressoCompra;
    }

    public void setIngressoCompra(IngressoCompra ingressoCompra) {
        this.ingressoCompra = ingressoCompra;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Ingresso other = (Ingresso) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(protocolo);
    }

}
