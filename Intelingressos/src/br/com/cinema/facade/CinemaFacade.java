package br.com.cinema.facade;

import br.com.cinema.dao.CinemaDAO;
import br.com.cinema.entity.Cinema;
import br.com.cinema.facade.local.CinemaFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CinemaFacade implements CinemaFacadeLocal{

	@EJB
	private CinemaDAO cinemaDAO;
	
	@Override
	public void save(Cinema cinema) {
		cinemaDAO.save(cinema);		
	}

	@Override
	public Cinema update(Cinema cinema) {
		return cinemaDAO.update(cinema);		 
	}

	@Override
	public void delete(Cinema cinema) {
		cinemaDAO.delete(cinema);		
	}

	@Override
	public Cinema find(Long entityID) {		
		return cinemaDAO.find(entityID);
	}

	@Override
	public List<Cinema> findAll() {		
		return cinemaDAO.findAll();
	}
	
	

}
