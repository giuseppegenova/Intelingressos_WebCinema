package br.com.cinema.managedbean;

import br.com.cinema.entity.Cidade;
import br.com.cinema.entity.Cliente;
import br.com.cinema.entity.Endereco;
import br.com.cinema.entity.Estado;
import br.com.cinema.facade.local.CidadeFacadeLocal;
import br.com.cinema.facade.local.ClienteFacadeLocal;
import br.com.cinema.facade.local.EnderecoFacadeLocal;
import br.com.cinema.facade.local.EstadoFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean
@SessionScoped
public class ClienteMB {
	
	private static final String CREATE_CLIENTE = "createCliente";
	private static final String DELETE_CLIENTE = "deleteCliente"; 
	private static final String UPDATE_CLIENTE = "updateCliente";
	private static final String LIST_ALL_CLIENTES = "listAllClientes";	
	private static final String STAY_IN_THE_SAME_PAGE = null;
	
	@EJB
	private ClienteFacadeLocal clienteFacade;
	
	@EJB
	private EnderecoFacadeLocal enderecoFacade;
	
	@EJB 
	private CidadeFacadeLocal cidadeFacade;
	
	@EJB
	private EstadoFacadeLocal estadoFacade;
	
	private Cliente cliente;
	
	private Endereco endereco;
	
	private Cidade cidade;
	
	private List<Cidade> cidades;
	
	private Estado estado;
	
	private List<Estado> estados;	
	
	public ClienteMB() {		
                cliente = new Cliente();
                endereco = new Endereco();
                cidade = new Cidade();
                estado = new Estado();
                estados = new ArrayList<Estado>(0);
                cidades = new ArrayList<Cidade>(0);
                
	}
        
        @PostConstruct
        public void carregaEstados(){
            this.estados = estadoFacade.findAll();
        }
        

	public Cliente getCliente() {
		if(cliente == null){
			cliente = new Cliente();
			
		}
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
	
	public List<Cidade> getCidades() {
            if(cidades == null){
                cidades = new ArrayList<Cidade>(0);
            }
		return cidades;
	}	

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
            if(estados == null){
                estados = new ArrayList<Estado>(0);
            }
		return estados;
	}
	

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	

	
	public void atualizaCidades(AjaxBehaviorEvent event){
		Estado estado  = (Estado) event.getComponent().getAttributes().get("value");
		String id = estado.toString();
		if(id != null) {
	           Estado estadoTP = estadoFacade.find(Long.parseLong(id));
	           this.cidades = estadoTP.getCidades();
	           System.out.println("\n" + cidades);
		}		
	}
	
	public List<Estado> listAllEstados(){
		estados = estadoFacade.findAll();		
		return estados;
	}

	public List<Cliente> getAllClientes() {
		return clienteFacade.findAll();
	}
        
        public Estado findEstadoById(Long id){
            return estadoFacade.find(id);
        }
        
        public Cidade findCidadeById(Long id){
            return cidadeFacade.find(id);
        }
	

	public String updateClienteStart(){
		endereco = cliente.getEndereco();
		return UPDATE_CLIENTE;
	}
	
	public String updateClienteEnd(){
		try {
			  cliente.setCidade(cidade);
			  cliente.setEndereco(endereco);
			  clienteFacade.update(cliente);
			  
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
			return STAY_IN_THE_SAME_PAGE;
		}
		
		sendInfoMessageToUser("Operação realizada com sucesso: Cliente Atualizado");
		return LIST_ALL_CLIENTES;
	}
	
	public String deleteClienteStart(){
		return DELETE_CLIENTE;
	}

	
	public String deleteClienteEnd(){
		try {
			cliente.setEndereco(endereco);
			clienteFacade.delete(cliente);
			
			
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
			return STAY_IN_THE_SAME_PAGE;
		}			
		
		sendInfoMessageToUser("Operação realizada com sucesso: Cliente Excluido");
		
		return LIST_ALL_CLIENTES;
	}
	
	public String createClienteStart(){
		
		return CREATE_CLIENTE;
	}
	
	public String createClienteEnd(){
		try {			
		
			cliente.setEndereco(endereco);
			clienteFacade.save(cliente);
			
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro! Procure o administrador do sistema");
			
			return STAY_IN_THE_SAME_PAGE;
		}		
		
		sendInfoMessageToUser("Operação realizada com sucesso: Cliente Criado");
		
		return LIST_ALL_CLIENTES;
	}
	
	public List<Cliente> listClientesByNome(String nome){
		List<Cliente> clientes = new ArrayList<Cliente>();
		//clientes.add(clienteFacade.findClienteByNome(nome));
		return clientes;
	}
	
	public String listAllClientes(){
		return LIST_ALL_CLIENTES;
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
