package Entidades;

public class Veiculo {
	private String placa;
	private String marca;
	private String modelo;
	private String cor;
	private int km_rodados;
	private int ano;
	private double preco;
	private boolean Status;


	public Veiculo(String placa , String marca , String modelo , String cor , int ano , double preco ){
		this.placa = placa;
		this.cor = cor;
		this.modelo = modelo;
		this.km_rodados = 0;
		this.marca = marca;
		this.ano = ano;
		this.preco = preco;
		this.setStatus(true);

	}
	public String getPlaca() {
		return placa;
	}

	public String getCor() {
		return cor;
	}

	public int getKilometragem() {
		return km_rodados;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void setKilometragem(int km_rodados) {
		this.km_rodados = km_rodados;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}
	
	public int getAno() {
		return ano;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public int compareTo(Veiculo o) {
		if(this.ano < o.getAno()) {
			return -1;
		}else if(this.ano > o.getAno()) {
			return 1;
		}
		return 0 ; 
	}
	
	public boolean isStatus() {
		return Status;
	}
	
	public void setStatus(boolean status) {
		Status = status;
	}
}
