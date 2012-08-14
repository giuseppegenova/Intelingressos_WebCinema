package br.com.cinema.dao;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import br.com.cinema.dao.persistence.PersistenceDAO;
import br.com.cinema.entity.Cliente;

@Stateless
public class ClienteDAO extends PersistenceDAO<Cliente>{
	
	public ClienteDAO() {
		super(Cliente.class);
	}
	
    public Cliente findClienteByNome(String nome){
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("nome", nome);		
		
		return super.findOneResult(Cliente.FIND_BY_NOME, parameters);
	}
 
  
}
