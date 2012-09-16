package br.com.cinema.managedbean;

import br.com.cinema.entity.Cinema;
import br.com.cinema.entity.Programacao;
import br.com.cinema.facade.local.CinemaFacadeLocal;
import br.com.cinema.facade.local.ProgramacaoFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.DualListModel;

@ManagedBean
@RequestScoped
public class CinemaMB {

    private static final String CREATE_CINEMA = "createCinema";
    private static final String DELETE_CINEMA = "deleteCinema";
    private static final String UPDATE_CINEMA = "updateCinema";
    private static final String LIST_ALL_CINEMAS = "listAllCinemas";
    private static final String STAY_IN_THE_SAME_PAGE = null;
    @EJB
    private CinemaFacadeLocal cinemaFacade;
    @EJB
    private ProgramacaoFacadeLocal programacaoFacade;
    private Cinema cinema;
    private Programacao programacao;
    private List<Programacao> programacaoList;
    private List<Programacao> programacaoListTarget;
    private DualListModel<Programacao> programacaoDualList;

    public CinemaMB() {
        cinema = new Cinema();
        programacao = new Programacao();
        programacaoList = new ArrayList<Programacao>();
        programacaoListTarget = new ArrayList<Programacao>();
        programacaoDualList = new DualListModel<Programacao>(this.programacaoList, this.programacaoListTarget);
    }
    
    @PostConstruct
    public void init(){
        carregaListaProgramacao();
        programacaoList = programacaoFacade.findAll();
    }
    
    private void carregaListaProgramacao(){
        
    }
    
    public Cinema findCinemaById(Long id){
        return cinemaFacade.find(id);
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }    

    public Programacao getProgramacao() {
        return programacao;
    }

    public void setProgramacao(Programacao programacao) {
        this.programacao = programacao;
    }
    
    public List<Cinema> getAllCinemas() {
        return cinemaFacade.findAll();
    }

    public List<Programacao> getProgramacaoList() {
        return programacaoList;
    }

    public void setProgramacaoList(List<Programacao> programacaoList) {
        this.programacaoList = programacaoList;
    }

    public List<Programacao> getProgramacaoListTarget() {
        return programacaoListTarget;
    }

    public void setProgramacaoListTarget(List<Programacao> programacaoListTarget) {
        this.programacaoListTarget = programacaoListTarget;
    }

    public DualListModel<Programacao> getProgramacaoDualList() {
        return programacaoDualList = new DualListModel<Programacao>(this.programacaoList, this.programacaoListTarget);
    }

    public void setProgramacaoDualList(DualListModel<Programacao> programacaoDualList) {
        this.programacaoDualList = programacaoDualList;
    }

    public String updateCinemaStart() {
        return UPDATE_CINEMA;
    }

    public String updateCinemaEnd() {
        try {
            cinemaFacade.update(cinema);
        } catch (EJBException e) {
            sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
            return STAY_IN_THE_SAME_PAGE;
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("Atualização", new FacesMessage("Cinema atualizado com sucesso! " + cinema.getNome()));
        return LIST_ALL_CINEMAS;
    }

    public String deleteCinemaStart() {
        return DELETE_CINEMA;
    }

    public String deleteCinemaEnd() {
        try {
            cinemaFacade.delete(cinema);

        } catch (EJBException e) {
            sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
            return STAY_IN_THE_SAME_PAGE;
        }

        sendInfoMessageToUser("Operação realizada com sucesso: Cinema Excluida");

        return LIST_ALL_CINEMAS;
    }

    public String createCinemaStart() {

        return CREATE_CINEMA;
    }

    public String createCinemaEnd() {
        try {
            cinemaFacade.save(cinema);

        } catch (EJBException e) {
            sendErrorMessageToUser("Houve um erro! Procure o administrador do sistema");

            return STAY_IN_THE_SAME_PAGE;
        }

        sendInfoMessageToUser("Operação realizada com sucesso: Cinema Criada");

        return LIST_ALL_CINEMAS;
    }

    public List<Cinema> listCinemasByNome(String nome) {
        List<Cinema> cinemas = new ArrayList<Cinema>();
        //cinemas.add(cinemaFacade.findCinemaByNome(nome));
        return cinemas;
    }

    public String listAllCinemas() {
        return LIST_ALL_CINEMAS;
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
