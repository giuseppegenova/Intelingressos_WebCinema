package br.com.cinema.facade.local;

import br.com.cinema.entity.Sala;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SalaFacadeLocal {

abstract void save(Sala sala);
	
	abstract Sala update(Sala sala);
	
	abstract void delete(Sala sala);
	
	abstract Sala find(Long entityID);
	
	abstract List<Sala> findAll();
	
}
