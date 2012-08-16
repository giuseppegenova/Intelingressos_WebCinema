package br.com.cinema.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.cinema.entity.Sala;
import br.com.cinema.facade.local.SalaFacadeLocal;

@ManagedBean
@RequestScoped
public class SalaMB {
	
	private static final String CREATE_SALA = "createSala";
	private static final String DELETE_SALA = "deleteSala"; 
	private static final String UPDATE_SALA = "updateSala";
	private static final String LIST_ALL_SALAS = "listAllSalas";	
	private static final String STAY_IN_THE_SAME_PAGE = null;

	@EJB
	private SalaFacadeLocal salaFacade;
	
	private Sala sala;	
	
	public SalaMB() {
		sala = new Sala();		
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	public List<Sala> getAllSalas() {
		return salaFacade.findAll();
	}
	
	public String updateSalaStart(){
		return UPDATE_SALA;
	}
	
	public String updateSalaEnd(){
		try {			
			  salaFacade.update(sala);
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
			return STAY_IN_THE_SAME_PAGE;
		}
		
		sendInfoMessageToUser("Operação realizada com sucesso: Sala Atualizada");
		return LIST_ALL_SALAS;
	}
	
	public String deleteSalaStart(){
		return DELETE_SALA;
	}

	
	public String deleteSalaEnd(){
		try {			
			salaFacade.delete(sala);			
			
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
			return STAY_IN_THE_SAME_PAGE;
		}			
		
		sendInfoMessageToUser("Operação realizada com sucesso: Sala Excluida");
		
		return LIST_ALL_SALAS;
	}
	
	public String createSalaStart(){
		
		return CREATE_SALA;
	}
	
	public String createSalaEnd(){
		try {
			salaFacade.save(sala);
			
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro! Procure o administrador do sistema");
			
			return STAY_IN_THE_SAME_PAGE;
		}		
		
		sendInfoMessageToUser("Operação realizada com sucesso: Sala Criada");
		
		return LIST_ALL_SALAS;
	}
	
	public List<Sala> listSalasByNome(String nome){
		List<Sala> salas = new ArrayList<Sala>();
		//salas.add(salaFacade.findSalaByNome(nome));
		return salas;
	}
	
	public String listAllSalas(){
		return LIST_ALL_SALAS;
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
