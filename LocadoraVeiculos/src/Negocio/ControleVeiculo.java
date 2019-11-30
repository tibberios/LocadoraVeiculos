package Negocio;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Entidades.Veiculo;


public class ControleVeiculo {
	static Calendar cal = GregorianCalendar.getInstance(); 
	Veiculo veiculo;

	public ControleVeiculo() {
		

	}
	//placa deve estar no padrao
	public boolean ValidarPlaca(String placa) {
		int fim=0;
		Pattern pattern = Pattern.compile("[a-zA-Z]{3}-?[0-9]{4}");
		Matcher matcher = pattern.matcher(placa);
		if(matcher.find()){
			fim = matcher.end();
		}
		if(fim==8){
			return true;			
		}
		return false;
	}

	public boolean ValidarMarca(String marca) {
		int fim=0;
		Pattern pattern = Pattern.compile("[a-zA-Z]");
		Matcher matcher = pattern.matcher(marca);
		if(matcher.find()){
			fim = matcher.end();
			return true;
		}
		return false;
	}
	
	public boolean ValidarModelo(String modelo) {
		int fim=0;
		Pattern pattern = Pattern.compile("[a-zA-Z]");
		Matcher matcher = pattern.matcher(modelo);
		if(matcher.find()){
			fim = matcher.end();
			return true;
		}
		return false;
	}


	public boolean  ValidarAno(int ano) {
		if(ano <= cal.get(Calendar.YEAR)){
			return true;
		}
		return false;
	}

	//verifica se cor é string //
	public boolean ValidarCor(String cor) {
		int fim=0;
		Pattern pattern = Pattern.compile("[a-zA-Z]");
		Matcher matcher = pattern.matcher(cor);
		if(matcher.find()){
			fim = matcher.end();
			return true;
		}
		return false;			

	}

	public boolean  ValidarPreco(double preco) {
		if(preco >0) {
			return true;
		}
		return false;
	}
	
	

	public boolean inserirVeiculo(String placa , String marca , String modelo , String cor , int ano , double preco) {
		boolean retornar = false;
		if(placa!=null && placa.trim().equals("")) {
			retornar = this.ValidarPlaca(placa);
		}

		if(marca != null && placa.trim().equals("")) {
			retornar = this.ValidarMarca(marca);
		}
		
		if(modelo != null && modelo.trim().equals("")) {
			retornar = this.ValidarModelo(modelo);
			
		}
		
		if(cor != null && cor.trim().equals("")) {
			retornar = this.ValidarCor(cor);
		}
		
		if(ano != 0) {
			retornar = this.ValidarAno(ano);
		}
		
		if(preco !=0) {
			retornar = this.ValidarPreco(preco);
		}
		
		return retornar;
	}

}
