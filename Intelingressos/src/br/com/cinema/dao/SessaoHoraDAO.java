package br.com.cinema.dao;

import br.com.cinema.dao.persistence.PersistenceDAO;
import br.com.cinema.entity.SessaoHora;
import javax.ejb.Stateless;

@Stateless
public class SessaoHoraDAO extends PersistenceDAO<SessaoHora>{

	public SessaoHoraDAO() {
		super(SessaoHora.class);
	}

}
