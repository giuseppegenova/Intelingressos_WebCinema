package br.com.cinema.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.cinema.dao.AssossiadoDAO;
import br.com.cinema.entity.Assossiado;
import br.com.cinema.facade.local.AssossiadoFacadeLocal;

@Stateless
public class AssossiadoFacade implements AssossiadoFacadeLocal{

	@EJB
	private AssossiadoDAO assossiadoDAO;
	
	@Override
	public void save(Assossiado assossiado) {
		assossiadoDAO.save(assossiado);		
	}

	@Override
	public Assossiado update(Assossiado assossiado) {
		return assossiadoDAO.update(assossiado);		 
	}

	@Override
	public void delete(Assossiado assossiado) {
		assossiadoDAO.delete(assossiado);		
	}

	@Override
	public Assossiado find(Long entityID) {		
		return assossiadoDAO.find(entityID);
	}

	@Override
	public List<Assossiado> findAll() {		
		return assossiadoDAO.findAll();
	}
	
	

}
