package Excecoes;

@SuppressWarnings("serial")
public class PlacaValidacaoExeception extends Exception	{

	private String placa;

	public PlacaValidacaoExeception(String placa) {
		this.setPlaca(placa);
	}
	public String toString() {
		return "Placa -> \" + placa + \" : não Valida";
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}

}
