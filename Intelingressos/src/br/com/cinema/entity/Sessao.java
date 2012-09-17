package br.com.cinema.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "sessao")
public class Sessao implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy="sessao")
    private Set<SessaoData> sessaoData; 
    
    private int ingressosVendidos;
    
    private int ingressosDisponiveis;
    
    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ingresso> ingresso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<SessaoData> getSessaoData() {
        return sessaoData;
    }

    public void setSessaoData(Set<SessaoData> sessaoData) {
        this.sessaoData = sessaoData;
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
