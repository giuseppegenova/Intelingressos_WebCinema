package br.com.cinema.facade.local;

import br.com.cinema.entity.IngressoTipo;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IngressoTipoFacadeLocal {

    abstract void save(IngressoTipo ingressoTipo);

    abstract IngressoTipo update(IngressoTipo ingressoTipo);

    abstract void delete(IngressoTipo ingressoTipo);

    abstract IngressoTipo find(Long entityID);

    abstract List<IngressoTipo> findAll();
}
