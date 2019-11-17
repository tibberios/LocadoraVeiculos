package Entidades;

import Util.ItensLocados;

public class Locacao {
	private String clienteCPF;
	private float valorTotal;
	private ItensLocados [] veiculosLocados ;


	public Locacao(String clienteCPF) {
		this.setClienteCPF(clienteCPF);
		this.veiculosLocados = new ItensLocados[5];
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public ItensLocados [] getVeiculosLocados() {
		return veiculosLocados;
	}

	public void setVeiculosLocados(ItensLocados [] veiculosLocados) {
		this.veiculosLocados = veiculosLocados;
	}

	public String getClienteCPF() {
		return clienteCPF;
	}

	public void setClienteCPF(String clienteCPF) {
		this.clienteCPF = clienteCPF;
	}

}
