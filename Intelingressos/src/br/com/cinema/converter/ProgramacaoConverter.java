package br.com.cinema.converter;

import br.com.cinema.entity.Programacao;
import br.com.cinema.facade.local.ProgramacaoFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="programacaoConverter")
@Stateless
public class ProgramacaoConverter implements Converter {
	
	private Programacao programacao;
	
	public Programacao getProgramacao() {
		return programacao;
	}

	public void setProgramacao(Programacao programacao) {
		this.programacao = programacao;
	}

	public ProgramacaoConverter() {
		programacao = new Programacao();
	}

	@EJB
	private ProgramacaoFacadeLocal programacaoFacade;
	  
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uicomp, String value) {  
    	
    	long programacaoId;
    	
		try {		
			programacaoId = Long.parseLong(value);
			return programacaoFacade.find(programacaoId);
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
    		
    		programacao = (Programacao) value;
    		
    		if (programacao.getId() == 0){
    			return "";
    		}
		} catch (Exception e) {
			System.out.println(e);
		}
    	return String.valueOf(programacao.getId());
    }    
}