package br.com.cinema.managedbean;

import br.com.cinema.entity.Cidade;
import br.com.cinema.entity.Estado;
import br.com.cinema.facade.local.CidadeFacadeLocal;
import br.com.cinema.facade.local.EstadoFacadeLocal;
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
public class CidadeMB {
	
	private static final String CREATE_CIDADE = "createCidade";
	private static final String DELETE_CIDADE = "deleteCidade"; 
	private static final String UPDATE_CIDADE = "updateCidade";
	private static final String LIST_ALL_CIDADES = "listAllCidades";	
	private static final String STAY_IN_THE_SAME_PAGE = null;

	@EJB
	private CidadeFacadeLocal cidadeFacade;
        
        @EJB
        private EstadoFacadeLocal estadoFacade;
	
	private Cidade cidade;	
	
	private Estado estado;
        
        private List<Estado> estados;
        
        private Map<Estado, String> estadoMap;
	
	private List<Cidade> cidades;

	public CidadeMB() {
		cidade = new Cidade();
		estado = new Estado();
		cidades = new ArrayList<Cidade>();
                estados = new ArrayList<Estado>();
                estadoMap = new HashMap<Estado, String>();
	}
        
        @PostConstruct
        public void init(){
            listAllEstados();
        }
        
        private void listAllEstados(){
            estados = estadoFacade.findAll(); 
            carregaSelectEstados(estados);
        }

        private void carregaSelectEstados(List<Estado> est){
            for (int i = 0; i < est.size(); i++) {
                estadoMap.put(est.get(i), String.valueOf(i));                
            }
        }
        
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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

        public void setEstados(List<Estado> estados) {
            this.estados = estados;
        }

        
	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

        public Map<Estado, String> getEstadoMap() {
            return estadoMap;
        }

        public void setEstadoMap(Map<Estado, String> estadoMap) {
            this.estadoMap = estadoMap;
        }
            
	public List<Cidade> getAllCidades() {
		return cidadeFacade.findAll();
	}
	
	public String updateCidadeStart(){
		return UPDATE_CIDADE;
	}
	
	public String updateCidadeEnd(){
		try {			
			  cidadeFacade.update(cidade);
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
			return STAY_IN_THE_SAME_PAGE;
		}
		
		sendInfoMessageToUser("Operação realizada com sucesso: Cidade Atualizada");
		return LIST_ALL_CIDADES;
	}
	
	public String deleteCidadeStart(){
		return DELETE_CIDADE;
	}

	
	public String deleteCidadeEnd(){
		try {			
			cidadeFacade.delete(cidade);			
			
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro. Procure o administrador do sistema");
			return STAY_IN_THE_SAME_PAGE;
		}			
		
		sendInfoMessageToUser("Operação realizada com sucesso: Cidade Excluida");
		
		return LIST_ALL_CIDADES;
	}
	
	public String createCidadeStart(){
		
		return CREATE_CIDADE;
	}
	
	public String createCidadeEnd(){
		try {
			cidade.setEstado(estado);
			cidadeFacade.save(cidade);
			
		} catch (EJBException e) {
			sendErrorMessageToUser("Houve um erro! Procure o administrador do sistema");
			
			return STAY_IN_THE_SAME_PAGE;
		}		
		
		sendInfoMessageToUser("Operação realizada com sucesso: Cidade Criada");
		
		return LIST_ALL_CIDADES;
	}
	
	public List<Cidade> listCidadesByNome(String nome){
		List<Cidade> cidades = new ArrayList<Cidade>();
		//cidades.add(cidadeFacade.findCidadeByNome(nome));
		return cidades;
	}
	
	public String listAllCidades(){
		return LIST_ALL_CIDADES;
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
