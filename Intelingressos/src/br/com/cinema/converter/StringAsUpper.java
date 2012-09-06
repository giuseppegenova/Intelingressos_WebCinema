package br.com.cinema.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/*@Name("convertToUpper")
@org.jboss.seam.annotations.faces.Converter
@BypassInterceptors*/
public class StringAsUpper implements Converter {

    @Override
 public Object getAsObject(FacesContext facesContext
                           , UIComponent component, String value) {
  return value.toString().toUpperCase();
 }

    @Override
 public String getAsString(FacesContext facesContext
                          , UIComponent component, Object value) {
  return value.toString().toUpperCase();
 }

}