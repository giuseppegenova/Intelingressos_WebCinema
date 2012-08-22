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

@Stateless
@FacesConverter(value="filmeConverter")
public class FilmeConverter implements Converter {

	public FilmeConverter() {
	}
	
	@EJB
	FilmeFacadeLocal filmeFacade;

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value == null || value.equals("")) {
			return value;
		}
		Filme c = new Filme();
		try {
			c = filmeFacade.find(Long.valueOf(value)) ;
		}catch(NumberFormatException exception) {	 
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de conversão!", "Filme Inválida"));
		}		
		return c;
}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
			return "";
		}

		Filme filme = (Filme) value;
		
		if (filme.getId() == 0){
			return "";
		}
		
		return filme.getId().toString();

	}
}
