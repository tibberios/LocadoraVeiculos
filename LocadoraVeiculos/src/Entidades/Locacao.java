package Entidades;

public class Locacao {
	private String clienteCPF;
	private float valorTotal;
	private String data_devolucao;
	private String veiculoPlaca;
	
	public Locacao(String clienteCPF, float valorTotal, String data_devolucao, String veiculoPlaca) {
		this.setClienteCPF(clienteCPF);
		this.setValorTotal(valorTotal);
		this.setData_devolucao(data_devolucao);
		this.setVeiculoPlaca(veiculoPlaca);
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
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

}
