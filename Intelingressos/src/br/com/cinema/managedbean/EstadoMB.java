package br.com.cinema.managedbean;

import br.com.cinema.entity.Cidade;
import br.com.cinema.entity.Estado;
import br.com.cinema.facade.local.EstadoFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class EstadoMB {
	
	private static final String CREATE_ESTADO = "createEstado";
	private static final String DELETE_ESTADO = "deleteEstado"; 
	private static final String UPDATE_ESTADO = "updateEstado";
	private static final String LIST_ALL_ESTADOS = "listAllEstados";	
	private static final String STAY_IN_THE_SAME_PAGE = null;

	@EJB
	private EstadoFacadeLocal estadoFacade;
	
	private Estado estado;
	
	private Cidade cidade;
	
	private List<Estado> estados;
	
	private List<Cidade> cidades;

	private String verificaMaiuscula;
	
	public EstadoMB() {
		estado = new Estado();
		estados = new ArrayList<Estado>();
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public List<Estado> getEstados() {
		return estados;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Estado> getAllEstados() {
		return estadoFacade.findAll();
	}
	
	public String getVerificaMaiuscula() {
		return verificaMaiuscula;
	}

	public void setVerificaMaiuscula(String verificaMaiuscula) {
		this.verificaMaiuscula = verificaMaiuscula;
	}
	
	public void verificaMaiuscula(){
		this.estado.getSigla().toUpperCase();
	}

	public List<Cidade> atualizaCidades(){
		return this.cidades = (List<Cidade>) this.estado.getCidades();
	}
	
	public String updateEstadoStart(){
		return UPDATE_ESTADO;
	}
	
	public String updateEstadoEnd(){
		try {			
			  estadoFacade.update(estado);
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
			return STAY_IN_THE_SAME_PAGE;
		}
		
		sendInfoMessageToUser("Operação realizada com sucesso: Estado Atualizada");
		return LIST_ALL_ESTADOS;
	}
	
	public String deleteEstadoStart(){
		return DELETE_ESTADO;
	}

	
	public String deleteEstadoEnd(){
		try {			
			estadoFacade.delete(estado);			
			
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
			return STAY_IN_THE_SAME_PAGE;
		}			
		
		sendInfoMessageToUser("Operação realizada com sucesso: Estado Excluida");
		
		return LIST_ALL_ESTADOS;
	}
	
	public String createEstadoStart(){
		
		return CREATE_ESTADO;
	}
	
	public String createEstadoEnd(){
		try {
		
			estadoFacade.save(estado);
			
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro! Procure o administrador do sistema");
			
			return STAY_IN_THE_SAME_PAGE;
		}		
		
		sendInfoMessageToUser("Operação realizada com sucesso: Estado Criada");
		
		return LIST_ALL_ESTADOS;
	}
	
	public List<Estado> listEstadosByNome(String nome){
		List<Estado> estados = new ArrayList<Estado>();
		//estados.add(estadoFacade.findEstadoByNome(nome));
		return estados;
	}
	
	public String listAllEstados(){
		return LIST_ALL_ESTADOS;
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
