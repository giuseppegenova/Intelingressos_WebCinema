/*
 * Classe que acomoda as datas 
 * das sessões
 */
package br.com.cinema.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Luigi
 */
@Entity
public class SessaoData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dataSessao;
    @ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY)    
    private Sessao sessao;
    @OneToMany(cascade= CascadeType.ALL, fetch= FetchType.EAGER, orphanRemoval=true)
    private Set<SessaoHora> sessaoHora;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataSessao() {
        return dataSessao;
    }

    public Set<SessaoHora> getSessaoHora() {
        return sessaoHora;
    }

    public void setSessaoHora(Set<SessaoHora> sessaoHora) {
        this.sessaoHora = sessaoHora;
    }

    public void setDataSessao(Date dataSessao) {
        this.dataSessao = dataSessao;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SessaoData)) {
            return false;
        }
        SessaoData other = (SessaoData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(dataSessao);
    }
}
