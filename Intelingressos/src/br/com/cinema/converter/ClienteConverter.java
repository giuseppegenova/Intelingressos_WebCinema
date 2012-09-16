package br.com.cinema.converter;

import br.com.cinema.managedbean.ClienteMB;
import javax.ejb.Stateless;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="clienteConverter")
@Stateless
public class ClienteConverter implements Converter {
	
@Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String key) {
        FacesContext context = FacesContext.getCurrentInstance();
        ClienteMB clienteMB = (ClienteMB) context.getELContext().getELResolver().getValue(context.getELContext(), null, "clienteMB");
 
        return clienteMB.findEstadoById(Long.parseLong(key));
    }
 
    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        return String.valueOf(arg2);
    }
    
}