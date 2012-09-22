package br.com.cinema.managedbean;

import br.com.cinema.entity.Filme;
import br.com.cinema.entity.Horario;
import br.com.cinema.entity.Ingresso;
import br.com.cinema.entity.Programacao;
import br.com.cinema.entity.Sala;
import br.com.cinema.entity.Sessao;
import br.com.cinema.facade.local.ProgramacaoFacadeLocal;
import br.com.cinema.facade.local.SessaoFacadeLocal;
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
    private Horario horario;
    private Date sessaoData;
    private Date primeiroHorario;
    private Date segundoHorario;
    private Date terceiroHorario;
    private Date quartoHorario;
    private Date quintoHorario;
    private List<Date> dataList;
    private List<Date> horaList;
    private List<Programacao> programacaoList;
    private List<Sessao> sessaoList; 
    private List<Sala> salaList;
    private List<Horario> horarioList;
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
    }

    @PostConstruct
    public void init() {
        this.programacaoList = carregaProgramacao();
        this.sessaoList = carregaListaSessao();
        this.horaList = new ArrayList<Date>();
        this.salaList = new ArrayList<Sala>();
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

    public List<Date> getDataList() {
        return dataList;
    }

    public void setDataList(List<Date> dataList) {
        this.dataList = dataList;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public List<Horario> getHorarioList() {
        return horarioList;
    }

    public void setHorarioList(List<Horario> horarioList) {
        this.horarioList = horarioList;
    }

    public List<Date> getHoraList() {
        return horaList;
    }

    public void setHoraList(List<Date> horaList) {
        this.horaList = horaList;
    }

    public List<Sala> getSalaList() {
        return salaList;
    }

    public void setSalaList(List<Sala> salaList) {
        this.salaList = salaList;
    }
            
    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public Date getSessaoData() {
        return sessaoData;
    }

    public void setSessaoData(Date sessaoData) {
        this.sessaoData = sessaoData;
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

    public Date getPrimeiroHorario() {
        return primeiroHorario;
    }

    public void setPrimeiroHorario(Date primeiroHorario) {
        this.primeiroHorario = primeiroHorario;
    }

    public Date getSegundoHorario() {
        return segundoHorario;
    }

    public void setSegundoHorario(Date segundoHorario) {
        this.segundoHorario = segundoHorario;
    }

    public Date getTerceiroHorario() {
        return terceiroHorario;
    }

    public void setTerceiroHorario(Date terceiroHorario) {
        this.terceiroHorario = terceiroHorario;
    }

    public Date getQuartoHorario() {
        return quartoHorario;
    }

    public void setQuartoHorario(Date quartoHorario) {
        this.quartoHorario = quartoHorario;
    }

    public Date getQuintoHorario() {
        return quintoHorario;
    }

    public void setQuintoHorario(Date quintoHorario) {
        this.quintoHorario = quintoHorario;
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
           
        try {
            if (this.programacao.getInicio().before(this.programacao.getFim())) { 
                
                horaList.add(primeiroHorario);
                horaList.add(segundoHorario);
                horaList.add(terceiroHorario);
                horaList.add(quartoHorario);
                horaList.add(quintoHorario);
                
                this.sessao.setSessaoHora(horarioList);
                this.sessao.setIngressosDisponiveis(this.sala.getCapacidade());
                this.sessao.setIngressosVendidos(ingressoVendidoTP);
                
                sessaoList.add(sessao);
                salaList.add(sala);                
                
                this.filme.setSala(salaList);
                this.filme.setSessao(sessaoList);
                                
                this.programacao.setFilme(this.filme);
                
                this.programacaoFacade.save(programacao);
                
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
