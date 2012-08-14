package br.com.cinema.dao;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import br.com.cinema.dao.persistence.PersistenceDAO;
import br.com.cinema.entity.Endereco;

@Stateless
public class EnderecoDAO extends PersistenceDAO<Endereco>{

	public EnderecoDAO() {
		super(Endereco.class);
	}

	public Endereco findEnderecoByLogradouro(String logradouro){
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("logradouro", logradouro);		
		
		return super.findOneResult(Endereco.FIND_BY_LOGRADOURO, parameters);
	}
}
