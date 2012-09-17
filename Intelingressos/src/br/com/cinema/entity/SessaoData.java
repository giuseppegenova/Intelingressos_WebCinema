/*
 * Classe que acomoda as datas 
 * das sessões
 */
package br.com.cinema.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
    @ManyToOne
    private Sessao sessao;
    @OneToMany(cascade= CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="sessaoHora_id")
    private List<SessaoHora> horaSessao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataSessao() {
        return dataSessao;
    }

    public List<SessaoHora> getHoraSessao() {
        return horaSessao;
    }

    public void setHoraSessao(List<SessaoHora> horaSessao) {
        this.horaSessao = horaSessao;
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
        return "br.com.cinema.entity.SessaoData[ id=" + id + " ]";
    }
}
