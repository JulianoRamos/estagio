package br.com.unipar.estagio.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author Juliano Ramos
 */
@Entity
public class MovimentosItens implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(nullable = false)
	private Integer quantidade;
	@Column(precision = 11, scale = 2, nullable = false)
	private BigDecimal valorDesconto;
	@Column(precision = 11, scale = 2, nullable = false)
	private BigDecimal valorLiquido;
	@Column(precision = 11, scale = 2, nullable = false)
	private BigDecimal valorBruto;
	@OneToOne
	private Produto produto;
	@ManyToOne
	private Movimentos movimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(BigDecimal valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public BigDecimal getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(BigDecimal valorBruto) {
		this.valorBruto = valorBruto;
	}

	public Movimentos getMovimento() {
		return movimento;
	}

	public void setMovimento(Movimentos movimento) {
		this.movimento = movimento;
	}
}
