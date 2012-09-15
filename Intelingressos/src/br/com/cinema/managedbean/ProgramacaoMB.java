package br.com.cinema.managedbean;

import br.com.cinema.entity.Filme;
import br.com.cinema.entity.Ingresso;
import br.com.cinema.entity.Programacao;
import br.com.cinema.entity.Sala;
import br.com.cinema.entity.Sessao;
import br.com.cinema.facade.local.ProgramacaoFacadeLocal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class ProgramacaoMB {

    private static final String CREATE_PROGRAMACAO = "createProgramacao";
    private static final String DELETE_PROGRAMACAO = "deleteProgramacao";
    private static final String UPDATE_PROGRAMACAO = "updateProgramacao";
    private static final String LIST_ALL_PROGRAMACOES = "listAllProgramacoes";
    private static final String STAY_IN_THE_SAME_PAGE = null;
    @EJB
    private ProgramacaoFacadeLocal programacaoFacade;
    private Programacao programacao;
    private List<Programacao> programacaoList;
    private Filme filme;
    private Sala sala;
    private Sessao sessao;
    private Map<Ingresso, String> ingressoMap;

    public ProgramacaoMB() {
        programacao = new Programacao();
        filme = new Filme();
        sala = new Sala();
        sessao = new Sessao();
        ingressoMap = new HashMap<Ingresso, String>();
    }

    @PostConstruct
    public void init() {
        carregaProgramacao();
    }

    private void carregaProgramacao() {
        programacaoList = programacaoFacade.findAll();
        //carregaSelectEstados(estados);          
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

    public Sala getSala() {
        if (sala == null) {
            sala = new Sala();
        }
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Sessao getSessao() {
        if (sessao == null) {
            sessao = new Sessao();
        }
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Map<Ingresso, String> getIngressoMap() {
        return ingressoMap;
    }

    public void setIngressoMap(Map<Ingresso, String> ingressoMap) {
        this.ingressoMap = ingressoMap;
    }

    public Programacao getProgramacao() {
        if (programacao == null) {
            programacao = new Programacao();
        }
        return programacao;
    }

    public void setProgramacao(Programacao programacao) {
        this.programacao = programacao;
    }

    public List<Programacao> getProgramacaoList() {
        if (programacaoList == null) {
            programacaoList = new ArrayList<Programacao>();
        }
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
        this.sessao.setData(sessaoTP.getData());
        this.sessao.setHora(sessaoTP.getHora());

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
            sessaoTP.setData(this.sessao.getData());
            sessaoTP.setHora(this.sessao.getHora());

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
        try {
            if (programacao.getInicio().before(programacao.getFim())) {
                programacao.setFilme(filme);
                programacao.setSala(sala);
                programacao.setSessao(sessao);
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
