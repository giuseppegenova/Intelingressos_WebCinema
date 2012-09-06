package br.com.cinema.facade;

import br.com.cinema.dao.SessaoDAO;
import br.com.cinema.entity.Sessao;
import br.com.cinema.facade.local.SessaoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SessaoFacade implements SessaoFacadeLocal{

	@EJB
	private SessaoDAO sessaoDAO;
	
	@Override
	public void save(Sessao sessao) {
		sessaoDAO.save(sessao);		
	}

	@Override
	public Sessao update(Sessao sessao) {
		return sessaoDAO.update(sessao);		 
	}

	@Override
	public void delete(Sessao sessao) {
		sessaoDAO.delete(sessao);		
	}

	@Override
	public Sessao find(Long entityID) {		
		return sessaoDAO.find(entityID);
	}

	@Override
	public List<Sessao> findAll() {		
		return sessaoDAO.findAll();
	}
	
	

}
