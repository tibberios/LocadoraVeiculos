package Excecoes;

@SuppressWarnings("serial")
public class PlacaExisteExeception extends Exception {
	private String placa;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String toString() {
		return "Placa -> " + placa + " : Já Cadastrada";
	}
	public PlacaExisteExeception(String placa) {
		this.setPlaca(placa);
	}
}
