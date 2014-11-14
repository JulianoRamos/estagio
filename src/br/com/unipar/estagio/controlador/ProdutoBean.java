package br.com.unipar.estagio.controlador;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.unipar.estagio.dao.ProdutoDao;
import br.com.unipar.estagio.entidades.Produto;

/**
 * @author Juliano Ramos
 */
@ManagedBean
@SessionScoped
public class ProdutoBean implements Serializable {

	/**
	 * Serial Version ID Produto Bean.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Imagem selecionada no inputFile da tela de Produtos.
	 */
	private Part uploadedFile;
	/**
	 * Produto selecionado ou que está em edição na tela de Produtos.
	 */
	private Produto produto;
	/**
	 * Imagem selecionada no graphicImage da tela de Produtos.
	 */
	private StreamedContent imagem;
	/**
	 * Código ou Descrição informada no campo de Busca da tela de Produtos.
	 */
	private String value;
	/**
	 * Produtos retornados no metodo buscaProduto.
	 */
	private List<Produto> produtos;
	/**
	 * Classe que possui as regras de negocio do produto.
	 */
	private ProdutoDao produtoDao;

	/**
	 * Construtor.
	 */
	public ProdutoBean() {
		this.produtoDao = new ProdutoDao();
		this.produto = new Produto();
		this.imagem = null;
		this.uploadedFile = null;
		this.value = "";
		this.produtos = new ArrayList<Produto>();
	}

	/**
	 * Persiste o Produto no banco de dados juntamente da imagem selecionada após conversão.
	 */
	public void salvar() {
		produtoDao.convertePartToByte(uploadedFile, produto);
		produtoDao.salvar(produto);
		produto = new Produto();
	}

	/**
	 * Limpa campos da Tela instanciando novamente o objeto Produto.
	 */
	public void cancelar() {
		produto = new Produto();
	}

	/**
	 * Carrega a imagem selecionada no inputFile para o graphicImage da tela de Produtos.
	 */
	public void carregarImagem() {
		try {
			InputStream is = uploadedFile.getInputStream();
			byte[] bytes = IOUtils.toByteArray(is);
			this.imagem = new DefaultStreamedContent(new ByteArrayInputStream(bytes));
		} catch (IOException e) {
			this.imagem = null;
		}
	}

	public Part getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	/**
	 * Se tiver imagem carregada no Objeto Produto irá carregar ela na tela.
	 * 
	 * @return Imagem.
	 */
	public StreamedContent getImagem() {
		if ((produto != null) && (produto.getImagem() != null)) {
			imagem = new DefaultStreamedContent(new ByteArrayInputStream(produto.getImagem()));
		}

		return imagem;
	}

	public void setImagem(StreamedContent imagem) {
		this.imagem = imagem;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
