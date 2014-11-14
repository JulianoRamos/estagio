package br.com.unipar.estagio.controlador;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import br.com.unipar.estagio.dao.ClienteDao;
import br.com.unipar.estagio.entidades.Cliente;
import br.com.unipar.estagio.entidades.CondicoesPagamento;
import br.com.unipar.estagio.entidades.Enderecos;
import br.com.unipar.estagio.entidades.Estados;
import br.com.unipar.estagio.entidades.Municipios;
import br.com.unipar.estagio.entidades.Usuario;

/**
 * @author Juliano Ramos
 */
@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable {

	/**
	 * Serial Version ID Cliente Bean.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Cliente selecionado ou que está em edição na tela de Clientes.
	 */
	private Cliente cliente;
	/**
	 * Lista de estados.
	 */
	private List<Estados> estados;
	/**
	 * Estado selecionado na tela de Cliente.
	 */
	private Estados estadoSelecionado;
	/**
	 * Lista de municipios.
	 */
	private Municipios municipioSelecionado;
	private List<Municipios> municipios;
	/**
	 * Classe que possui as regras de negocio do Cliente.
	 */
	private ClienteDao clienteDao;

	/**
	 * Construtor.
	 */
	public ClienteBean() {
		clienteDao = new ClienteDao();
		criaCliente();
		this.estados = clienteDao.buscaEstados();
	}

	/**
	 * Salva o Cliente no banco de dados.
	 */
	public void salvar() {
		clienteDao.salvar(cliente);
		criaCliente();
	}

	/**
	 * Limpa os campos da tela de cliente.
	 */
	public void cancelar() {
		criaCliente();
	}

	/**
	 * Instancia o Cliente e seu Endereço, Condição de Pagamento e Usuario.
	 */
	private void criaCliente() {
		this.cliente = new Cliente();
		this.cliente.setEnderecos(new Enderecos());
		this.cliente.setCondicoesPagamento(new CondicoesPagamento());
		this.cliente.setUsuario(new Usuario());
	}

	/**
	 * Carrega os municipios do estado selecionado.
	 * 
	 * @return Municipios.
	 */
	public List<Municipios> carregaMunicipios() {
		return null;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Municipios getMunicipioSelecionado() {
		return this.municipioSelecionado;
	}

	public void setMunicipioSelecionado(Municipios municipioSelecionado) {
		this.municipioSelecionado = municipioSelecionado;
	}

	public List<Estados> getEstados() {
		return estados;
	}

	public void setEstados(List<Estados> estados) {
		this.estados = estados;
	}

	public Estados getEstadoSelecionado() {
		return estadoSelecionado;
	}

	public void setEstadoSelecionado(Estados estadoSelecionado) {
		this.estadoSelecionado = estadoSelecionado;
	}

	public List<Municipios> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipios> municipios) {
		this.municipios = municipios;
	}

}
