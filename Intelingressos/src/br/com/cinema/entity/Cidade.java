package br.com.cinema.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
@NamedQuery(name="Cidade.findByNome", query="select c from Cidade c where c.estado = :estado")
public class Cidade implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2798405066468726147L;
	
	public static final String FIND_BY_NOME = "Cidade.findByNome";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="estado_id", nullable = false, insertable = false, updatable = false, referencedColumnName="id")
	private Estado estado;
	
	@OneToMany(mappedBy="cidade", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)  
	private List<Endereco> endereco;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 53 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 53 * hash + (this.estado != null ? this.estado.hashCode() : 0);
        hash = 53 * hash + (this.endereco != null ? this.endereco.hashCode() : 0);
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
        final Cidade other = (Cidade) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if (this.estado != other.estado && (this.estado == null || !this.estado.equals(other.estado))) {
            return false;
        }
        if (this.endereco != other.endereco && (this.endereco == null || !this.endereco.equals(other.endereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

	
}
