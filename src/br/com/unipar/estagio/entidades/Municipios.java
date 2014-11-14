package br.com.unipar.estagio.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Juliano Ramos
 */
@Entity
public class Municipios implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(nullable = false, length = 60)
	private String descricao;
	@ManyToOne
	private Estados estado;
	@OneToMany(mappedBy = "municipio")
	private List<Enderecos> enderecos;

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

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	public List<Enderecos> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Enderecos> enderecos) {
		this.enderecos = enderecos;
	}
}
