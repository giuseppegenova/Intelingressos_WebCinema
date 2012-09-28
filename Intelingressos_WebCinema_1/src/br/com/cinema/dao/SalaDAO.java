package br.com.cinema.dao;

import javax.ejb.Stateless;

import br.com.cinema.dao.persistence.PersistenceDAO;
import br.com.cinema.entity.Sala;

@Stateless
public class SalaDAO extends PersistenceDAO<Sala>{

	public SalaDAO() {
		super(Sala.class);
	}

}
