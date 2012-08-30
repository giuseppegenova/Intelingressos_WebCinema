package br.com.cinema.converter;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.cinema.entity.Cliente;
import br.com.cinema.facade.local.ClienteFacadeLocal;

@FacesConverter(value="clienteConverter")
@Stateless
public class ClienteConverter implements Converter {
	
	private Cliente cliente;
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteConverter() {
		cliente = new Cliente();
	}

	@EJB
	private ClienteFacadeLocal clienteFacade;
	  
    public Object getAsObject(FacesContext facesContext, UIComponent uicomp, String value) {  
    	
    	long clienteId;
    	
		try {		
			clienteId = Long.parseLong(value);
			return clienteFacade.find(clienteId);
		} catch (NumberFormatException exception) {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de converção", "Erro ao selecionar este item"));
		}

		
    }  
  
    public String getAsString(FacesContext facesContext, UIComponent uicomp, Object value) {  
    	
    	try {
    		
    		if (value == null || value.equals("")) {
    			return "";
    		}	
    		
    		cliente = (Cliente) value;
    		
    		if (cliente.getId() == 0){
    			return "";
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return String.valueOf(cliente.getId());
    }    
}