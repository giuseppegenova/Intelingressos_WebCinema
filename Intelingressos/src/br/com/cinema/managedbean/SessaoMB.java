package br.com.cinema.managedbean;

import br.com.cinema.entity.Filme;
import br.com.cinema.entity.Sessao;
import br.com.cinema.entity.SessaoData;
import br.com.cinema.entity.SessaoHora;
import br.com.cinema.facade.local.FilmeFacadeLocal;
import br.com.cinema.facade.local.SessaoFacadeLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
public class SessaoMB {

    private static final String CREATE_SESSAO = "createSessao";
    private static final String DELETE_SESSAO = "deleteSessao";
    private static final String UPDATE_SESSAO = "updateSessao";
    private static final String LIST_ALL_SESSOES = "listAllSessoes";
    private static final String STAY_IN_THE_SAME_PAGE = null;
    @EJB
    private SessaoFacadeLocal sessaoFacade;
    @EJB
    private FilmeFacadeLocal filmeFacade;
    private Sessao sessao;
    private Date dataLocal;
    private SessaoData sessaoData;
    private SessaoHora sessaoHora;
    private DualListModel<String> horaPic;
    private List<SessaoData> sessaoDataList;
    private List<Sessao> sessaoList;
    private Map<Sessao, String> sessaoMap;
    private List<String> horaSource;
    private List<String> horaTarget;
    private Filme filme;
    private Map<Filme, String> filmeMap;
    private List<Filme> filmeList;

    public SessaoMB() {
        
        sessao = new Sessao();
        sessaoMap = new HashMap<Sessao, String>();
        sessaoList = new ArrayList<Sessao>();
        sessaoDataList = new ArrayList<SessaoData>();
        sessaoData = new SessaoData();
        filme = new Filme();
        filmeMap = new HashMap<Filme, String>();
        filmeList = new ArrayList<Filme>();
        
        dataLocal = new Date();
        
        horaSource = new ArrayList<String>();
        horaTarget = new ArrayList<String>();

        horaSource.add("10:00");
        horaSource.add("10:15");
        horaSource.add("10:30");
        horaSource.add("10:45");
        horaSource.add("11:00");
        horaSource.add("11:15");
        horaSource.add("11:30");
        horaSource.add("11:45");
        horaSource.add("12:00");
        horaSource.add("12:15");
        horaSource.add("12:30");
        horaSource.add("12:45");
        horaSource.add("13:00");
        horaSource.add("13:15");
        horaSource.add("13:30");
        horaSource.add("13:45");
        horaSource.add("14:00");
        horaSource.add("14:15");
        horaSource.add("14:30");
        horaSource.add("14:45");
        horaSource.add("15:00");
        horaSource.add("15:15");
        horaSource.add("15:30");
        horaSource.add("15:45");
        horaSource.add("16:00");
        horaSource.add("16:15");
        horaSource.add("16:30");
        horaSource.add("16:45");
        horaSource.add("17:00");
        horaSource.add("17:15");
        horaSource.add("17:30");
        horaSource.add("17:45");
        horaSource.add("18:00");
        horaSource.add("18:15");
        horaSource.add("18:30");
        horaSource.add("18:45");
        horaSource.add("19:00");
        horaSource.add("19:15");
        horaSource.add("19:30");
        horaSource.add("19:45");
        horaSource.add("20:00");
        horaSource.add("20:15");
        horaSource.add("20:30");
        horaSource.add("20:45");
        horaSource.add("21:00");
        horaSource.add("21:15");
        horaSource.add("21:30");
        horaSource.add("21:45");
        horaSource.add("22:00");
        horaSource.add("22:15");
        horaSource.add("22:30");
        horaSource.add("22:45");

        horaPic = new DualListModel<String>(horaSource, horaTarget);
    }

    @PostConstruct
    public void init() {
        carregaListaSessoes();
        carregaSelectSessoes(sessaoList);
    }

    public List<Filme> carregaListaFilmes(){
        return filmeFacade.findAll();
    }
     
    private void carregaListaSessoes() {
        this.sessaoList = sessaoFacade.findAll();
    }

    private void carregaSelectSessoes(List<Sessao> ses) {
        if (ses != null) {
            for (int i = 0; i < ses.size(); i++) {
                this.sessaoMap.put(ses.get(i), String.valueOf(i));
            }
        }
    }

    public Sessao findSessaoById(Long id) {
        return sessaoFacade.find(id);
    }
    
    public Filme findFilmeById(Long id){
        return filmeFacade.find(id);
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public DualListModel<String> getHoraPic() {
        return horaPic;
    }

    public void setHoraPic(DualListModel<String> horaPic) {
        this.horaPic = horaPic;
    }

    public Date getDataLocal() {
        return dataLocal;
    }

    public void setDataLocal(Date dataLocal) {
        this.dataLocal = dataLocal;
    }

    public SessaoHora getSessaoHora() {
        return sessaoHora;
    }

    public void setSessaoHora(SessaoHora sessaoHora) {
        this.sessaoHora = sessaoHora;
    }

    public List<String> getHoraSource() {
        return horaSource;
    }

    public void setHoraSource(List<String> horaSource) {
        this.horaSource = horaSource;
    }

    public List<String> getHoraTarget() {
        return horaTarget;
    }

    public void setHoraTarget(List<String> horaTarget) {
        this.horaTarget = horaTarget;
    }

    public List<SessaoData> getSessaoDataSet() {
        return sessaoDataList;
    }

    public void setSessaoDataSet(List<SessaoData> sessaoDataSet) {
        this.sessaoDataList = sessaoDataSet;
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

    public SessaoData getSessaoData() {
        return sessaoData;
    }

    public void setSessaoData(SessaoData sessaoData) {
        this.sessaoData = sessaoData;
    }

    public void setSessaoMap(Map<Sessao, String> sessaoMap) {
        this.sessaoMap = sessaoMap;
    }

    public List<SessaoData> getSessaoDataList() {
        return sessaoDataList;
    }

    public void setSessaoDataList(List<SessaoData> sessaoDataList) {
        this.sessaoDataList = sessaoDataList;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Map<Filme, String> getFilmeMap() {
        return filmeMap;
    }

    public void setFilmeMap(Map<Filme, String> filmeMap) {
        this.filmeMap = filmeMap;
    }

    public List<Filme> getFilmeList() {
        return filmeList;
    }

    public void setFilmeList(List<Filme> filmeList) {
        this.filmeList = filmeList;
    }

    public List<Sessao> getAllSessoes() {
        return sessaoFacade.findAll();
    }

    public String updateSessaoStart() {
        return UPDATE_SESSAO;
    }

    public String updateSessaoEnd() {
        try {
            sessaoFacade.update(sessao);
        } catch (EJBException e) {
            sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
            return STAY_IN_THE_SAME_PAGE;
        }

        sendInfoMessageToUser("Operação realizada com sucesso: Sessao Atualizada");
        return LIST_ALL_SESSOES;
    }

    public String deleteSessaoStart() {
        return DELETE_SESSAO;
    }

    public String deleteSessaoEnd() {
        try {
            sessaoFacade.delete(sessao);

        } catch (EJBException e) {
            sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
            return STAY_IN_THE_SAME_PAGE;
        }

        sendInfoMessageToUser("Operação realizada com sucesso: Sessao Excluida");

        return LIST_ALL_SESSOES;
    }

    public String createSessaoStart() {

        return CREATE_SESSAO;
    }

    public String createSessaoEnd() {
        Set<SessaoHora> sessaoHoraTP = new HashSet<SessaoHora>();
        try {
            for (int i = 0; i < horaTarget.size(); i++) {
                this.sessaoHora.setHoraSessao(horaTarget.get(i));
                sessaoHoraTP.add(this.sessaoHora);
            }

            this.sessaoData.setSessaoHora(sessaoHoraTP);
            this.sessaoData.setDataSessao(dataLocal);
            this.sessaoDataList.add(sessaoData);
            this.sessao.setSessaoData(sessaoDataList);
            this.sessao.setFilme(filme);
            sessaoFacade.save(sessao);

        } catch (EJBException e) {
            sendErrorMessageToUser("Houve um erro! Procure o administrador do sistema");

            return STAY_IN_THE_SAME_PAGE;
        }

        sendInfoMessageToUser("Operação realizada com sucesso: Sessao Criada");

        return LIST_ALL_SESSOES;
    }

    public List<Sessao> listSessoesByNome(String nome) {
        List<Sessao> sessaos = new ArrayList<Sessao>();
        //sessaos.add(sessaoFacade.findSessaoByNome(nome));
        return sessaos;
    }

    public String listAllSessoes() {
        return LIST_ALL_SESSOES;
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
