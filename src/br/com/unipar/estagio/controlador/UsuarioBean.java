package br.com.unipar.estagio.controlador;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.unipar.estagio.dao.UsuarioDao;
import br.com.unipar.estagio.entidades.Usuario;

/**
 * @author Juliano Ramos
 */
@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {

	/**
	 * Serial Version ID Usuario Bean.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Usuario informado na tela de login.
	 */
	private Usuario usuario;

	/**
	 * Mensagem de Erro de usuario e senha.
	 */
	private String validacaoUsuarioSenha;

	/**
	 * Classe com as regras de negocio do usuario.
	 */
	private UsuarioDao usuarioDao;

	/**
	 * Construtor.
	 */
	public UsuarioBean() {
		usuarioDao = new UsuarioDao();
	}

	/**
	 * Efetua o Login do usuario no sistema.
	 * 
	 * @return Tela de login ou a tela principal.
	 */
	public String logar() {
		String retorno = usuarioDao.logar(this.usuario);
		if (retorno == null) {
			this.validacaoUsuarioSenha = "Usuário e Senha incorretos.";
		} else {
			this.validacaoUsuarioSenha = "";
		}

		return retorno;
	}

	/**
	 * Pega usuario causo seja null instancia ele e retorna.
	 * 
	 * @return Usuario.
	 */
	public Usuario getUsuario() {
		if (this.usuario == null) {
			this.usuario = new Usuario();
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getValidacaoUsuarioSenha() {
		return validacaoUsuarioSenha;
	}

	public void setValidacaoUsuarioSenha(String validacaoUsuarioSenha) {
		this.validacaoUsuarioSenha = validacaoUsuarioSenha;
	}
}
