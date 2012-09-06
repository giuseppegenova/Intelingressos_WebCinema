package br.com.cinema.facade.local;

import br.com.cinema.entity.Estado;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EstadoFacadeLocal {

abstract void save(Estado estado);
	
	abstract Estado update(Estado estado);
	
	abstract void delete(Estado estado);
	
	abstract Estado find(Long entityID);
	
	abstract List<Estado> findAll();
	
	Estado findEstadoByNome(String nome);
}
