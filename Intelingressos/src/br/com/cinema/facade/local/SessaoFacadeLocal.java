package br.com.cinema.facade.local;

import java.util.List;

import javax.ejb.Local;

import br.com.cinema.entity.Sessao;

@Local
public interface SessaoFacadeLocal {

abstract void save(Sessao sessao);
	
	abstract Sessao update(Sessao sessao);
	
	abstract void delete(Sessao sessao);
	
	abstract Sessao find(Long entityID);
	
	abstract List<Sessao> findAll();
        
        Sessao findSessaoByFilme(String filme);
	
}
