package br.com.unipar.estagio.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Juliano Ramos
 */
@Entity
public class Movimentos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(nullable = false, length = 1)
	private String tipoMovimento;
	@Column(nullable = false, length = 1)
	private String tipoLancamento;
	@Column(nullable = false)
	private Integer quantidadeTotalItens;
	@Column(precision = 11, scale = 2, nullable = false)
	private BigDecimal valorTotalLiquido;
	@Column(precision = 11, scale = 2, nullable = false)
	private BigDecimal valorTotalBruto;
	@Column(precision = 11, scale = 2, nullable = false)
	private BigDecimal valorTotalDesconto;
	@Column(nullable = false, length = 60)
	private String observacao;
	@ManyToOne
	private CondicoesPagamento condicoesPagamento;
	@OneToMany(mappedBy = "movimento")
	private List<MovimentosItens> movimentosItens;
	@ManyToMany(mappedBy = "movimentos")
	private List<Enderecos> enderecos;

	public List<Enderecos> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Enderecos> enderecos) {
		this.enderecos = enderecos;
	}
}
