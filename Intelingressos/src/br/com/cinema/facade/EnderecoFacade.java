package br.com.cinema.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.cinema.dao.EnderecoDAO;
import br.com.cinema.entity.Endereco;
import br.com.cinema.facade.local.EnderecoFacadeLocal;

@Stateless
public class EnderecoFacade implements EnderecoFacadeLocal{

	@EJB
	private EnderecoDAO enderecoDAO;
	
	@Override
	public void save(Endereco Endereco) {
		enderecoDAO.save(Endereco);		
	}

	@Override
	public Endereco update(Endereco Endereco) {
		return enderecoDAO.update(Endereco);		 
	}

	@Override
	public void delete(Endereco Endereco) {
		enderecoDAO.delete(Endereco);		
	}

	@Override
	public Endereco find(Long entityID) {		
		return enderecoDAO.find(entityID);
	}

	@Override
	public List<Endereco> findAll() {		
		return enderecoDAO.findAll();
	}
	
	@Override
	public Endereco findByLogradouro(String logradouro) {
		return enderecoDAO.findEnderecoByLogradouro(logradouro);
	}

}
