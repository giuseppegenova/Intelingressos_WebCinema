package br.com.cinema.converter;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.cinema.entity.Cliente;
import br.com.cinema.facade.local.ClienteFacadeLocal;

@FacesConverter(value="clienteConverter")
@Stateless
public class ClienteConverter implements Converter {

	public ClienteConverter() {}

	
	@EJB
	private ClienteFacadeLocal clienteFacade;
	
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value == null || value.equals("")) {
			return value;
		}
		Cliente c = new Cliente();
		try {
			c = clienteFacade.find(Long.valueOf(value)) ;
		}catch(NumberFormatException exception) {	 
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de conversão!", "Cliente Inválido"));
		}		
		return c;
}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value == null || value.equals("")) {
			return "";
		}

		Cliente cliente = (Cliente) value;
		
		if (cliente.getId() == 0){
			return "";
		}
		
		return String.valueOf(cliente.getId());

	}
}
