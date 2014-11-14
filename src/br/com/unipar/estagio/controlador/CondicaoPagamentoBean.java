package br.com.unipar.estagio.controlador;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.unipar.estagio.dao.CondicaoPagamentoDao;
import br.com.unipar.estagio.entidades.CondicoesPagamento;
import br.com.unipar.estagio.utils.Constantes;

/**
 * @author Juliano Ramos
 */
@ManagedBean
@SessionScoped
public class CondicaoPagamentoBean implements Serializable {

	/**
	 * Serial Version ID CondicaoPagamentoBean.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Classe que possui as regras de negocio do Cliente.
	 */
	private CondicaoPagamentoDao condicaoPagamentoDao;

	/**
	 * Condi��o de Pagamento selecionado ou que est� em edi��o na tela de Condi��o de Pagamento.
	 */
	private CondicoesPagamento condicaoPagamento;

	/**
	 * Construtor.
	 */
	public CondicaoPagamentoBean() {
		this.condicaoPagamentoDao = new CondicaoPagamentoDao();
		this.condicaoPagamento = new CondicoesPagamento();
	}

	/**
	 * Salva a condi��o de pagamento do banco de dados.
	 */
	public void salvar() {
		this.condicaoPagamentoDao.salvar(condicaoPagamento);
		this.condicaoPagamento = new CondicoesPagamento();
	}

	/**
	 * Limpa condi��o de pagamento da tela.
	 */
	public void cancelar() {
		this.condicaoPagamento = new CondicoesPagamento();
	}

	public Boolean isAvista() {
		return Constantes.C_CONDICAOPAGAMENTO_AVISTA.equals(this.condicaoPagamento.getTipo());
	}

	public CondicaoPagamentoDao getCondicaoPagamentoDao() {
		return condicaoPagamentoDao;
	}

	public void setCondicaoPagamentoDao(CondicaoPagamentoDao condicaoPagamentoDao) {
		this.condicaoPagamentoDao = condicaoPagamentoDao;
	}

	public CondicoesPagamento getCondicaoPagamento() {
		return condicaoPagamento;
	}

	public void setCondicaoPagamento(CondicoesPagamento condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}
}
