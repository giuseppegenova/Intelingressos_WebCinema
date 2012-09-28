package br.com.cinema.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "programacao")
public class Programacao implements Serializable {

    private static final long serialVersionUID = -3762809651277128585L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date inicio;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fim;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "filme_id", unique = true, updatable = true, insertable = true)
    private Filme filme;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "sessao_id", unique = true, updatable = true, insertable = true)
    private Sessao sessao;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "sala_id", unique = true, updatable = true, insertable = true)
    private Sala sala;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
    @Override
    public int hashCode() {
        return Integer.parseInt(id.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Programacao) {
            Programacao programacao = (Programacao) obj;
            return programacao.getId() == id;
        }
        return false;
    }

    @Override
    public String toString() {
        return filme.getNome();
    }
}