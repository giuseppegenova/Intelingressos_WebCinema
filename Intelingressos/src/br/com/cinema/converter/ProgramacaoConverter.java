package br.com.cinema.converter;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.cinema.entity.Programacao;
import br.com.cinema.facade.local.ProgramacaoFacadeLocal;

@Stateless
@FacesConverter(value="programacaoConverter")
public class ProgramacaoConverter implements Converter {

	public ProgramacaoConverter() {
	}
	
	@EJB
	ProgramacaoFacadeLocal programacaoFacade;

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value == null || value.equals("")) {
			return value;
		}
		Programacao c = new Programacao();
		try {
			c = programacaoFacade.find(Long.valueOf(value)) ;
		}catch(NumberFormatException exception) {	 
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de conversão!", "Programacao Inválida"));
		}		
		return c;
}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value == null || value.equals("")) {
			return "";
		}

		Programacao programacao = (Programacao) value;
		
		if (programacao.getId() == 0){
			return "";
		}
		
		return programacao.getId().toString();

	}
}
