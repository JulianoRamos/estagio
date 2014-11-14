package br.com.unipar.estagio.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(length = 11)
	private String cpf;
	@Column(length = 14)
	private String cnpj;
	@Column(length = 20)
	private String inscricaoEstadual;
	@Column(nullable = false, length = 60)
	private String razaoSocial;
	@Column(length = 60)
	private String nomeFantasia;
	@Column(nullable = false, length = 20)
	private String telefone;
	@Column(length = 11)
	private String celular;
	@Column(nullable = false, length = 60)
	private String email;
	@Column(length = 100)
	private String observacao;
	@OneToOne
	private Usuario usuario;
	@OneToOne
	private CondicoesPagamento condicoesPagamento;
	@OneToOne(mappedBy = "cliente")
	private Enderecos enderecos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public CondicoesPagamento getCondicoesPagamento() {
		return condicoesPagamento;
	}

	public void setCondicoesPagamento(CondicoesPagamento condicoesPagamento) {
		this.condicoesPagamento = condicoesPagamento;
	}

	public Enderecos getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Enderecos enderecos) {
		this.enderecos = enderecos;
	}
}
