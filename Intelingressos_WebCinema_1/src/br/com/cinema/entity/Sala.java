package br.com.cinema.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sala")
public class Sala implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5371113886677716173L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nome;
    @Column(nullable = false)
    private int capacidade;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, mappedBy="sala")
    private Programacao programacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Programacao getProgramacao() {
        return programacao;
    }

    public void setProgramacao(Programacao programacao) {
        this.programacao = programacao;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(id.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Sala) {
            Sala sala = (Sala) obj;
            return sala.getId() == id;
        }
        return false;
    }

    @Override
    public String toString() {
        return nome;
    }
}
