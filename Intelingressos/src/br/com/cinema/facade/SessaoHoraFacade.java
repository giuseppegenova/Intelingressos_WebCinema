package br.com.cinema.facade;

import br.com.cinema.dao.SessaoHoraDAO;
import br.com.cinema.entity.SessaoHora;
import br.com.cinema.facade.local.SessaoHoraFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SessaoHoraFacade implements SessaoHoraFacadeLocal {

    @EJB
    private SessaoHoraDAO sessaoHoraDAO;

    @Override
    public void save(SessaoHora sessaoHora) {
        sessaoHoraDAO.save(sessaoHora);
    }

    @Override
    public SessaoHora update(SessaoHora sessaoHora) {
        return sessaoHoraDAO.update(sessaoHora);
    }

    @Override
    public void delete(SessaoHora sessaoHora) {
        sessaoHoraDAO.delete(sessaoHora);
    }

    @Override
    public SessaoHora find(Long entityID) {
        return sessaoHoraDAO.find(entityID);
    }

    @Override
    public List<SessaoHora> findAll() {
        return sessaoHoraDAO.findAll();
    }
}
