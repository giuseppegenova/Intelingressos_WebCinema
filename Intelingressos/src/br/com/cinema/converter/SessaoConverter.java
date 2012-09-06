package br.com.cinema.converter;

import br.com.cinema.entity.Sessao;
import br.com.cinema.facade.local.SessaoFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="sessaoConverter")
@Stateless
public class SessaoConverter implements Converter {
	
	private Sessao sessao;
	
	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public SessaoConverter() {
		sessao = new Sessao();
	}

	@EJB
	private SessaoFacadeLocal sessaoFacade;
	  
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uicomp, String value) {  
    	
    	long sessaoId;
    	
		try {		
			sessaoId = Long.parseLong(value);
			return sessaoFacade.find(sessaoId);
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
    		
    		sessao = (Sessao) value;
    		
    		if (sessao.getId() == 0){
    			return "";
    		}
		} catch (Exception e) {
			System.out.println(e);
		}
    	return String.valueOf(sessao.getId());
    }    
}