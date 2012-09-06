package br.com.cinema.facade.local;

import br.com.cinema.entity.Programacao;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ProgramacaoFacadeLocal {

abstract void save(Programacao programacao);
	
	abstract Programacao update(Programacao programacao);
	
	abstract void delete(Programacao programacao);
	
	abstract Programacao find(Long entityID);
	
	abstract List<Programacao> findAll();
	
}
