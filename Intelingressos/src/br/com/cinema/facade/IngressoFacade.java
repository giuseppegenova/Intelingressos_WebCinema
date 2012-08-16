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
	private IngressoDAO ingressoDAO;
	
	@Override
	public void save(Ingresso ingresso) {
		ingressoDAO.save(ingresso);		
	}

	@Override
	public Ingresso update(Ingresso ingresso) {
		return ingressoDAO.update(ingresso);		 
	}

	@Override
	public void delete(Ingresso ingresso) {
		ingressoDAO.delete(ingresso);		
	}

	@Override
	public Ingresso find(Long entityID) {		
		return ingressoDAO.find(entityID);
	}

	@Override
	public List<Ingresso> findAll() {		
		return ingressoDAO.findAll();
	}
	
	

}
