package Util;

public class ItensLocados {
	private Data dataLocado;
	private Data dataDevolucao;
	private String placaVeiculo;
	
	public ItensLocados(Data dataLocado, Data dataDevolucao, String placaVeiculo) {
		this.dataLocado = dataLocado;
		this.dataDevolucao = dataDevolucao;
		this.placaVeiculo = placaVeiculo;

	}
	public Data getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Data dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}
	public Data getDataLocado() {
		return dataLocado;
	}
	public void setDataLocado(Data dataLocado) {
		this.dataLocado = dataLocado;
	}
}
