package br.com.cinema.facade.local;

import java.util.List;

import javax.ejb.Local;

import br.com.cinema.entity.Filme;

@Local
public interface FilmeFacadeLocal {

abstract void save(Filme filme);
	
	abstract Filme update(Filme filme);
	
	abstract void delete(Filme filme);
	
	abstract Filme find(Long entityID);
	
	abstract List<Filme> findAll();
	
}
