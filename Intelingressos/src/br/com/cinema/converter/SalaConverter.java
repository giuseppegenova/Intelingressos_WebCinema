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

	public SalaConverter() {
	}
	
	@EJB
	SalaFacadeLocal salaFacade;

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {		
		Sala c = new Sala();
		try {
			if (value == null || value.equals("")) {
				return value;
			}
			else{
				c = salaFacade.find(Long.valueOf(value)) ;
			}
		}catch(NumberFormatException exception) {	 
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de conversão!", "Sala Inválida"));
		}		
		return c;
}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
			return "";
		}

		Sala sala = (Sala) value;
		
		if (sala.getId() == 0){
			return "";
		}
		
		return sala.getId().toString();

	}
}
