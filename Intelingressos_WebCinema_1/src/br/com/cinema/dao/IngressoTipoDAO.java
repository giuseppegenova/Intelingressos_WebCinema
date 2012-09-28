package br.com.cinema.dao;

import br.com.cinema.dao.persistence.PersistenceDAO;
import br.com.cinema.entity.IngressoTipo;
import javax.ejb.Stateless;

@Stateless
public class IngressoTipoDAO extends PersistenceDAO<IngressoTipo> {

    public IngressoTipoDAO() {
        super(IngressoTipo.class);
    }
}
