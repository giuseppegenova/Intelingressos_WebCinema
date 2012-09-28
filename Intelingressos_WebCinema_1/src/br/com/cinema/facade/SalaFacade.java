package br.com.cinema.facade;

import br.com.cinema.dao.SalaDAO;
import br.com.cinema.entity.Sala;
import br.com.cinema.facade.local.SalaFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SalaFacade implements SalaFacadeLocal{

	@EJB
	private SalaDAO salaDAO;
	
	@Override
	public void save(Sala sala) {
		salaDAO.save(sala);		
	}

	@Override
	public Sala update(Sala sala) {
		return salaDAO.update(sala);		 
	}

	@Override
	public void delete(Sala sala) {
		salaDAO.delete(sala);		
	}

	@Override
	public Sala find(Long entityID) {		
		return salaDAO.find(entityID);
	}

	@Override
	public List<Sala> findAll() {		
		return salaDAO.findAll();
	}
	
	

}
