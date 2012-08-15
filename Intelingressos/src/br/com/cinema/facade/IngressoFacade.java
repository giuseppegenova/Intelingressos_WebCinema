package br.com.cinema.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.cinema.dao.IngressoDAO;
import br.com.cinema.entity.Ingresso;
import br.com.cinema.facade.local.IngressoFacadeLocal;

@Stateless
public class IngressoFacade implements IngressoFacadeLocal{

	@EJB
	private IngressoDAO filmeDAO;
	
	@Override
	public void save(Ingresso filme) {
		filmeDAO.save(filme);		
	}

	@Override
	public Ingresso update(Ingresso filme) {
		return filmeDAO.update(filme);		 
	}

	@Override
	public void delete(Ingresso filme) {
		filmeDAO.delete(filme);		
	}

	@Override
	public Ingresso find(Long entityID) {		
		return filmeDAO.find(entityID);
	}

	@Override
	public List<Ingresso> findAll() {		
		return filmeDAO.findAll();
	}
	
	

}
