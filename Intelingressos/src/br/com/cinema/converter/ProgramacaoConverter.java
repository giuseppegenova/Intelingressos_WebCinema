package br.com.cinema.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.cinema.managedbean.ProgramacaoMB;

@FacesConverter(value="programacaoConverter")
public class ProgramacaoConverter implements Converter {
 
    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String key) {
        FacesContext context = FacesContext.getCurrentInstance();
        ProgramacaoMB programacaoMB = (ProgramacaoMB) context.getELContext().getELResolver().getValue(context.getELContext(), null, "programacaoMB");
 
        return programacaoMB..getUserByName(key);
    }
 
    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        return arg2.toString();
    }
}