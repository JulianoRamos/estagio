package br.com.unipar.estagio.entidades;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

/**
 * @author Juliano Ramos
 */
@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(nullable = false, length = 60)
	private String descricao;
	@Column(nullable = false, length = 4)
	private String tamanho;
	@Column(nullable = false, length = 10)
	private String cor;
	@Column(nullable = false, length = 1)
	private String sexo;
	@Column(precision = 11, scale = 2, nullable = false)
	private BigDecimal valorCusto;
	@Column(precision = 11, scale = 2, nullable = false)
	private BigDecimal valorVenda;
	@Lob
	private byte[] imagem;
	@OneToMany(mappedBy = "produto")
	private List<MovimentosItens> movimentosItens;

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

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public BigDecimal getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(BigDecimal valorCusto) {
		this.valorCusto = valorCusto;
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public List<MovimentosItens> getMovimentosItens() {
		return movimentosItens;
	}

	public void setMovimentosItens(List<MovimentosItens> movimentosItens) {
		this.movimentosItens = movimentosItens;
	}

}
