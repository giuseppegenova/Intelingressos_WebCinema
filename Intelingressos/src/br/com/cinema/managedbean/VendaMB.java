package br.com.cinema.managedbean;

import br.com.cinema.entity.Filme;
import br.com.cinema.entity.Ingresso;
import br.com.cinema.entity.Programacao;
import br.com.cinema.entity.Sala;
import br.com.cinema.entity.Sessao;
import br.com.cinema.facade.local.FilmeFacadeLocal;
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
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.event.FlowEvent;

@ManagedBean
@RequestScoped
public class VendaMB {

    private static final String CREATE_PROGRAMACAO = "createProgramacao";
    private static final String DELETE_PROGRAMACAO = "deleteProgramacao";
    private static final String UPDATE_PROGRAMACAO = "updateProgramacao";
    private static final String LIST_ALL_PROGRAMACOES = "listAllProgramacoes";
    private static final String CONSULTA_PROGRAMACAO = "consultaProgramacao";
    private static final String VENDA_PROGRAMACAO = "vendaProgramacao";
    private static final String STAY_IN_THE_SAME_PAGE = null;
    private static Logger logger = Logger.getLogger(VendaMB.class.getName());
    @EJB
    private ProgramacaoFacadeLocal programacaoFacade;
    @EJB
    private SessaoFacadeLocal sessaoFacade;
    @EJB
    private FilmeFacadeLocal filmeFacade;
    
    private Programacao programacao;
    private Filme filme;
    private String filmeString;
    private Sala sala;
    private Sessao sessao;
    private Date sessaoData;
    private List<Date> dataList;
    private List<Date> horaList;
    private List<Programacao> programacaoList;
    private List<Sessao> sessaoList;
    private List<Sala> salaList;
    private List<Filme> filmeList;
    private Map<Filme, String> filmeMap;
    private Map<Sessao, String> sessaoMap;
    private Map<Ingresso, String> ingressoMap;
    private boolean skip;

    public VendaMB() {
        programacao = new Programacao();
        filme = new Filme();
        sala = new Sala();
        sessao = new Sessao();
        sessaoList = new ArrayList<Sessao>();
        filmeList = new ArrayList<Filme>();
        sessaoMap = new HashMap<Sessao, String>();
        ingressoMap = new HashMap<Ingresso, String>();
        filmeMap = new HashMap<Filme, String>();

    }

    @PostConstruct
    public void init() {
        this.programacaoList = carregaProgramacao();
       
        this.horaList = new ArrayList<Date>();
        this.salaList = new ArrayList<Sala>();
        
        carregaListaFilme();
    }

    private void carregaSelectFilme(List<Filme> fil) {
        for (int i = 0; i < fil.size(); i++) {
            filmeMap.put(fil.get(i), String.valueOf(fil.get(i).getId()));

        }
    }

    private void carregaListaFilme() {
        List<Filme> filmeListTP;
        filmeListTP = filmeFacade.findAll();
        carregaSelectFilme(filmeListTP);
    }

    private void carregaSelectSessao(List<Sessao> ses) {
        for (int i = 0; i < ses.size(); i++) {
            sessaoMap.put(ses.get(i), String.valueOf(ses.get(i).getId()));
        }
    }

    public void carregaListaSessao(AjaxBehaviorEvent event) {
        FacesContext.getCurrentInstance();
       
        sessaoList = this.filme.getSessao();
        
        carregaSelectSessao(sessaoList);
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

    public List<Filme> getFilmeList() {
        return filmeList;
    }

    public void setFilmeList(List<Filme> filmeList) {
        this.filmeList = filmeList;
    }

    public Map<Filme, String> getFilmeMap() {
        return filmeMap;
    }

    public void setFilmeMap(Map<Filme, String> filmeMap) {
        this.filmeMap = filmeMap;
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
                this.sessao.setIngressosDisponiveis(this.sala.getCapacidade());
                this.sessao.setIngressosVendidos(ingressoVendidoTP);

                sessaoList.add(sessao);
                salaList.add(sala);

                this.filme.setSala(salaList);
                this.filme.setSessao(sessaoList);

                this.sala.setFilme(filme);
                this.sessao.setFilme(filme);

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
