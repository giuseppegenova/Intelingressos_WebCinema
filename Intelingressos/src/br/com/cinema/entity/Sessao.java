package br.com.cinema.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "sessao")
@NamedQuery(name="Sessao.findByFilme", query="select c from Sessao c where c.filme = :filme")
public class Sessao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static final String FIND_BY_FILME = "Sessao.findByFilme";	
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    private Date sessaoData;
      
    @Temporal(TemporalType.TIME)
    private Date primeiroHorario;
    
    @Temporal(TemporalType.TIME)
    private Date segundoHorario;
    
    @Temporal(TemporalType.TIME)
    private Date terceiroHorario;
    
    private int ingressosVendidos;
    
    private int ingressosDisponiveis;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "filme_id", referencedColumnName="id", insertable=true, nullable=false)
    private Filme filme;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "sessao")
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

    public Date getPrimeiroHorario() {
        return primeiroHorario;
    }

    public void setPrimeiroHorario(Date primeiroHorario) {
        this.primeiroHorario = primeiroHorario;
    }

    public Date getSegundoHorario() {
        return segundoHorario;
    }

    public void setSegundoHorario(Date segundoHorario) {
        this.segundoHorario = segundoHorario;
    }

    public Date getTerceiroHorario() {
        return terceiroHorario;
    }

    public void setTerceiroHorario(Date terceiroHorario) {
        this.terceiroHorario = terceiroHorario;
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
