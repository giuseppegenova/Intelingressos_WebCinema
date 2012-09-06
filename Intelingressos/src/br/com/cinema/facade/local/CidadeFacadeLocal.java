package br.com.cinema.facade.local;

import br.com.cinema.entity.Cidade;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CidadeFacadeLocal {

abstract void save(Cidade cidade);
	
	abstract Cidade update(Cidade cidade);
	
	abstract void delete(Cidade cidade);
	
	abstract Cidade find(Long entityID);
	
	abstract List<Cidade> findAll();	
	
	abstract Cidade findCidadeByNome(String nome);
}
