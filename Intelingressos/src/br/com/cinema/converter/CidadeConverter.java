package br.com.cinema.converter;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.cinema.entity.Cidade;
import br.com.cinema.facade.local.CidadeFacadeLocal;

@FacesConverter(value="cidadeConverter")
@Stateless
public class CidadeConverter implements Converter {

	public CidadeConverter() {}

	
	@EJB
	private CidadeFacadeLocal cidadeFacade;
	
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value == null || value.equals("")) {
			return value;
		}
		Cidade c = new Cidade();
		try {
			c = cidadeFacade.find(Long.valueOf(value)) ;
		}catch(NumberFormatException exception) {	 
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de conversão!", "Cidade Inválido"));
		}		
		return c;
}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value == null || value.equals("")) {
			return "";
		}

		Cidade cidade = (Cidade) value;
		
		if (cidade.getId() == 0){
			return "";
		}
		
		return String.valueOf(cidade.getId());

	}
}
