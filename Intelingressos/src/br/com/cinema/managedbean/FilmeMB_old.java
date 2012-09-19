package br.com.cinema.managedbean;

import br.com.cinema.entity.Filme;
import br.com.cinema.entity.Sessao;
import br.com.cinema.entity.SessaoData;
import br.com.cinema.entity.SessaoHora;
import br.com.cinema.facade.local.FilmeFacadeLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.DualListModel;

@ManagedBean
@RequestScoped
public class FilmeMB_old {

    private static final String CREATE_FILME = "createFilme";
    private static final String DELETE_FILME = "deleteFilme";
    private static final String UPDATE_FILME = "updateFilme";
    private static final String LIST_ALL_FILMES = "listAllFilmes";
    private static final String STAY_IN_THE_SAME_PAGE = null;
    @EJB
    private FilmeFacadeLocal filmeFacade;
    private Filme filme;
    private Sessao sessao;
    private Date dataLocal;
    private SessaoData sessaoData;
    private SessaoHora sessaoHora;
    private DualListModel<String> horaPic;
    private List<String> horaSource;
    private List<String> horaTarget;

    public FilmeMB_old() {
        filme = new Filme();
        dataLocal = new Date();
        sessao = new Sessao();
        sessaoData = new SessaoData();
        sessaoHora = new SessaoHora();
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

    public DualListModel<String> getHoraPic() {
        return horaPic;
    }

    public void setHoraPic(DualListModel<String> horaPic) {
        this.horaPic = horaPic;
    }

    public SessaoData getSessaoData() {
        return sessaoData;
    }

    public void setSessaoData(SessaoData sessaoData) {
        this.sessaoData = sessaoData;
    }

    public SessaoHora getSessaoHora() {
        return sessaoHora;
    }

    public void setSessaoHora(SessaoHora sessaoHora) {
        this.sessaoHora = sessaoHora;
    }

    public Date getDataLocal() {
        return dataLocal;
    }

    public void setDataLocal(Date dataLocal) {
        this.dataLocal = dataLocal;
    }

    public Filme getFilme() {
        if (filme == null) {
            filme = new Filme();
        }
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public List<Filme> getAllFilmes() {
        return filmeFacade.findAll();
    }

    public Filme getFilmeByNome(String nome) {
        return filmeFacade.findFilmeByNome(nome);
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public String updateFilmeStart() {
        return UPDATE_FILME;
    }

    public String updateFilmeEnd() {
        try {
            filmeFacade.update(filme);
        } catch (EJBException e) {
            sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
            return STAY_IN_THE_SAME_PAGE;
        }

        sendInfoMessageToUser("Operação realizada com sucesso: Filme Atualizada");
        return LIST_ALL_FILMES;
    }

    public String deleteFilmeStart() {
        return DELETE_FILME;
    }

    public String deleteFilmeEnd() {
        try {
            filmeFacade.delete(filme);

        } catch (EJBException e) {
            sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
            return STAY_IN_THE_SAME_PAGE;
        }

        sendInfoMessageToUser("Operação realizada com sucesso: Filme Excluida");

        return LIST_ALL_FILMES;
    }

    public String createFilmeStart() {

        return CREATE_FILME;
    }

    public String createFilmeEnd() {
        try {
            filmeFacade.save(filme);

        } catch (EJBException e) {
            sendErrorMessageToUser("Houve um erro! Procure o administrador do sistema");

            return STAY_IN_THE_SAME_PAGE;
        }

        sendInfoMessageToUser("Operação realizada com sucesso: Filme Criada");

        return LIST_ALL_FILMES;
    }

    public List<Filme> listFilmesByNome(String nome) {
        List<Filme> filmes = new ArrayList<Filme>();
        //filmes.add(filmeFacade.findFilmeByNome(nome));
        return filmes;
    }

    public String listAllFilmes() {
        return LIST_ALL_FILMES;
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
