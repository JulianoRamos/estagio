package br.com.unipar.estagio.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author Juliano Ramos
 */
@Entity
public class Enderecos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(nullable = false, length = 8)
	private String cep;
	@Column(nullable = false, length = 60)
	private String descricao;
	@Column(nullable = false, length = 60)
	private String descricaoBairro;
	@Column(nullable = false)
	private Integer numero;
	@Column(nullable = false, length = 60)
	private String complemento;
	@ManyToOne
	private Municipios municipio;
	@OneToOne
	private Cliente cliente;
	@ManyToMany
	private List<Movimentos> movimentos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricaoBairro() {
		return descricaoBairro;
	}

	public void setDescricaoBairro(String descricaoBairro) {
		this.descricaoBairro = descricaoBairro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Municipios getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipios municipio) {
		this.municipio = municipio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Movimentos> getMovimentos() {
		return movimentos;
	}

	public void setMovimentos(List<Movimentos> movimentos) {
		this.movimentos = movimentos;
	}
}
