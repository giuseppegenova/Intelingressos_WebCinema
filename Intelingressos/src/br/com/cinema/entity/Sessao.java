package br.com.cinema.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "sessao")
public class Sessao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    private List<Date> sessaoData;
    
    @Temporal(TemporalType.TIME)
    private List<Date> sessaoPrimeiraHora;
    
    private int ingressosVendidos;
    
    private int ingressosDisponiveis;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "filme_id", nullable = false, insertable = false, updatable = false, referencedColumnName = "id")
    private Filme filme;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "sessao")
    private List<Ingresso> ingresso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Date> getSessaoData() {
        return sessaoData;
    }

    public void setSessaoData(List<Date> sessaoData) {
        this.sessaoData = sessaoData;
    }

    public List<Date> getSessaoPrimeiraHora() {
        return sessaoPrimeiraHora;
    }

    public void setSessaoPrimeiraHora(List<Date> sessaoPrimeiraHora) {
        this.sessaoPrimeiraHora = sessaoPrimeiraHora;
    }
    
    public int getIngressosVendidos() {
        return ingressosVendidos;
    }

    public void setIngressosVendidos(int ingressosVendidos) {
        this.ingressosVendidos = ingressosVendidos;
    }

    public int getIngressosDisponiveis() {
        return ingressosDisponiveis;
    }

    public void setIngressosDisponiveis(int ingressosDisponiveis) {
        this.ingressosDisponiveis = ingressosDisponiveis;
    }

    public List<Ingresso> getIngresso() {
        return ingresso;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public void setIngresso(List<Ingresso> ingresso) {
        this.ingresso = ingresso;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(id.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Sessao) {
            Sessao sessao = (Sessao) obj;
            return sessao.getId() == id;
        }
        return false;
    }

    @Override
    public String toString() {
        return sessaoData.toString();
    }
}
