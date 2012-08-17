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
import br.com.cinema.facade.local.FilmeFacadeLocal;

@ManagedBean
@RequestScoped
public class FilmeMB {
	
	private static final String CREATE_FILME = "createFilme";
	private static final String DELETE_FILME = "deleteFilme"; 
	private static final String UPDATE_FILME = "updateFilme";
	private static final String LIST_ALL_FILMES = "listAllFilmes";	
	private static final String STAY_IN_THE_SAME_PAGE = null;

	@EJB
	private FilmeFacadeLocal filmeFacade;
	
	private Filme filme;	
	
	public FilmeMB() {
		filme = new Filme();		
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
	public List<Filme> getAllFilmes() {
		return filmeFacade.findAll();
	}
	
	public String updateFilmeStart(){
		return UPDATE_FILME;
	}
	
	public String updateFilmeEnd(){
		try {			
			  filmeFacade.update(filme);
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
			return STAY_IN_THE_SAME_PAGE;
		}
		
		sendInfoMessageToUser("Operação realizada com sucesso: Filme Atualizada");
		return LIST_ALL_FILMES;
	}
	
	public String deleteFilmeStart(){
		return DELETE_FILME;
	}

	
	public String deleteFilmeEnd(){
		try {			
			filmeFacade.delete(filme);			
			
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
			return STAY_IN_THE_SAME_PAGE;
		}			
		
		sendInfoMessageToUser("Operação realizada com sucesso: Filme Excluida");
		
		return LIST_ALL_FILMES;
	}
	
	public String createFilmeStart(){
		
		return CREATE_FILME;
	}
	
	public String createFilmeEnd(){
		try {
			filmeFacade.save(filme);
			
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro! Procure o administrador do sistema");
			
			return STAY_IN_THE_SAME_PAGE;
		}		
		
		sendInfoMessageToUser("Operação realizada com sucesso: Filme Criada");
		
		return LIST_ALL_FILMES;
	}
	
	public List<Filme> listFilmesByNome(String nome){
		List<Filme> filmes = new ArrayList<Filme>();
		//filmes.add(filmeFacade.findFilmeByNome(nome));
		return filmes;
	}
	
	public String listAllFilmes(){
		return LIST_ALL_FILMES;
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
