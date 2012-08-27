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

@FacesConverter(value="filmeConverter")
public class FilmeConverter implements Converter {
	
	@EJB
	private FilmeFacadeLocal filmeFacade;
	

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		
		Long filmeId;

		try {
			filmeId = Long.parseLong(arg2);
		} catch (NumberFormatException exception) {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Type the name of a Dog and select it (or use the dropdow)", "Type the name of a Dog and select it (or use the dropdow)"));
		}

		return filmeFacade.find(filmeId);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

		if (arg2 == null) {
			return "";
		}
		Filme filme = (Filme) arg2;
		return String.valueOf(filme.getId());
	}
}