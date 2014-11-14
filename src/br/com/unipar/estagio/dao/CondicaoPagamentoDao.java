package br.com.unipar.estagio.dao;

import br.com.unipar.estagio.entidades.CondicoesPagamento;
import br.com.unipar.estagio.persistencia.JpaUtil;

/**
 * @author Juliano.Ramos
 */
public class CondicaoPagamentoDao {

	/**
	 * Salva condicao de pagamento no banco de dados.
	 * 
	 * @param condicaoPagamento da tela de cadastro de condicao de pagamento.
	 */
	public void salvar(CondicoesPagamento condicaoPagamento) {
		JpaUtil.getEntityManager().persist(condicaoPagamento);
	}
}
