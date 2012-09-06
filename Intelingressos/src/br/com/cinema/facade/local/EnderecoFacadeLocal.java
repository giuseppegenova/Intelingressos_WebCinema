package br.com.cinema.facade.local;

import br.com.cinema.entity.Endereco;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EnderecoFacadeLocal {

abstract void save(Endereco Endereco);
	
	abstract Endereco update(Endereco Endereco);
	
	abstract void delete(Endereco Endereco);
	
	abstract Endereco find(Long entityID);
	
	abstract List<Endereco> findAll();
	
	Endereco findByLogradouro(String logradouro);
}
