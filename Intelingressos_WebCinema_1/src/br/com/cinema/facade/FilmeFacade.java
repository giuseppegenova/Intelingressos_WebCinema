package br.com.cinema.facade;

import br.com.cinema.dao.FilmeDAO;
import br.com.cinema.entity.Filme;
import br.com.cinema.facade.local.FilmeFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class FilmeFacade implements FilmeFacadeLocal{

	@EJB
	private FilmeDAO filmeDAO;
	
	@Override
	public void save(Filme filme) {
		filmeDAO.save(filme);		
	}

	@Override
	public Filme update(Filme filme) {
		return filmeDAO.update(filme);		 
	}

	@Override
	public void delete(Filme filme) {
		filmeDAO.delete(filme);		
	}

	@Override
	public Filme find(Long entityID) {		
		return filmeDAO.find(entityID);
	}

	@Override
	public List<Filme> findAll() {		
		return filmeDAO.findAll();
	}

	@Override
	public Filme findFilmeByNome(String nome) {
		return filmeDAO.findFilmeByNome(nome);
	}
	
	

}
