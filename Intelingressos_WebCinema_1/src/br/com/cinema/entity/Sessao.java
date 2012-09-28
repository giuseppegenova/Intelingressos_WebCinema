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
    private Date sessaoData;
    @Temporal(TemporalType.DATE)
    private Date sessaoData2;
    @Temporal(TemporalType.TIME)
    private Date sessaoPrimeiraHora;
    @Temporal(TemporalType.TIME)
    private Date sessaoSegundaHora;
    @Temporal(TemporalType.TIME)
    private Date sessaoTerceiraHora;
    private int ingressosVendidos;
    private int ingressosDisponiveis;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "sessao")
    private Programacao programacao;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sessao", orphanRemoval = true)
    private List<Ingresso> ingresso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSessaoData() {
        return sessaoData;
    }

    public void setSessaoData(Date sessaoData) {
        this.sessaoData = sessaoData;
    }

    public Date getSessaoData2() {
        return sessaoData2;
    }

    public void setSessaoData2(Date sessaoData2) {
        this.sessaoData2 = sessaoData2;
    }

    public Date getSessaoPrimeiraHora() {
        return sessaoPrimeiraHora;
    }

    public void setSessaoPrimeiraHora(Date sessaoPrimeiraHora) {
        this.sessaoPrimeiraHora = sessaoPrimeiraHora;
    }

    public Date getSessaoSegundaHora() {
        return sessaoSegundaHora;
    }

    public void setSessaoSegundaHora(Date sessaoSegundaHora) {
        this.sessaoSegundaHora = sessaoSegundaHora;
    }

    public Date getSessaoTerceiraHora() {
        return sessaoTerceiraHora;
    }

    public void setSessaoTerceiraHora(Date sessaoTerceiraHora) {
        this.sessaoTerceiraHora = sessaoTerceiraHora;
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

    public Programacao getProgramacao() {
        return programacao;
    }

    public void setProgramacao(Programacao programacao) {
        this.programacao = programacao;
    }

    public List<Ingresso> getIngresso() {
        return ingresso;
    }

    public void setIngresso(List<Ingresso> ingresso) {
        this.ingresso = ingresso;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Sessao other = (Sessao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(sessaoData);
    }
}