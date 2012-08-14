package br.com.cinema.dao;

import javax.ejb.Stateless;

import br.com.cinema.dao.persistence.PersistenceDAO;
import br.com.cinema.entity.Plano;

@Stateless
public class PlanoDAO extends PersistenceDAO<Plano>{

	public PlanoDAO() {
		super(Plano.class);
	}

}
