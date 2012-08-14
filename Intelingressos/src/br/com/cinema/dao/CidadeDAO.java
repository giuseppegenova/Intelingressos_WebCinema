package br.com.cinema.dao;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import br.com.cinema.dao.persistence.PersistenceDAO;
import br.com.cinema.entity.Cidade;

@Stateless
public class CidadeDAO extends PersistenceDAO<Cidade>{

	public CidadeDAO() {
		super(Cidade.class);
	}

	 public Cidade findCidadeByNome(String nome){
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("nome", nome);		
			
			return super.findOneResult(Cidade.FIND_BY_NOME, parameters);
		}	 
	
}
