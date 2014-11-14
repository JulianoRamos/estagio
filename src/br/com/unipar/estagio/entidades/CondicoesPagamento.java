package br.com.unipar.estagio.entidades;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Juliano.Ramos
 */
@Entity
public class CondicoesPagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(nullable = false)
	private String descricao;
	@Column(nullable = false, length = 1)
	private String tipo;
	private Integer quantidadeParcelas;
	private Integer intervaloDiasVencimento;
	private int numeroDias;
	@Column(nullable = false)
	private BigDecimal porcentagemDesconto;
	@OneToMany(mappedBy = "condicoesPagamento")
	private List<Cliente> clientes;
	@OneToMany(mappedBy = "condicoesPagamento")
	private List<Movimentos> movimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getQuantidadeParcelas() {
		return quantidadeParcelas;
	}

	public void setQuantidadeParcelas(Integer quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}

	public Integer getIntervaloDiasVencimento() {
		return intervaloDiasVencimento;
	}

	public void setIntervaloDiasVencimento(Integer intervaloDiasVencimento) {
		this.intervaloDiasVencimento = intervaloDiasVencimento;
	}

	public int getNumeroDias() {
		return numeroDias;
	}

	public void setNumeroDias(int numeroDias) {
		this.numeroDias = numeroDias;
	}

	public BigDecimal getPorcentagemDesconto() {
		return porcentagemDesconto;
	}

	public void setPorcentagemDesconto(BigDecimal porcentagemDesconto) {
		this.porcentagemDesconto = porcentagemDesconto;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Movimentos> getMovimento() {
		return movimento;
	}

	public void setMovimento(List<Movimentos> movimento) {
		this.movimento = movimento;
	}
}
