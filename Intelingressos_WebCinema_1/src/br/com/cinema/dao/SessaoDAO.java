package br.com.cinema.dao;

import javax.ejb.Stateless;

import br.com.cinema.dao.persistence.PersistenceDAO;
import br.com.cinema.entity.Sessao;

@Stateless
public class SessaoDAO extends PersistenceDAO<Sessao>{

	public SessaoDAO() {
		super(Sessao.class);
	}

}
