package br.com.cinema.facade.local;

import br.com.cinema.entity.SessaoHora;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SessaoHoraFacadeLocal {

abstract void save(SessaoHora sessaoHora);
	
	abstract SessaoHora update(SessaoHora sessaoHora);
	
	abstract void delete(SessaoHora sessaoHora);
	
	abstract SessaoHora find(Long entityID);
	
	abstract List<SessaoHora> findAll();
	
}
