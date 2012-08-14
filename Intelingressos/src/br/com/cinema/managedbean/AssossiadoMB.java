package br.com.cinema.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.cinema.entity.Assossiado;
import br.com.cinema.entity.Cidade;
import br.com.cinema.entity.Cinema;
import br.com.cinema.entity.Endereco;
import br.com.cinema.entity.Estado;
import br.com.cinema.entity.Plano;
import br.com.cinema.facade.local.AssossiadoFacadeLocal;

@ManagedBean
@RequestScoped
public class AssossiadoMB {
	
	private static final String CREATE_ASSOSSIADO = "createAssossiado";
	private static final String DELETE_ASSOSSIADO = "deleteAssossiado"; 
	private static final String UPDATE_ASSOSSIADO = "updateAssossiado";
	private static final String LIST_ALL_ASSOSSIADOS = "listAllAssossiados";	
	private static final String STAY_IN_THE_SAME_PAGE = null;
	
	@EJB
	private AssossiadoFacadeLocal assossiadoFacade;
	
	private Assossiado assossiado;
	
	private Endereco endereco;
	
	private Cidade cidade;
	
	private Estado estado;
	
	private Cinema cinema;
	
	private Plano plano;

	public Assossiado getAssossiado() {
		if(assossiado == null){
			assossiado = new Assossiado();
		}
		return assossiado;
	}

	public void setAssossiado(Assossiado assossiado) {
		this.assossiado = assossiado;
	}
	
	public Endereco getEndereco() {
		if(endereco == null){
			endereco = new Endereco();
		}
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cidade getCidade() {
		if(cidade == null){
			cidade = new Cidade();
		}
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		if(estado == null){
			estado = new Estado();
		}
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cinema getCinema() {
		if(cinema == null){
			cinema = new Cinema();
		}
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public Plano getPlano() {
		if(plano == null){
			plano = new Plano();
		}
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public List<Assossiado> getAllAssossiados() {
		return assossiadoFacade.findAll();
	}	
	

	public String updateAssossiadoStart(){
		return UPDATE_ASSOSSIADO;
	}
	
	public String updateAssossiadoEnd(){
		try {
			assossiadoFacade.update(assossiado);			
			  
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
			return STAY_IN_THE_SAME_PAGE;
		}
		
		sendInfoMessageToUser("Operação realizada com sucesso: Assossiado Atualizado");
		return LIST_ALL_ASSOSSIADOS;
	}
	
	public String deleteAssossiadoStart(){
		return DELETE_ASSOSSIADO;
	}

	
	public String deleteAssossiadoEnd(){
		try {
			assossiadoFacade.delete(assossiado);			
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
			return STAY_IN_THE_SAME_PAGE;
		}			
		
		sendInfoMessageToUser("Operação realizada com sucesso: Assossiado Excluido");
		
		return LIST_ALL_ASSOSSIADOS;
	}
	
	public String createAssossiadoStart(){
		
		return CREATE_ASSOSSIADO;
	}
	
	public String createAssossiadoEnd(){
		try {
					
			assossiadoFacade.save(assossiado);				
			
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro! Procure o administrador do sistema");
			
			return STAY_IN_THE_SAME_PAGE;
		}		
		
		sendInfoMessageToUser("Operação realizada com sucesso: Assossiado Criado");
		
		return LIST_ALL_ASSOSSIADOS;
	}
	
	public List<Assossiado> listAssossiadosByNome(String nome){
		List<Assossiado> assossiados = new ArrayList<Assossiado>();
		//assossiados.add(assossiadoFacade.findAssossiadoByNome(nome));
		return assossiados;
	}
	
	public String listAllAssossiados(){
		return LIST_ALL_ASSOSSIADOS;
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
}
