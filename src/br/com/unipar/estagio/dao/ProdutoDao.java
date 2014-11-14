package br.com.unipar.estagio.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import br.com.unipar.estagio.entidades.Produto;
import br.com.unipar.estagio.persistencia.JpaUtil;

/**
 * @author Juliano Ramos
 */
public class ProdutoDao {

	/**
	 * Salva o produto no banco de dados.
	 * 
	 * @param produto que será salvo no banco.
	 */
	public void salvar(Produto produto) {
		JpaUtil.getEntityManager().persist(produto);
	}

	/**
	 * Converte a imagem para bytes e atribui no Object produto.
	 * 
	 * @param uploadedFile imagem informada na tela de produtos.
	 * @param produto produto informado na tela de produtos.
	 */
	public void convertePartToByte(Part uploadedFile, Produto produto) {
		try {
			if (uploadedFile == null) {
				return;
			}

			InputStream is = uploadedFile.getInputStream();
			byte[] bytes = IOUtils.toByteArray(is);
			produto.setImagem(bytes);
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}
	}

	/**
	 * Busca os produtos por Código e Descrição.
	 * 
	 * @param value valor informado na pesquisa.
	 * @return Produtos encontrado na pesquisa com o valor igual a value.
	 */
	@SuppressWarnings("unchecked")
	public List<Produto> buscaProduto(String value) {
		String jpql = "";
		Query query = null;
		List<Produto> produtos = null;

		if (value.replaceAll("\\D", "") != "") {
			jpql = "select p from Produto p where p.id = :id";
			query = JpaUtil.getEntityManager().createQuery(jpql, Produto.class);
			query.setParameter("id", new Long(value.replaceAll("\\D", "")));
			produtos = query.getResultList();
		}

		if (value != "") {
			jpql = "select p from Produto p where Produto.descricao like %:descricao%";
			query = JpaUtil.getEntityManager().createQuery(jpql, Produto.class);
			query.setParameter("descricao", value);
			produtos = query.getResultList();
		}

		return produtos;
	}
}
