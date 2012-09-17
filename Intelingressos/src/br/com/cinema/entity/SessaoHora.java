/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cinema.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Michelle
 */
@Entity
public class SessaoHora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaSessao;
    
    @ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
    private SessaoData sessaoData;

    public void setId(Long id) {
        this.id = id;
    }

    public Date getHoraSessao() {
        return horaSessao;
    }

    public void setHoraSessao(Date horaSessao) {
        this.horaSessao = horaSessao;
    }

    public SessaoData getSessaoDAta() {
        return sessaoData;
    }

    public void setSessaoDAta(SessaoData sessaoData) {
        this.sessaoData = sessaoData;
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
        if (!(object instanceof SessaoHora)) {
            return false;
        }
        SessaoHora other = (SessaoHora) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cinema.entity.SessaoHora[ id=" + id + " ]";
    }
    
}
