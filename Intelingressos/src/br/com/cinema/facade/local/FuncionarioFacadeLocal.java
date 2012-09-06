package br.com.cinema.facade.local;

import br.com.cinema.entity.Funcionario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface FuncionarioFacadeLocal {

abstract void save(Funcionario funcionario);
	
	abstract Funcionario update(Funcionario funcionario);
	
	abstract void delete(Funcionario funcionario);
	
	abstract Funcionario find(Long entityID);
	
	abstract List<Funcionario> findAll();
	
}
