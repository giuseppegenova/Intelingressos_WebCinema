package br.com.cinema.dao;

import javax.ejb.Stateless;

import br.com.cinema.dao.persistence.PersistenceDAO;
import br.com.cinema.entity.Funcionario;

@Stateless
public class FuncionarioDAO extends PersistenceDAO<Funcionario>{

	public FuncionarioDAO() {
		super(Funcionario.class);
	}

}
