package br.com.unipar.estagio.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import br.com.unipar.estagio.entidades.Cliente;
import br.com.unipar.estagio.entidades.Estados;
import br.com.unipar.estagio.entidades.Usuario;
import br.com.unipar.estagio.persistencia.JpaUtil;

/**
 * @author Juliano Ramos
 */
public class ClienteDao {

	/**
	 * Salva o cliente e gera o MD5 da senha informada.
	 * 
	 * @param cliente da tela de cadastro cliente.
	 */
	public void salvar(Cliente cliente) {
		cliente.getUsuario().setSenhaCriptografada(geraMd5(cliente.getUsuario().getSenha()));
		JpaUtil.getEntityManager().persist(cliente);
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
	 * Busca todos os Estados no banco de dados.
	 * 
	 * @return lista de Estados.
	 */
	public List<Estados> buscaEstados() {
		String jpql = "select e from Estados e";
		TypedQuery<Estados> query = JpaUtil.getEntityManager().createQuery(jpql, Estados.class);
		return (List<Estados>) query.getResultList();
	}
}
