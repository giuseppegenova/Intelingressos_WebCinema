package br.com.cinema.managedbean;

import br.com.cinema.entity.Filme;
import br.com.cinema.entity.Ingresso;
import br.com.cinema.entity.Programacao;
import br.com.cinema.entity.Sala;
import br.com.cinema.entity.Sessao;
import br.com.cinema.facade.local.ProgramacaoFacadeLocal;
import br.com.cinema.facade.local.SessaoFacadeLocal;
import br.com.cinema.util.DateUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;

@ManagedBean
@ViewScoped
public class ProgramacaoMB {

    private static final String CREATE_PROGRAMACAO = "createProgramacao";
    private static final String DELETE_PROGRAMACAO = "deleteProgramacao";
    private static final String UPDATE_PROGRAMACAO = "updateProgramacao";
    private static final String LIST_ALL_PROGRAMACOES = "listAllProgramacoes";
    private static final String STAY_IN_THE_SAME_PAGE = null;
    private static Logger logger = Logger.getLogger(ProgramacaoMB.class.getName());
    @EJB
    private ProgramacaoFacadeLocal programacaoFacade;
    @EJB
    private SessaoFacadeLocal sessaoFacade;
    private Programacao programacao;    
    private Filme filme;
    private Sala sala;
    private Sessao sessao;
    private Date dataLocal;
    private Date dataLocal2;    
    private Date primeiraHora;
    private Date segundaHora;
    private Date terceiraHora;
    private Date quartaHora;
    private List<Date> dataLista;    
    private List<Programacao> programacaoList;
    private List<Sessao> sessaoList;    
    private Map<Sessao, String> sessaoMap;
    private Map<Ingresso, String> ingressoMap;
   
  
    private boolean skip;
    
    public ProgramacaoMB() {
        programacao = new Programacao();
        filme = new Filme();
        sala = new Sala();
        sessao = new Sessao();
        sessaoList = new ArrayList<Sessao>();
        sessaoMap = new HashMap<Sessao, String>();
        ingressoMap = new HashMap<Ingresso, String>();
        
        dataLocal = new Date();
    }

    @PostConstruct
    public void init() {
        this.programacaoList = carregaProgramacao();
        this.sessaoList = carregaListaSessao();
        carregaSelectSessao(sessaoList);
    }
    
    private void carregaSelectSessao(List<Sessao> ses) {
        for (int i = 0; i < ses.size(); i++) {
            sessaoMap.put(ses.get(i), String.valueOf(i));

        }
    }

    private List<Sessao> carregaListaSessao() {
        List<Sessao> sessaoTP;
        sessaoTP = sessaoFacade.findAll();
        return sessaoTP;
    }

    private List<Programacao> carregaProgramacao() {
        List<Programacao> programacaoTP;
        programacaoTP = programacaoFacade.findAll();
        return programacaoTP;
    }

    public List<Date> getDataLista() {
        return dataLista;
    }

    public void setDataLista(List<Date> dataLista) {
        this.dataLista = dataLista;
    }

    public Date getDataLocal() {
        return dataLocal;
    }

    public void setDataLocal(Date dataLocal) {
        this.dataLocal = dataLocal;
    }

    public Date getDataLocal2() {
        return dataLocal2;
    }

    public void setDataLocal2(Date dataLocal2) {
        this.dataLocal2 = dataLocal2;
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

    public Map<Sessao, String> getSessaoMap() {
        return sessaoMap;
    }

    public void setSessaoMap(Map<Sessao, String> sessaoMap) {
        this.sessaoMap = sessaoMap;
    }

    public Map<Ingresso, String> getIngressoMap() {
        return ingressoMap;
    }

    public void setIngressoMap(Map<Ingresso, String> ingressoMap) {
        this.ingressoMap = ingressoMap;
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

    public Date getPrimeiraHora() {
        return primeiraHora;
    }

    public void setPrimeiraHora(Date primeiraHora) {
        this.primeiraHora = primeiraHora;
    }

    public Date getSegundaHora() {
        return segundaHora;
    }

    public void setSegundaHora(Date segundaHora) {
        this.segundaHora = segundaHora;
    }

    public Date getTerceiraHora() {
        return terceiraHora;
    }

    public void setTerceiraHora(Date terceiraHora) {
        this.terceiraHora = terceiraHora;
    }

    public Date getQuartaHora() {
        return quartaHora;
    }

    public void setQuartaHora(Date quartaHora) {
        this.quartaHora = quartaHora;
    }

    public Programacao findProgramacaoByFilme(Filme filme) {
        return null;
    }

    public Sessao findSessaoById(Long id) {
        return sessaoFacade.find(id);
    }

    public String updateProgramacaoStart() {

        Filme filmeTP;
        Sala salaTP;
        Sessao sessaoTP;

        filmeTP = programacao.getFilme();
        this.filme.setNome(filmeTP.getNome());
        this.filme.setSinopse(filmeTP.getSinopse());
        this.filme.setSiteOficial(filmeTP.getSiteOficial());

        salaTP = programacao.getSala();
        this.sala.setNome(salaTP.getNome());
        this.sala.setCapacidade(salaTP.getCapacidade());

        sessaoTP = programacao.getSessao();
        // this.sessao.setData(sessaoTP.getData());
        //this.sessao.setHora(sessaoTP.getHora());

        return UPDATE_PROGRAMACAO;
    }

    public String updateProgramacaoEnd() {
        try {

            Filme filmeTP = new Filme();
            filmeTP.setNome(this.filme.getNome());
            filmeTP.setSinopse(this.filme.getSinopse());
            filmeTP.setSiteOficial(this.filme.getSiteOficial());

            Sala salaTP = new Sala();
            salaTP.setNome(this.sala.getNome());
            salaTP.setCapacidade(this.sala.getCapacidade());

            Sessao sessaoTP = new Sessao();
            // sessaoTP.setData(this.sessao.getData());
            //sessaoTP.setHora(this.sessao.getHora());

            this.programacao.setFilme(filmeTP);
            this.programacao.setSala(salaTP);
            this.programacao.setSessao(sessaoTP);

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
            programacaoFacade.delete(programacao);
            /*filmeFacade.find(filme.getId());
             salaFacade.delete(sala);
             sessaoFacade.delete(sessao);	*/
        } catch (EJBException e) {
            sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
            return STAY_IN_THE_SAME_PAGE;
        }

        sendInfoMessageToUser("Operação realizada com sucesso: Programacao Excluida");

        return LIST_ALL_PROGRAMACOES;
    }

    public String createProgramacaoStart() {

        return CREATE_PROGRAMACAO;
    }

    public String createProgramacaoEnd() {
           int ingressoVendidoTP = 0;           
           List<Date> horaLista = new ArrayList<Date>();
           String dataString;
           Date DataTP;
        try {
            if (programacao.getInicio().before(programacao.getFim())) {              
                programacao.setFilme(this.filme);
                programacao.setSala(this.sala);
                this.sessao.setIngressosDisponiveis(sala.getCapacidade());
                this.sessao.setIngressosVendidos(ingressoVendidoTP);
               
                horaLista.add(primeiraHora);
                horaLista.add(segundaHora);
                                
                dataString = DateUtils.converterDataUSParaBR(dataLocal);
                DataTP = DateUtils.strToDate(dataString);
                              
                programacao.setSessao(this.sessao);
                programacaoFacade.save(programacao);
            } else {
                programacao.setFim(null);
                sendErrorMessageToUser("A data de finalização da programação deve ser posterior a data de in�cio");
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
