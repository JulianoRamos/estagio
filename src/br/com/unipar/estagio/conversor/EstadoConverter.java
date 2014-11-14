package br.com.unipar.estagio.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.unipar.estagio.entidades.Estados;
import br.com.unipar.estagio.persistencia.JpaUtil;

@FacesConverter(forClass = Estados.class, value = "estadoConverter")
public class EstadoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String string) {
		if (string == null || string.isEmpty()) {
			return null;
		}

		Integer id = Integer.valueOf(string);
		Estados estado = JpaUtil.getEntityManager().find(Estados.class, id);
		return estado;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		Estados estado = (Estados) object;
		if (estado == null || estado.getId() == null) {
			return null;
		}
		
		return String.valueOf(estado.getId());
	}

}
