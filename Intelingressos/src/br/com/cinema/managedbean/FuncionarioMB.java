package br.com.cinema.managedbean;

import br.com.cinema.entity.Cidade;
import br.com.cinema.entity.Cinema;
import br.com.cinema.entity.Estado;
import br.com.cinema.entity.Funcionario;
import br.com.cinema.facade.local.FuncionarioFacadeLocal;
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
public class FuncionarioMB {
	
	private static final String CREATE_FUNCIONARIO = "createFuncionario";
	private static final String DELETE_FUNCIONARIO = "deleteFuncionario"; 
	private static final String UPDATE_FUNCIONARIO = "updateFuncionario";
	private static final String LIST_ALL_FUNCIONARIOS = "listAllFuncionarios";	
	private static final String STAY_IN_THE_SAME_PAGE = null;
	
	@EJB
	private FuncionarioFacadeLocal funcionarioFacade;
	
	private Funcionario funcionario;	
	
	private Cidade cidade;
	
	private Estado estado;
	
	private Cinema cinema;
	
	public Funcionario getFuncionario() {
		if(funcionario == null){
			funcionario = new Funcionario();
		}
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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
	
	public List<Funcionario> getAllFuncionarios() {
		return funcionarioFacade.findAll();
	}	
	

	public String updateFuncionarioStart(){
		return UPDATE_FUNCIONARIO;
	}
	
	public String updateFuncionarioEnd(){
		try {
			funcionarioFacade.update(funcionario);			
			  
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
			return STAY_IN_THE_SAME_PAGE;
		}
		
		sendInfoMessageToUser("Operação realizada com sucesso: Funcionario Atualizado");
		return LIST_ALL_FUNCIONARIOS;
	}
	
	public String deleteFuncionarioStart(){
		return DELETE_FUNCIONARIO;
	}

	
	public String deleteFuncionarioEnd(){
		try {
			funcionarioFacade.delete(funcionario);			
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
			return STAY_IN_THE_SAME_PAGE;
		}			
		
		sendInfoMessageToUser("Operação realizada com sucesso: Funcionario Excluido");
		
		return LIST_ALL_FUNCIONARIOS;
	}
	
	public String createFuncionarioStart(){
		
		return CREATE_FUNCIONARIO;
	}
	
	public String createFuncionarioEnd(){
		try {
					
			funcionarioFacade.save(funcionario);				
			
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro! Procure o administrador do sistema");
			
			return STAY_IN_THE_SAME_PAGE;
		}		
		
		sendInfoMessageToUser("Operação realizada com sucesso: Funcionario Criado");
		
		return LIST_ALL_FUNCIONARIOS;
	}
	
	public List<Funcionario> listFuncionariosByNome(String nome){
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		//funcionarios.add(funcionarioFacade.findFuncionarioByNome(nome));
		return funcionarios;
	}
	
	public String listAllFuncionarios(){
		return LIST_ALL_FUNCIONARIOS;
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
