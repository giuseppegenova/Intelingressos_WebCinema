package br.com.cinema.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.cinema.dao.ProgramacaoDAO;
import br.com.cinema.entity.Programacao;
import br.com.cinema.facade.local.ProgramacaoFacadeLocal;

@Stateless
public class ProgramacaoFacade implements ProgramacaoFacadeLocal{

	@EJB
	private ProgramacaoDAO programacaoDAO;
	
	@Override
	public void save(Programacao programacao) {
		programacaoDAO.save(programacao);		
	}

	@Override
	public Programacao update(Programacao programacao) {
		return programacaoDAO.update(programacao);		 
	}

	@Override
	public void delete(Programacao programacao) {
		programacaoDAO.delete(programacao);		
	}

	@Override
	public Programacao find(Long entityID) {		
		return programacaoDAO.find(entityID);
	}

	@Override
	public List<Programacao> findAll() {		
		return programacaoDAO.findAll();
	}
	
	

}
