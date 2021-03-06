package br.com.cinema.facade.local;

import br.com.cinema.entity.Taxa;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TaxaFacadeLocal {

abstract void save(Taxa taxa);
	
	abstract Taxa update(Taxa taxa);
	
	abstract void delete(Taxa taxa);
	
	abstract Taxa find(Long entityID);
	
	abstract List<Taxa> findAll();
	
}
