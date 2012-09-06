package br.com.cinema.converter;

import br.com.cinema.entity.Sala;
import br.com.cinema.facade.local.SalaFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="salaConverter")
@Stateless
public class SalaConverter implements Converter {
	
	private Sala sala;
	
	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public SalaConverter() {
		sala = new Sala();
	}

	@EJB
	private SalaFacadeLocal salaFacade;
	  
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uicomp, String value) {  
    	
    	long salaId;
    	
		try {		
			salaId = Long.parseLong(value);
			return salaFacade.find(salaId);
		} catch (NumberFormatException exception) {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de conver��o", "Erro ao selecionar este item"));
		}

		
    }  
  
    @Override
    public String getAsString(FacesContext facesContext, UIComponent uicomp, Object value) {  
    	
    	try {
    		
    		if (value == null || value.equals("")) {
    			return "";
    		}	
    		
    		sala = (Sala) value;
    		
    		if (sala.getId() == 0){
    			return "";
    		}
		} catch (Exception e) {
			System.out.println(e);
		}
    	return String.valueOf(sala.getId());
    }    
}