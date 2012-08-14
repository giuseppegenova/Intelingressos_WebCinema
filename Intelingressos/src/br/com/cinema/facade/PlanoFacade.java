package br.com.cinema.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.cinema.dao.PlanoDAO;
import br.com.cinema.entity.Plano;
import br.com.cinema.facade.local.PlanoFacadeLocal;

@Stateless
public class PlanoFacade implements PlanoFacadeLocal{

	@EJB
	private PlanoDAO planoDAO;
	
	@Override
	public void save(Plano plano) {
		planoDAO.save(plano);		
	}

	@Override
	public Plano update(Plano plano) {
		return planoDAO.update(plano);		 
	}

	@Override
	public void delete(Plano plano) {
		planoDAO.delete(plano);		
	}

	@Override
	public Plano find(Long entityID) {		
		return planoDAO.find(entityID);
	}

	@Override
	public List<Plano> findAll() {		
		return planoDAO.findAll();
	}
	
	

}
