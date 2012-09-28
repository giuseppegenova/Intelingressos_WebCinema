package br.com.cinema.dao;

import javax.ejb.Stateless;

import br.com.cinema.dao.persistence.PersistenceDAO;
import br.com.cinema.entity.Programacao;

@Stateless
public class ProgramacaoDAO extends PersistenceDAO<Programacao>{

	public ProgramacaoDAO() {
		super(Programacao.class);
	}

}
