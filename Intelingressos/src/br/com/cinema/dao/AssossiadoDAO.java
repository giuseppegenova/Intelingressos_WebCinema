package br.com.cinema.dao;

import javax.ejb.Stateless;

import br.com.cinema.dao.persistence.PersistenceDAO;
import br.com.cinema.entity.Assossiado;

@Stateless
public class AssossiadoDAO extends PersistenceDAO<Assossiado>{

	public AssossiadoDAO() {
		super(Assossiado.class);
	}

}
