package br.com.cinema.dao;

import javax.ejb.Stateless;

import br.com.cinema.dao.persistence.PersistenceDAO;
import br.com.cinema.entity.Cinema;

@Stateless
public class CinemaDAO extends PersistenceDAO<Cinema>{

	public CinemaDAO() {
		super(Cinema.class);
	}

}
