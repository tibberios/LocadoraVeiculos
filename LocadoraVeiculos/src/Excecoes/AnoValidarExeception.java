package Excecoes;

@SuppressWarnings("serial")
public class AnoValidarExeception extends Exception {

	private int ano;

	public AnoValidarExeception(int ano) {
		this.setAno(ano);
	}
	public String toString() {
		return "Ano Deve Ser Menor ou Igual ao Atual";
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

}
