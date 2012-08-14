package br.com.cinema.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.cinema.dao.CidadeDAO;
import br.com.cinema.entity.Cidade;
import br.com.cinema.facade.local.CidadeFacadeLocal;

@Stateless
public class CidadeFacade implements CidadeFacadeLocal{

	@EJB
	private CidadeDAO cidadeDAO;
	
	@Override
	public void save(Cidade cidade) {
		cidadeDAO.save(cidade);		
	}

	@Override
	public Cidade update(Cidade cidade) {
		return cidadeDAO.update(cidade);		 
	}

	@Override
	public void delete(Cidade cidade) {
		cidadeDAO.delete(cidade);		
	}

	@Override
	public Cidade find(Long entityID) {		
		return cidadeDAO.find(entityID);
	}

	@Override
	public List<Cidade> findAll() {		
		return cidadeDAO.findAll();
	}	
	
	public Cidade findCidadeByNome(String nome){
		return cidadeDAO.findCidadeByNome(nome);
	}

}
