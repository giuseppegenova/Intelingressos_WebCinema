package br.com.cinema.dao;

import br.com.cinema.dao.persistence.PersistenceDAO;
import br.com.cinema.entity.Ingresso;
import javax.ejb.Stateless;

@Stateless
public class IngressoDAO extends PersistenceDAO<Ingresso> {

    public IngressoDAO() {
        super(Ingresso.class);
    }
}
