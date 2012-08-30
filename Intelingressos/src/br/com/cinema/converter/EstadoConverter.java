package br.com.cinema.converter;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.cinema.entity.Estado;
import br.com.cinema.facade.local.EstadoFacadeLocal;

@FacesConverter(value="estadoConverter")
@Stateless
public class EstadoConverter implements Converter {
	
	private Estado estado;
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public EstadoConverter() {
		estado = new Estado();
	}

	@EJB
	private EstadoFacadeLocal estadoFacade;
	  
    public Object getAsObject(FacesContext facesContext, UIComponent uicomp, String value) {  
    	
    	long estadoId;
    	
		try {		
			estadoId = Long.parseLong(value);
			return estadoFacade.find(estadoId);
		} catch (NumberFormatException exception) {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de converção", "Erro ao selecionar este item"));
		}

		
    }  
  
    public String getAsString(FacesContext facesContext, UIComponent uicomp, Object value) {  
    	
    	try {
    		
    		if (value == null || value.equals("")) {
    			return "";
    		}	
    		
    		estado = (Estado) value;
    		
    		if (estado.getId() == 0){
    			return "";
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return String.valueOf(estado.getId());
    }    
}