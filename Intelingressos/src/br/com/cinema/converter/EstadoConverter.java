package br.com.cinema.converter;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
  
@FacesConverter(value = "EstadoConverter")  
public class EstadoConverter implements Converter {  
  
    private int index;  
  
    @SuppressWarnings("unchecked")
	public Object getAsObject(FacesContext facesContext, UIComponent uicomp, String value) {  
        List<SelectItem> items = new ArrayList<SelectItem>();  
        List<UIComponent> uicompList = uicomp.getChildren();  
        for(UIComponent comp: uicompList){  
            if(comp instanceof UISelectItems){  
                items.addAll((List<SelectItem>) ((UISelectItems)comp).getValue());  
            }  
        }  
        return "-1".equals(value) ? null :  items.get(Integer.valueOf(value)).getValue();  
    }  
  
    public String getAsString(FacesContext facesContext, UIComponent uicomp, Object entity) {  
        return entity == null ? "-1" : String.valueOf(index++);  
    }  
  
}  