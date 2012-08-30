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
	
	private Cidade cidade;
	
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public CidadeConverter() {
		cidade = new Cidade();
	}

	@EJB
	private CidadeFacadeLocal cidadeFacade;
	  
    public Object getAsObject(FacesContext facesContext, UIComponent uicomp, String value) {  
    	
    	long cidadeId;
    	
		try {		
			cidadeId = Long.parseLong(value);
			return cidadeFacade.find(cidadeId);
		} catch (NumberFormatException exception) {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de converção", "Erro ao selecionar este item"));
		}

		
    }  
  
    public String getAsString(FacesContext facesContext, UIComponent uicomp, Object value) {  
    	
    	try {
    		
    		if (value == null || value.equals("")) {
    			return "";
    		}	
    		
    		cidade = (Cidade) value;
    		
    		if (cidade.getId() == 0){
    			return "";
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return String.valueOf(cidade.getId());
    }    
}