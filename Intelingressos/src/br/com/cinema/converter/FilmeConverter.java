package br.com.cinema.converter;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.cinema.entity.Filme;
import br.com.cinema.facade.local.FilmeFacadeLocal;

@FacesConverter(value="filmeConverter")
@Stateless
public class FilmeConverter implements Converter {
	
	private Filme filme;
	
	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public FilmeConverter() {
		filme = new Filme();
	}

	@EJB
	private FilmeFacadeLocal filmeFacade;
	  
    public Object getAsObject(FacesContext facesContext, UIComponent uicomp, String value) {  
    	
    	long filmeId;
    	
		try {		
			filmeId = Long.parseLong(value);
			return filmeFacade.find(filmeId);
		} catch (NumberFormatException exception) {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de converção", "Erro ao selecionar este item"));
		}

		
    }  
  
    public String getAsString(FacesContext facesContext, UIComponent uicomp, Object value) {  
    	
    	try {
    		
    		if (value == null || value.equals("")) {
    			return "";
    		}	
    		
    		filme = (Filme) value;
    		
    		if (filme.getId() == 0){
    			return "";
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return filme.getId().toString();
    }    
}