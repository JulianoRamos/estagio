package br.com.unipar.estagio.autenticacao;

import java.util.regex.Pattern;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * @author Juliano Ramos
 */
public class AutenticacaoPhaseListener implements PhaseListener {

	/**
	 * serial Version ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Pasta que cont�m as paginas que somente os usuarios logados poderam enxegar.
	 */
	private static final String RESTRICTION_PATTERN = "^/restrito/.*";

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		String viewId = context.getViewRoot().getViewId();
		boolean urlProtegida = Pattern.matches(RESTRICTION_PATTERN, viewId);

		Object usuario = context.getExternalContext().getSessionMap().get("usuarioLogado");

		if (urlProtegida && usuario == null) {
			NavigationHandler navigator = context.getApplication().getNavigationHandler();
			navigator.handleNavigation(context, null, "login");
		}
	}

	@Override
	public void beforePhase(PhaseEvent event) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}