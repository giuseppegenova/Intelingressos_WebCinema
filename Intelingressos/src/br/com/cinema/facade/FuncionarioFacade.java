package br.com.cinema.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.cinema.dao.FuncionarioDAO;
import br.com.cinema.entity.Funcionario;
import br.com.cinema.facade.local.FuncionarioFacadeLocal;

@Stateless
public class FuncionarioFacade implements FuncionarioFacadeLocal{

	@EJB
	private FuncionarioDAO funcionarioDAO;
	
	@Override
	public void save(Funcionario funcionario) {
		funcionarioDAO.save(funcionario);		
	}

	@Override
	public Funcionario update(Funcionario funcionario) {
		return funcionarioDAO.update(funcionario);		 
	}

	@Override
	public void delete(Funcionario funcionario) {
		funcionarioDAO.delete(funcionario);		
	}

	@Override
	public Funcionario find(Long entityID) {		
		return funcionarioDAO.find(entityID);
	}

	@Override
	public List<Funcionario> findAll() {		
		return funcionarioDAO.findAll();
	}
	
	

}
