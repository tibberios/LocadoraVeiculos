package Entidades;

public class Locacao {
	private String clienteCPF;
	private double valorTotal;
	private String data_devolucao;
	private String data_locacao;
	private String veiculoPlaca;
	
	public Locacao(String clienteCPF, String veiculoPlaca, double valorTotal, String data_devolucao) {
		this.setClienteCPF(clienteCPF);
		this.setValorTotal(valorTotal);
		this.setData_devolucao(data_devolucao);
		this.setVeiculoPlaca(veiculoPlaca);
	}

	public Locacao(String clienteCPF, String veiculoPlaca, double valorTotal, String data_locacao, String data_devolucao) {
		this.setClienteCPF(clienteCPF);
		this.setValorTotal(valorTotal);
		this.setData_devolucao(data_devolucao);
		this.setVeiculoPlaca(veiculoPlaca);
		this.setData_locacao(data_locacao);
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getClienteCPF() {
		return clienteCPF;
	}

	public void setClienteCPF(String clienteCPF) {
		this.clienteCPF = clienteCPF;
	}

	public String getData_devolucao() {
		return data_devolucao;
	}

	public void setData_devolucao(String data_devolucao) {
		this.data_devolucao = data_devolucao;
	}

	public String getVeiculoPlaca() {
		return veiculoPlaca;
	}

	public void setVeiculoPlaca(String veiculoPlaca) {
		this.veiculoPlaca = veiculoPlaca;
	}

	public String getData_locacao() {
		return data_locacao;
	}

	public void setData_locacao(String data_locacao) {
		this.data_locacao = data_locacao;
	}

}
