package Negocio;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Dados.RepositorioVeiculo;
import Entidades.Veiculo;


public class ControleVeiculo {
	static Calendar cal = GregorianCalendar.getInstance(); 
	private RepositorioVeiculo repositorio;
	Veiculo veiculo;

	public ControleVeiculo() {
		repositorio = new RepositorioVeiculo();


	}
	//placa deve estar no padrao
	public static int ValidarPlaca(String placa) {
		int fim=0;
		Pattern pattern = Pattern.compile("[a-zA-Z]{3}-?[0-9]{4}");
		Matcher matcher = pattern.matcher(placa);
		if(matcher.find()){
			fim = matcher.end();
		}
		if(fim==8){
			return 0;			
		}
		return 1;

	}

	public static int ValidarAno(int ano) {
		if(ano <= cal.get(Calendar.YEAR)){
			return 1;
		}
		return 0;
	}
	
	
	
	
	


public void inserirVeiculo(String placa , String marca , String modelo , String cor , int ano , double preco) {
	
	// ifs 
	
	veiculo = new Veiculo(placa,marca,modelo,cor,ano,preco);
	repositorio.inserirVeiculo(veiculo);
}

}
