package br.com.cinema.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.cinema.entity.Cinema;
import br.com.cinema.facade.local.CinemaFacadeLocal;

@ManagedBean
@RequestScoped
public class CinemaMB {
	
	private static final String CREATE_CINEMA = "createCinema";
	private static final String DELETE_CINEMA = "deleteCinema"; 
	private static final String UPDATE_CINEMA = "updateCinema";
	private static final String LIST_ALL_CINEMAS = "listAllCinemas";	
	private static final String STAY_IN_THE_SAME_PAGE = null;

	@EJB
	private CinemaFacadeLocal cinemaFacade;
	
	private Cinema cinema;	
	
	public CinemaMB() {
		cinema = new Cinema();		
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	
	public List<Cinema> getAllCinemas() {
		return cinemaFacade.findAll();
	}
	
	public String updateCinemaStart(){
		return UPDATE_CINEMA;
	}
	
	public String updateCinemaEnd(){
		try {			
			  cinemaFacade.update(cinema);
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
			return STAY_IN_THE_SAME_PAGE;
		}
		
		sendInfoMessageToUser("Operação realizada com sucesso: Cinema Atualizada");
		return LIST_ALL_CINEMAS;
	}
	
	public String deleteCinemaStart(){
		return DELETE_CINEMA;
	}

	
	public String deleteCinemaEnd(){
		try {			
			cinemaFacade.delete(cinema);			
			
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
			return STAY_IN_THE_SAME_PAGE;
		}			
		
		sendInfoMessageToUser("Operação realizada com sucesso: Cinema Excluida");
		
		return LIST_ALL_CINEMAS;
	}
	
	public String createCinemaStart(){
		
		return CREATE_CINEMA;
	}
	
	public String createCinemaEnd(){
		try {
			cinemaFacade.save(cinema);
			
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro! Procure o administrador do sistema");
			
			return STAY_IN_THE_SAME_PAGE;
		}		
		
		sendInfoMessageToUser("Operação realizada com sucesso: Cinema Criada");
		
		return LIST_ALL_CINEMAS;
	}
	
	public List<Cinema> listCinemasByNome(String nome){
		List<Cinema> cinemas = new ArrayList<Cinema>();
		//cinemas.add(cinemaFacade.findCinemaByNome(nome));
		return cinemas;
	}
	
	public String listAllCinemas(){
		return LIST_ALL_CINEMAS;
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
