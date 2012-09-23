package br.com.cinema.converter;

import br.com.cinema.managedbean.FilmeMB;
import javax.ejb.Stateless;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="filmeConverter")
@Stateless
public class FilmeConverter implements Converter {
	
@Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String key) {
        FacesContext context = FacesContext.getCurrentInstance();
        
        FilmeMB filmeMB = (FilmeMB) context.getELContext().getELResolver().getValue(context.getELContext(), null, "filmeMB");
 
        return filmeMB.findFilmeById(Long.parseLong(key));
    }
 
    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        if(arg2 == null){
            return "";
        }
        return String.valueOf(arg2);
    }
    
}