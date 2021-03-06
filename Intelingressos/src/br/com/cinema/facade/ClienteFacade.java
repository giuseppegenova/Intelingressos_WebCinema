package br.com.cinema.facade;

import br.com.cinema.dao.ClienteDAO;
import br.com.cinema.entity.Cliente;
import br.com.cinema.facade.local.ClienteFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ClienteFacade implements ClienteFacadeLocal{

	@EJB
	private ClienteDAO clienteDAO;
	
		
	@Override
	public void save(Cliente Cliente) {
		clienteDAO.save(Cliente);		
	}

	@Override
	public Cliente update(Cliente Cliente) {
		return clienteDAO.update(Cliente);		 
	}

	@Override
	public void delete(Cliente Cliente) {			
		clienteDAO.delete(Cliente);			
	}

	@Override
	public Cliente find(Long entityID) {		
		return clienteDAO.find(entityID);
	}

	@Override
	public List<Cliente> findAll() {		
		return clienteDAO.findAll();
	}

	@Override
	public Cliente findByNome(String nome) {
		return clienteDAO.findClienteByNome(nome);
	}
	
}
