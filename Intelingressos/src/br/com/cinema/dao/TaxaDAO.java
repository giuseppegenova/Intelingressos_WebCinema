package br.com.cinema.dao;

import javax.ejb.Stateless;

import br.com.cinema.dao.persistence.PersistenceDAO;
import br.com.cinema.entity.Taxa;

@Stateless
public class TaxaDAO extends PersistenceDAO<Taxa>{

	public TaxaDAO() {
		super(Taxa.class);
	}

}
