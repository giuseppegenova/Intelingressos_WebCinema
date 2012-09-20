package br.com.cinema.converter;

import br.com.cinema.managedbean.SessaoMB;
import javax.ejb.Stateless;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="sessaoConverter")
@Stateless
public class sessaoConverter implements Converter {
	
@Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String key) {
        FacesContext context = FacesContext.getCurrentInstance();
        SessaoMB sessaoMB = (SessaoMB) context.getELContext().getELResolver().getValue(context.getELContext(), null, "sessaoMB");
 
        return sessaoMB.findFilmeById(Long.parseLong(key));
    }
 
    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        return String.valueOf(arg2);
    }
    
}