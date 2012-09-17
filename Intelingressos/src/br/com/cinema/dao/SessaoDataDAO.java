package br.com.cinema.dao;

import br.com.cinema.dao.persistence.PersistenceDAO;
import br.com.cinema.entity.SessaoData;
import javax.ejb.Stateless;

@Stateless
public class SessaoDataDAO extends PersistenceDAO<SessaoData>{

	public SessaoDataDAO() {
		super(SessaoData.class);
	}

}
