package br.com.cinema.dao;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import br.com.cinema.dao.persistence.PersistenceDAO;
import br.com.cinema.entity.Filme;

@Stateless
public class FilmeDAO extends PersistenceDAO<Filme>{

	public FilmeDAO() {
		super(Filme.class);
	}

	public Filme findFilmeByNome(String nome){
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("nome", nome);		
		
		return super.findOneResult(Filme.FIND_FILME_BY_NOME, parameters);
	}	 
}
