package br.com.cinema.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Usuario implements Serializable{

	public Funcionario(String nome, String email, String telefone,
			String celular, String senha) {
		super(nome, email, telefone, celular, senha);		
	}
	
	public Funcionario(){}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4025231778594725316L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String cargo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cinema_id", unique = true)
	private Collection<Cinema> cinema;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Collection<Cinema> getCinema() {
		return cinema;
	}

	public void setCinema(Collection<Cinema> cinema) {
		this.cinema = cinema;
	}

	@Override
	public int hashCode() {
		return Integer.parseInt(id.toString());
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Funcionario){
			Funcionario funcionario = (Funcionario)obj;
			return funcionario.getId() == id;			
		}
		return false;
	}
		
	@Override
	public String toString(){
		return super.getNome();
	}
}
