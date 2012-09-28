package br.com.cinema.dao;

import br.com.cinema.dao.persistence.PersistenceDAO;
import br.com.cinema.entity.IngressoCompra;
import javax.ejb.Stateless;

@Stateless
public class IngressoCompraDAO extends PersistenceDAO<IngressoCompra> {

    public IngressoCompraDAO() {
        super(IngressoCompra.class);
    }
}
