package br.com.cinema.facade.local;

import br.com.cinema.entity.Filme;
import java.util.List;
import javax.ejb.Local;

@Local
public interface FilmeFacadeLocal {

abstract void save(Filme filme);
	
	abstract Filme update(Filme filme);
	
	abstract void delete(Filme filme);
	
	abstract Filme find(Long entityID);
	
	abstract List<Filme> findAll();
	
	Filme findFilmeByNome(String nome);
}
