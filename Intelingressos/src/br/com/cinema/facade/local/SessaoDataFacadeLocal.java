package br.com.cinema.facade.local;

import br.com.cinema.entity.SessaoData;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SessaoDataFacadeLocal {

abstract void save(SessaoData sessaoData);
	
	abstract SessaoData update(SessaoData sessaoData);
	
	abstract void delete(SessaoData sessaoData);
	
	abstract SessaoData find(Long entityID);
	
	abstract List<SessaoData> findAll();
	
}
