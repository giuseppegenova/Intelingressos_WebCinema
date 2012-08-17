package br.com.cinema.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.cinema.entity.Sessao;
import br.com.cinema.facade.local.SessaoFacadeLocal;

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
	
	private Sessao sessao;	
	
	public SessaoMB() {
		sessao = new Sessao();		
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}
	
	public List<Sessao> getAllSessoes() {
		return sessaoFacade.findAll();
	}
	
	public String updateSessaoStart(){
		return UPDATE_SESSAO;
	}
	
	public String updateSessaoEnd(){
		try {			
			  sessaoFacade.update(sessao);
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
			return STAY_IN_THE_SAME_PAGE;
		}
		
		sendInfoMessageToUser("Operação realizada com sucesso: Sessao Atualizada");
		return LIST_ALL_SESSOES;
	}
	
	public String deleteSessaoStart(){
		return DELETE_SESSAO;
	}

	
	public String deleteSessaoEnd(){
		try {			
			sessaoFacade.delete(sessao);			
			
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
			return STAY_IN_THE_SAME_PAGE;
		}			
		
		sendInfoMessageToUser("Operação realizada com sucesso: Sessao Excluida");
		
		return LIST_ALL_SESSOES;
	}
	
	public String createSessaoStart(){
		
		return CREATE_SESSAO;
	}
	
	public String createSessaoEnd(){
		try {
			sessaoFacade.save(sessao);
			
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro! Procure o administrador do sistema");
			
			return STAY_IN_THE_SAME_PAGE;
		}		
		
		sendInfoMessageToUser("Operação realizada com sucesso: Sessao Criada");
		
		return LIST_ALL_SESSOES;
	}
	
	public List<Sessao> listSessoesByNome(String nome){
		List<Sessao> sessaos = new ArrayList<Sessao>();
		//sessaos.add(sessaoFacade.findSessaoByNome(nome));
		return sessaos;
	}
	
	public String listAllSessoes(){
		return LIST_ALL_SESSOES;
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
