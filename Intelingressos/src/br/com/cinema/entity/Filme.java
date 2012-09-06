package br.com.cinema.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "filme")
@NamedQuery(name="Filme.findByNome", query="select f from Filme f where f.nome = :nome")
public class Filme implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1808765237432372920L;
	
	public static final String FIND_FILME_BY_NOME = "Filme.findByNome";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;		
	
	@Column(nullable = false, unique = true, updatable = true)
	private String nome;
	
	@Column(nullable = false)
	private String sinopse;
	
	@Column
	private String siteOficial;

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

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getSiteOficial() {
		return siteOficial;
	}

	public void setSiteOficial(String siteOficial) {
		this.siteOficial = siteOficial;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 97 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 97 * hash + (this.sinopse != null ? this.sinopse.hashCode() : 0);
        hash = 97 * hash + (this.siteOficial != null ? this.siteOficial.hashCode() : 0);
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
        final Filme other = (Filme) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.sinopse == null) ? (other.sinopse != null) : !this.sinopse.equals(other.sinopse)) {
            return false;
        }
        if ((this.siteOficial == null) ? (other.siteOficial != null) : !this.siteOficial.equals(other.siteOficial)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Filme{" + "id=" + id + ", nome=" + nome + ", sinopse=" + sinopse + ", siteOficial=" + siteOficial + '}';
    }

        
	
}
