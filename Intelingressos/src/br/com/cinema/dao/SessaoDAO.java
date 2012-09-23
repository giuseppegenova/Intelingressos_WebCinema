package br.com.cinema.dao;

import javax.ejb.Stateless;

import br.com.cinema.dao.persistence.PersistenceDAO;
import br.com.cinema.entity.Cliente;
import br.com.cinema.entity.Sessao;
import java.util.HashMap;
import java.util.Map;

@Stateless
public class SessaoDAO extends PersistenceDAO<Sessao>{

	public SessaoDAO() {
		super(Sessao.class);
	}

        public Sessao findSessaoByFilme(String filme){
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("filme", filme);		
		
		return super.findOneResult(Sessao.FIND_BY_FILME, parameters);
	}
 
}
