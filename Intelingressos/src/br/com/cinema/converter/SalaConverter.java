package br.com.cinema.converter;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.cinema.entity.Sala;
import br.com.cinema.facade.local.SalaFacadeLocal;

@Stateless
@FacesConverter(value="salaConverter")
public class SalaConverter implements Converter {

	private Sala sala;	
	
	
	public Sala getSala() {
		if(sala == null){
			sala = new Sala();
		}
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public SalaConverter() {
		sala = new Sala();
	}
	
	@EJB
	SalaFacadeLocal salaFacade;

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {		
		long salaId;

		try {
			
			salaId = Long.parseLong(value);
			return salaFacade.find(salaId);
		} catch (NumberFormatException exception) {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de converção", "Erro ao selecionar este item"));
		}
}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
			return "";
		}
    	
    	try {
    		sala = (Sala) value;
    		if (sala.getId() == 0){
    			return "";
    		}    		
    		
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return sala.toString();       	   
	}
		
}
