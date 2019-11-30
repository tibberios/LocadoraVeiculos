package Excecoes;

@SuppressWarnings("serial")
public class PrecoValidarException extends Exception {

	private double preco;

	public PrecoValidarException(int preco) {
		this.setPreco(preco);
		
	}
	
	public String toString() {
		
		return "preço deve ser superior a 0";
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}






}
