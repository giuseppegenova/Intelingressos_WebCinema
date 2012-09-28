package br.com.cinema.facade;

import br.com.cinema.dao.IngressoTipoDAO;
import br.com.cinema.entity.IngressoTipo;
import br.com.cinema.facade.local.IngressoTipoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class IngressoTipoFacade implements IngressoTipoFacadeLocal {

    @EJB
    private IngressoTipoDAO ingressoTipoDAO;

    @Override
    public void save(IngressoTipo ingressoTipo) {
        ingressoTipoDAO.save(ingressoTipo);
    }

    @Override
    public IngressoTipo update(IngressoTipo ingressoTipo) {
        return ingressoTipoDAO.update(ingressoTipo);
    }

    @Override
    public void delete(IngressoTipo ingressoTipo) {
        ingressoTipoDAO.delete(ingressoTipo);
    }

    @Override
    public IngressoTipo find(Long entityID) {
        return ingressoTipoDAO.find(entityID);
    }

    @Override
    public List<IngressoTipo> findAll() {
        return ingressoTipoDAO.findAll();
    }
}
