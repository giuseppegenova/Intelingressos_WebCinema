package br.com.cinema.converter;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.cinema.entity.Filme;
import br.com.cinema.facade.local.FilmeFacadeLocal;

@FacesConverter(value="filmeConverter", forClass = Filme.class)

public class FilmeConverter implements Converter {		  
   
	@EJB
	private FilmeFacadeLocal filmeFacade;
	 
		@Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uicomp, String value) {  
    	
    	long filmeId;
    	
		try {		
			filmeId = Long.parseLong(value);
			return filmeFacade.find(filmeId);
		} catch (NumberFormatException exception) {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de converção", "Erro ao selecionar este item"));
		}

		
    }  
        @Override
        public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
            return arg2.toString();
        }		
   
}