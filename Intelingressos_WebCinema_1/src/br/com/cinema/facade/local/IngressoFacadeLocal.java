package br.com.cinema.facade.local;

import java.util.List;

import javax.ejb.Local;

import br.com.cinema.entity.Ingresso;

@Local
public interface IngressoFacadeLocal {

abstract void save(Ingresso ingresso);
	
	abstract Ingresso update(Ingresso ingresso);
	
	abstract void delete(Ingresso ingresso);
	
	abstract Ingresso find(Long entityID);
	
	abstract List<Ingresso> findAll(); 
        
}
