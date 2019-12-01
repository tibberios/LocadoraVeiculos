package Negocio;

import Dados.RepositorioLocacao;
import Entidades.Locacao;

public class ControleLocacao {
	private RepositorioLocacao repositorio;
	private Locacao locacao;
	
	public RepositorioLocacao getRepositorio() {
		return repositorio;
	}
	
	public void setRepositorio(RepositorioLocacao repositorio) {
		this.repositorio = repositorio;
	}
	
	public Locacao getLocacao() {
		return locacao;
	}
	
	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}
	
	public void inserirLocacao(String clienteCPF, String veiculoPlaca, double valorTotal, String data_devolucao) {
		this.locacao = new Locacao(clienteCPF, veiculoPlaca, valorTotal, data_devolucao);
		this.repositorio.inserirLocacao(locacao);
	}
	
	public void encontrarLocacao(String clienteCPF, String veiculoPlaca) {
		this.repositorio.encontrarLocacao(clienteCPF, veiculoPlaca);
	}
	
	public void atualizarLocacao(String clienteCPF, String veiculoPlaca, double valorTotal, String data_devolucao) {
		this.repositorio.atualizarLocacao(clienteCPF, veiculoPlaca, valorTotal, data_devolucao);
	}
	
	public void encontrarTodasLocacoes() {
		this.repositorio.encontrarTodasLocacoes();
	}
	
}
