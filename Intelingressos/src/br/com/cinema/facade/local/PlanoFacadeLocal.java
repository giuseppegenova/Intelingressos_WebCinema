package br.com.cinema.facade.local;

import java.util.List;

import javax.ejb.Local;

import br.com.cinema.entity.Plano;

@Local
public interface PlanoFacadeLocal {

abstract void save(Plano plano);
	
	abstract Plano update(Plano plano);
	
	abstract void delete(Plano plano);
	
	abstract Plano find(Long entityID);
	
	abstract List<Plano> findAll();
	
}
