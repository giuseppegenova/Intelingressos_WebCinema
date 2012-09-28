package br.com.cinema.managedbean;

import br.com.cinema.entity.Filme;
import br.com.cinema.entity.Programacao;
import br.com.cinema.entity.Sala;
import br.com.cinema.entity.Sessao;
import br.com.cinema.facade.local.ProgramacaoFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;

@ManagedBean
@SessionScoped
public class ProgramacaoMB {

    private static final String CREATE_PROGRAMACAO = "createProgramacao";
    private static final String DELETE_PROGRAMACAO = "deleteProgramacao";
    private static final String UPDATE_PROGRAMACAO = "updateProgramacao";
    private static final String LIST_ALL_PROGRAMACOES = "listAllProgramacoes";
    private static final String CONSULTA_PROGRAMACAO = "consultaProgramacao";
    private static final String VENDA_PROGRAMACAO = "vendaProgramacao";
    private static final String STAY_IN_THE_SAME_PAGE = null;
    private static Logger logger = Logger.getLogger(ProgramacaoMB.class.getName());
    @EJB
    private ProgramacaoFacadeLocal programacaoFacade;
    private Programacao programacao;
    private Filme filme;
    private Sala sala;
    private Sessao sessao;
    private List<Programacao> programacaoList;
    private List<Sessao> sessaoList;
    private List<Sala> salaList;
    private boolean skip;

    public ProgramacaoMB() {
        programacao = new Programacao();
        filme = new Filme();
        sala = new Sala();
        sessao = new Sessao();
        sessaoList = new ArrayList<Sessao>();
        salaList = new ArrayList<Sala>();

    }

    @PostConstruct
    public void init() {
        this.programacaoList = carregaProgramacao();
    }

    private List<Programacao> carregaProgramacao() {
        List<Programacao> programacaoTP;
        programacaoTP = programacaoFacade.findAll();
        return programacaoTP;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        logger.info("Current wizard step:" + event.getOldStep());
        logger.info("Next step:" + event.getNewStep());

        if (skip) {
            skip = false;   //reset in case user goes back  
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public List<Sessao> getSessaoList() {
        return sessaoList;
    }

    public void setSessaoList(List<Sessao> sessaoList) {
        this.sessaoList = sessaoList;
    }

    public List<Sala> getSalaList() {
        return salaList;
    }

    public void setSalaList(List<Sala> salaList) {
        this.salaList = salaList;
    }

    public Programacao getProgramacao() {
        return programacao;
    }

    public void setProgramacao(Programacao programacao) {
        this.programacao = programacao;
    }

    public List<Programacao> getProgramacaoList() {
        return programacaoList;
    }

    public void setProgramacaoList(List<Programacao> programacaoList) {
        this.programacaoList = programacaoList;
    }

    public List<Programacao> getAllProgramacoes() {
        return programacaoFacade.findAll();
    }

    public String updateProgramacaoStart() {

        Programacao programacaoTP;
        programacaoTP = programacaoFacade.find(this.programacao.getId());
        this.filme = programacaoTP.getFilme();
        this.sala = programacaoTP.getSala();
        this.sessao = programacaoTP.getSessao();
        return UPDATE_PROGRAMACAO;
    }

    public String updateProgramacaoEnd() {
        try {
            this.programacao.setSala(this.sala);
            this.programacao.setSessao(this.sessao);
            this.programacao.setFilme(this.filme);

            programacaoFacade.update(this.programacao);
        } catch (EJBException e) {
            sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
            return STAY_IN_THE_SAME_PAGE;
        }

        sendInfoMessageToUser("Operação realizada com sucesso: Programacao Atualizada");
        return LIST_ALL_PROGRAMACOES;
    }

    public String deleteProgramacaoStart() {
        return DELETE_PROGRAMACAO;
    }

    public String deleteProgramacaoEnd() {
        try {
            FacesContext.getCurrentInstance();
            programacaoFacade.delete(programacao);
            encerraSessao();
        } catch (EJBException e) {
            sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
            return STAY_IN_THE_SAME_PAGE;
        }

        sendInfoMessageToUser("Operação realizada com sucesso: Programacao Excluida");

        return LIST_ALL_PROGRAMACOES;
    }

    public String createProgramacaoStart() {
        encerraSessao();
        return CREATE_PROGRAMACAO;
    }

    public String createProgramacaoEnd() {
        int ingressoVendidoTP = 0;
        try {
            if (this.programacao.getInicio().before(this.programacao.getFim())) {
                this.sessao.setIngressosDisponiveis(this.sala.getCapacidade());
                this.sessao.setIngressosVendidos(ingressoVendidoTP);  
                
                this.programacao.setSala(this.sala);
                this.programacao.setSessao(this.sessao);
                this.programacao.setFilme(this.filme);

                this.programacaoFacade.save(programacao);

                encerraSessao();
            } else {
                programacao.setFim(null);
                sendErrorMessageToUser("A data de finalização da programação deve ser posterior a data de início");
                return STAY_IN_THE_SAME_PAGE;
            }
        } catch (EJBException e) {
            sendErrorMessageToUser("Houve um erro! Procure o administrador do sistema");
            return STAY_IN_THE_SAME_PAGE;
        }

        sendInfoMessageToUser("Operação realizada com sucesso: Programacao Criada");

        return LIST_ALL_PROGRAMACOES;
    }

    public List<Programacao> listProgramacaosByNome(String nome) {
        List<Programacao> programacaos = new ArrayList<Programacao>();
        //programacaos.add(programacaoFacade.findProgramacaoByNome(nome));
        return programacaos;
    }

    public String listAllProgramacoes() {
        return LIST_ALL_PROGRAMACOES;
    }

    public String consultaProgramacaoStart() {
        return CONSULTA_PROGRAMACAO;
    }

    public String vendaProgramacaoStart() {
        return VENDA_PROGRAMACAO;
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