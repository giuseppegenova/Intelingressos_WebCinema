package br.com.cinema.facade;

import br.com.cinema.dao.IngressoCompraDAO;
import br.com.cinema.entity.IngressoCompra;
import br.com.cinema.facade.local.IngressoCompraFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class IngressoCompraFacade implements IngressoCompraFacadeLocal {

    @EJB
    private IngressoCompraDAO ingressoCompraDAO;

    @Override
    public void save(IngressoCompra ingressoCompra) {
        ingressoCompraDAO.save(ingressoCompra);
    }

    @Override
    public IngressoCompra update(IngressoCompra ingressoCompra) {
        return ingressoCompraDAO.update(ingressoCompra);
    }

    @Override
    public void delete(IngressoCompra ingressoCompra) {
        ingressoCompraDAO.delete(ingressoCompra);
    }

    @Override
    public IngressoCompra find(Long entityID) {
        return ingressoCompraDAO.find(entityID);
    }

    @Override
    public List<IngressoCompra> findAll() {
        return ingressoCompraDAO.findAll();
    }
}
