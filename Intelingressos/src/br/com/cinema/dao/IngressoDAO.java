package br.com.cinema.dao;

import javax.ejb.Stateless;

import br.com.cinema.dao.persistence.PersistenceDAO;
import br.com.cinema.entity.Ingresso;

@Stateless
public class IngressoDAO extends PersistenceDAO<Ingresso>{

	public IngressoDAO() {
		super(Ingresso.class);
	}

}
