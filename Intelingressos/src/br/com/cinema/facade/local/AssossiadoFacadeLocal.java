package br.com.cinema.facade.local;

import java.util.List;

import javax.ejb.Local;

import br.com.cinema.entity.Assossiado;

@Local
public interface AssossiadoFacadeLocal {

abstract void save(Assossiado assossiado);
	
	abstract Assossiado update(Assossiado assossiado);
	
	abstract void delete(Assossiado assossiado);
	
	abstract Assossiado find(Long entityID);
	
	abstract List<Assossiado> findAll();
	
}
