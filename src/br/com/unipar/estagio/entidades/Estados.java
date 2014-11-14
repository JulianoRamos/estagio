package br.com.unipar.estagio.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Juliano Ramos
 */
@Entity
public class Estados implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(nullable = false, length = 60)
	private String descricao;
	@Column(nullable = false, length = 2)
	private String sigla;
	@OneToMany(mappedBy = "estado")
	private List<Municipios> municipios;

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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Municipios> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipios> municipios) {
		this.municipios = municipios;
	}
}
