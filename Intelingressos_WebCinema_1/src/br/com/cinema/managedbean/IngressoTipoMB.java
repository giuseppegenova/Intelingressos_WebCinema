package br.com.cinema.managedbean;

import br.com.cinema.entity.IngressoTipo;
import br.com.cinema.facade.local.IngressoTipoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class IngressoTipoMB {

    private static final String CREATE_INGRESSOTIPO = "createIngressoTipo";
    private static final String DELETE_INGRESSOTIPO = "deleteIngressoTipo";
    private static final String UPDATE_INGRESSOTIPO = "updateIngressoTipo";
    private static final String LIST_ALL_INGRESSOSTIPO = "listAllIngressosTipo";
    private static final String STAY_IN_THE_SAME_PAGE = null;
    @EJB
    private IngressoTipoFacadeLocal ingressoTipoFacade;
    private IngressoTipo ingressoTipo;

    public IngressoTipoMB() {
        ingressoTipo = new IngressoTipo();
    }

    public IngressoTipo getIngressoTipo() {
        return ingressoTipo;
    }

    public void setIngressoTipo(IngressoTipo ingressoTipo) {
        this.ingressoTipo = ingressoTipo;
    }

    public List<IngressoTipo> getAllIngressosTipo() {
        return ingressoTipoFacade.findAll();
    }

    public IngressoTipo findIngressoTipoById(Long id) {
        return ingressoTipoFacade.find(id);
    }

    public String updateIngressoTipoStart() {
        return UPDATE_INGRESSOTIPO;
    }

    public String updateIngressoTipoEnd() {
        try {
            ingressoTipoFacade.update(ingressoTipo);
        } catch (EJBException e) {
            sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
            return STAY_IN_THE_SAME_PAGE;
        }

        sendInfoMessageToUser("Operação realizada com sucesso: IngressoTipo Atualizado");
        return LIST_ALL_INGRESSOSTIPO;
    }

    public String deleteIngressoTipoStart() {
        return DELETE_INGRESSOTIPO;
    }

    public String deleteIngressoTipoEnd() {
        try {
            ingressoTipoFacade.delete(ingressoTipo);

        } catch (EJBException e) {
            sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
            return STAY_IN_THE_SAME_PAGE;
        }

        sendInfoMessageToUser("Operação realizada com sucesso: IngressoTipo Excluido");

        return LIST_ALL_INGRESSOSTIPO;
    }

    public String createIngressoTipoStart() {

        return CREATE_INGRESSOTIPO;
    }

    public String createIngressoTipoEnd() {
        try {

            ingressoTipoFacade.save(ingressoTipo);

        } catch (EJBException e) {
            sendErrorMessageToUser("Houve um erro! Procure o administrador do sistema. " + e);

            return STAY_IN_THE_SAME_PAGE;
        }

        sendInfoMessageToUser("Operação realizada com sucesso: IngressoTipo Criado");

        return LIST_ALL_INGRESSOSTIPO;
    }

    public String listAllIngressosTipo() {
        return LIST_ALL_INGRESSOSTIPO;
    }

    private void sendInfoMessageToUser(String message) {
        FacesContext context = getContext();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
    }

    private void sendErrorMessageToUser(String message) {
        FacesContext context = getContext();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
    }

    private FacesContext getContext() {
        FacesContext context = FacesContext.getCurrentInstance();
        return context;
    }

    public String encerraSessao() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return STAY_IN_THE_SAME_PAGE;
    }
}
