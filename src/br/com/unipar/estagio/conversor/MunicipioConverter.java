package br.com.unipar.estagio.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.unipar.estagio.entidades.Municipios;
import br.com.unipar.estagio.persistencia.JpaUtil;

@FacesConverter(forClass = Municipios.class, value = "municipioConverter")
public class MunicipioConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String string) {
		if (string == null || string.isEmpty()) {
			return null;
		}

		Integer id = Integer.valueOf(string);
		Municipios municipio = JpaUtil.getEntityManager().find(Municipios.class, id);
		return municipio;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		Municipios municipio = (Municipios) object;
		if (municipio == null || municipio.getId() == null) {
			return null;
		}

		return String.valueOf(municipio.getId());
	}
}
