package br.com.unipar.estagio.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;

import br.com.unipar.estagio.entidades.Usuario;
import br.com.unipar.estagio.persistencia.JpaUtil;

/**
 * @author Juliano Ramos
 */
public class UsuarioDao {

	/**
	 * Efetua o Login do usuario no sistema.
	 * 
	 * @param usuario Usuario informado na tela de login.
	 * @return Tela de login ou a tela principal.
	 */
	public String logar(Usuario usuario) {

		if (usuario == null) {
			return "login.xhtml";
		} else {
			String senhaCriptografada = geraMd5(usuario.getSenha());
			Usuario usuarioGravado = getUsuario(usuario.getLogin());
			if (senhaCriptografada.equals(usuarioGravado.getSenhaCriptografada())) {

				FacesContext ctx = FacesContext.getCurrentInstance();
				HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
				session.setAttribute("usuarioLogado", usuario);

				return "restrito/index.xhtml";
			} else {
				return null;
			}
		}
	}

	/**
	 * Busca Usuario no banco de dados através do login.
	 * 
	 * @param login Login do usuario.
	 * @return Usuario.
	 */
	public Usuario getUsuario(String login) {
		String jpql = "select u from Usuario u where u.login=:login";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("login", login);

		TypedQuery<Usuario> query = JpaUtil.getEntityManager().createQuery(jpql, Usuario.class);
		for (Map.Entry<String, Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		return (Usuario) query.getSingleResult();
	}

	/**
	 * Metodo responsavel por gerar a Criptografia da senha de usuario, MD5.
	 * 
	 * @param senha Senha do usuario.
	 * @return Senha Criptografada.
	 */
	private String geraMd5(String senha) {
		final Integer dezesseis = 16;
		String sen = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
		sen = hash.toString(dezesseis);
		return sen;
	}
}
