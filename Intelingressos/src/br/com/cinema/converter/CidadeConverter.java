package br.com.cinema.converter;

import br.com.cinema.managedbean.ClienteMB;
import javax.ejb.Stateless;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="cidadeConverter")
@Stateless
public class CidadeConverter implements Converter {
	
@Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String key) {
        
        FacesContext context = FacesContext.getCurrentInstance();
        ClienteMB clienteMB = (ClienteMB) context.getELContext().getELResolver().getValue(context.getELContext(), null, "clienteMB");
        if(key == null || key.equals("")){
            return "";
        }
        return clienteMB.findCidadeById(Long.parseLong(key));
    }
 
    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        return String.valueOf(arg2);
    }
    
}