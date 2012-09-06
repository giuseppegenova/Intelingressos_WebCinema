package br.com.cinema.facade.local;

import br.com.cinema.entity.Cliente;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ClienteFacadeLocal {

abstract void save(Cliente Cliente);
	
	abstract Cliente update(Cliente Cliente);
	
	abstract void delete(Cliente Cliente);
	
	abstract Cliente find(Long entityID);
	
	abstract List<Cliente> findAll();
	
	Cliente findByNome(String nome);
	
}
