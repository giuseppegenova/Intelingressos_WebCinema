package br.com.cinema.dao;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import br.com.cinema.dao.persistence.PersistenceDAO;
import br.com.cinema.entity.Estado;

@Stateless
public class EstadoDAO extends PersistenceDAO<Estado>{

	public EstadoDAO() {
		super(Estado.class);
	}
	
	public Estado findEstadoByNome(String nome){
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("nome", nome);		
		
		return super.findOneResult(Estado.FIND_BY_NOME, parameters);
	}	 

}
