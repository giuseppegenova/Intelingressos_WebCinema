package br.com.cinema.facade;

import br.com.cinema.dao.SessaoDataDAO;
import br.com.cinema.entity.SessaoData;
import br.com.cinema.facade.local.SessaoDataFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SessaoDataFacade implements SessaoDataFacadeLocal {

    @EJB
    private SessaoDataDAO sessaoDataDAO;

    @Override
    public void save(SessaoData sessaoData) {
        sessaoDataDAO.save(sessaoData);
    }

    @Override
    public SessaoData update(SessaoData sessaoData) {
        return sessaoDataDAO.update(sessaoData);
    }

    @Override
    public void delete(SessaoData sessaoData) {
        sessaoDataDAO.delete(sessaoData);
    }

    @Override
    public SessaoData find(Long entityID) {
        return sessaoDataDAO.find(entityID);
    }

    @Override
    public List<SessaoData> findAll() {
        return sessaoDataDAO.findAll();
    }
}
