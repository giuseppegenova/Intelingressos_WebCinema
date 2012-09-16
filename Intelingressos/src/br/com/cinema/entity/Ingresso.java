package br.com.cinema.entity;

import java.io.Serializable;
import java.util.Date;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingressoCompra_id", unique = true)
    private IngressoCompra ingressoCompra;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingressoTipo_id", unique = true)
    private Set<IngressoTipo> ingressoTipo;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "sessao_id", nullable = false, insertable = false, updatable = false, referencedColumnName = "id")
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

    public Set<IngressoTipo> getIngressoTipo() {
        return ingressoTipo;
    }

    public void setIngressoTipo(Set<IngressoTipo> ingressoTipo) {
        this.ingressoTipo = ingressoTipo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 19 * hash + (this.protocolo != null ? this.protocolo.hashCode() : 0);
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.valorTotal) ^ (Double.doubleToLongBits(this.valorTotal) >>> 32));
        hash = 19 * hash + (this.cartaoCredito != null ? this.cartaoCredito.hashCode() : 0);
        hash = 19 * hash + (this.validadeCartao != null ? this.validadeCartao.hashCode() : 0);
        hash = 19 * hash + (this.ingressoCompra != null ? this.ingressoCompra.hashCode() : 0);
        hash = 19 * hash + (this.ingressoTipo != null ? this.ingressoTipo.hashCode() : 0);
        hash = 19 * hash + (this.valido ? 1 : 0);
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
        if (this.protocolo != other.protocolo && (this.protocolo == null || !this.protocolo.equals(other.protocolo))) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorTotal) != Double.doubleToLongBits(other.valorTotal)) {
            return false;
        }
        if ((this.cartaoCredito == null) ? (other.cartaoCredito != null) : !this.cartaoCredito.equals(other.cartaoCredito)) {
            return false;
        }
        if (this.validadeCartao != other.validadeCartao && (this.validadeCartao == null || !this.validadeCartao.equals(other.validadeCartao))) {
            return false;
        }
        if (this.ingressoCompra != other.ingressoCompra && (this.ingressoCompra == null || !this.ingressoCompra.equals(other.ingressoCompra))) {
            return false;
        }
        if (this.ingressoTipo != other.ingressoTipo && (this.ingressoTipo == null || !this.ingressoTipo.equals(other.ingressoTipo))) {
            return false;
        }
        if (this.valido != other.valido) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ingresso{" + "id=" + id + ", protocolo=" + protocolo + ", valorTotal=" + valorTotal + ", cartaoCredito=" + cartaoCredito + ", validadeCartao=" + validadeCartao + ", ingressoCompra=" + ingressoCompra + ", ingressoTipo=" + ingressoTipo + ", valido=" + valido + '}';
    }
}
