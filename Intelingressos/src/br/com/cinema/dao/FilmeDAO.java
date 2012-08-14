package br.com.cinema.dao;

import javax.ejb.Stateless;

import br.com.cinema.dao.persistence.PersistenceDAO;
import br.com.cinema.entity.Filme;

@Stateless
public class FilmeDAO extends PersistenceDAO<Filme>{

	public FilmeDAO() {
		super(Filme.class);
	}

}
