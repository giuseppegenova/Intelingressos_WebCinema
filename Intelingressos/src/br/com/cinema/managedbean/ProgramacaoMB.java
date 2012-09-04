package br.com.cinema.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.cinema.entity.Filme;
import br.com.cinema.entity.Programacao;
import br.com.cinema.entity.Sala;
import br.com.cinema.entity.Sessao;
import br.com.cinema.facade.local.FilmeFacadeLocal;
import br.com.cinema.facade.local.ProgramacaoFacadeLocal;
import br.com.cinema.facade.local.SalaFacadeLocal;
import br.com.cinema.facade.local.SessaoFacadeLocal;

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
	
	@EJB
	private FilmeFacadeLocal  filmeFacade;
	
	@EJB
	private SalaFacadeLocal salaFacade;
	
	@EJB
	private SessaoFacadeLocal sessaoFacade;
	
	private Programacao programacao;	
	
	private Filme filme;
	
	private Sala sala;
	
	private Sessao sessao;
	
	public ProgramacaoMB() {
		programacao = new Programacao();
		filme = new Filme();
		sala = new Sala();
		sessao = new Sessao();		
	}	
	
	public Filme getFilme() {
		if(filme == null){
			filme = new Filme();
		}
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Sala getSala() {
		if(sala == null){
			sala = new Sala();
		}
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Sessao getSessao() {
		if(sessao == null){
			sessao = new Sessao();
		}
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}
	
	public Programacao getProgramacao() {
		if(programacao == null){
			programacao = new Programacao();			
		}
		return programacao;
	}

	public void setProgramacao(Programacao programacao) {
		this.programacao = programacao;		
	}
	
		
	public List<Programacao> getAllProgramacoes() {
		return programacaoFacade.findAll();
	}	

	public Programacao findProgramacaoByFilme(Filme filme){
		return null;
	}
	
	public String updateProgramacaoStart(){
		return UPDATE_PROGRAMACAO;
	}
	
	public String updateProgramacaoEnd(){
		try {			
			  programacaoFacade.update(programacao);
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
			return STAY_IN_THE_SAME_PAGE;
		}
		
		sendInfoMessageToUser("Operação realizada com sucesso: Programacao Atualizada");
		return LIST_ALL_PROGRAMACOES;
	}
	
	public String deleteProgramacaoStart(){
		return DELETE_PROGRAMACAO;
	}

	
	public String deleteProgramacaoEnd(){
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
	
	public String createProgramacaoStart(){
		
		return CREATE_PROGRAMACAO;
	}
	
	public String createProgramacaoEnd(){
		try {
			if(programacao.getInicio().before(programacao.getFim())){
			programacao.setFilme(filme);
			programacao.setSala(sala);
			programacao.setSessao(sessao);
			programacaoFacade.save(programacao);
			}
			else{
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
	
	public List<Programacao> listProgramacaosByNome(String nome){
		List<Programacao> programacaos = new ArrayList<Programacao>();
		//programacaos.add(programacaoFacade.findProgramacaoByNome(nome));
		return programacaos;
	}
	
	public String listAllProgramacoes(){
		return LIST_ALL_PROGRAMACOES;
	}	
	
	private void sendInfoMessageToUser(String message){
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}
	
	private void sendErrorMessageToUser(String message){
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
