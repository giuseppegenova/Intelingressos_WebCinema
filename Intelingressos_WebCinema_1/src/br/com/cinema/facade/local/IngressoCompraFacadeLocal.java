package br.com.cinema.facade.local;

import br.com.cinema.entity.IngressoCompra;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IngressoCompraFacadeLocal {

    abstract void save(IngressoCompra ingressoCompra);

    abstract IngressoCompra update(IngressoCompra ingressoCompra);

    abstract void delete(IngressoCompra ingressoCompra);

    abstract IngressoCompra find(Long entityID);

    abstract List<IngressoCompra> findAll();
}
