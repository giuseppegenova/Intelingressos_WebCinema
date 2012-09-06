package br.com.cinema.facade;

import br.com.cinema.dao.TaxaDAO;
import br.com.cinema.entity.Taxa;
import br.com.cinema.facade.local.TaxaFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class TaxaFacade implements TaxaFacadeLocal{

	@EJB
	private TaxaDAO taxaDAO;
	
	@Override
	public void save(Taxa taxa) {
		taxaDAO.save(taxa);		
	}

	@Override
	public Taxa update(Taxa taxa) {
		return taxaDAO.update(taxa);		 
	}

	@Override
	public void delete(Taxa taxa) {
		taxaDAO.delete(taxa);		
	}

	@Override
	public Taxa find(Long entityID) {		
		return taxaDAO.find(entityID);
	}

	@Override
	public List<Taxa> findAll() {		
		return taxaDAO.findAll();
	}
	
	

}
