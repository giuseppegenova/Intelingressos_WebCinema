/*
 * Classe que acomoda os Horários 
 * relacionados a Data da Sessão
 */
package br.com.cinema.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author lgenova
 */
@Entity
public class SessaoHora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String horaSessao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHoraSessao() {
        return horaSessao;
    }

    public void setHoraSessao(String horaSessao) {
        this.horaSessao = horaSessao;
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
        return "br.com.cinema.entity.SessaoHorario[ id=" + id + " ]";
    }
    
}