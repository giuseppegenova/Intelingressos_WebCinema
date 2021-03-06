package br.com.cinema.facade.local;

import br.com.cinema.entity.Cinema;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CinemaFacadeLocal {

abstract void save(Cinema cinema);
	
	abstract Cinema update(Cinema cinema);
	
	abstract void delete(Cinema cinema);
	
	abstract Cinema find(Long entityID);
	
	abstract List<Cinema> findAll();
	
}
