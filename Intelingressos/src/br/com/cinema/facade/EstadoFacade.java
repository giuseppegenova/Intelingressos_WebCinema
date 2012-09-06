package br.com.cinema.facade;

import br.com.cinema.dao.EstadoDAO;
import br.com.cinema.entity.Estado;
import br.com.cinema.facade.local.EstadoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class EstadoFacade implements EstadoFacadeLocal{

	@EJB
	private EstadoDAO estadoDAO;
	
	@Override
	public void save(Estado estado) {
		estadoDAO.save(estado);		
	}

	@Override
	public Estado update(Estado estado) {
		return estadoDAO.update(estado);		 
	}

	@Override
	public void delete(Estado estado) {
		estadoDAO.delete(estado);		
	}

	@Override
	public Estado find(Long entityID) {		
		return estadoDAO.find(entityID);
	}

	@Override
	public List<Estado> findAll() {		
		return estadoDAO.findAll();
	}
	
        @Override
	public Estado findEstadoByNome(String nome){
		return estadoDAO.findEstadoByNome(nome);
	}

}
