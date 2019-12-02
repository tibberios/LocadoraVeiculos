package Negocio;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Dados.RepositorioVeiculo;
import Entidades.Veiculo;
import Excecoes.PlacaExisteExeception;


public class ControleVeiculo {
	static Calendar cal = GregorianCalendar.getInstance(); 
	Veiculo veiculo;
	private RepositorioVeiculo rv;
	public ControleVeiculo() {
		rv = new RepositorioVeiculo();	
	}
	
	
	
	
	public RepositorioVeiculo getRv() {
		return rv;
	}




	public void setRv(RepositorioVeiculo rv) {
		this.rv = rv;
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


	public void inserir(String placa , String marca , String modelo , String cor , int ano , double preco, int km_rodados) throws PlacaExisteExeception {
		boolean aux = validarDados( placa ,  marca ,  modelo , cor , ano ,  preco);
		if(aux == true) {
			rv.inserirVeiculo(veiculo =  new Veiculo(placa, marca, modelo, cor, ano, preco,km_rodados,1));
		}else {
			JOptionPane.showMessageDialog(null, "Erro Ao Inserir Veiculo");
		}

	}
	
	public void remove(String placa) {
		System.out.println(2);
		this.rv.remove(placa);
	}

	public void atualizar(String placa , String marca , String modelo , String cor , int ano , double preco, int km_rodados) {
		rv.update(placa, marca, modelo, cor, km_rodados, ano, preco);
	}

	public boolean validarDados(String placa , String marca , String modelo , String cor , int ano , double preco) {
		boolean retornar = false;
		if(placa!=null && !placa.trim().equals("")) {
			retornar = this.ValidarPlaca(placa);
			if (retornar == false) {
				return false;
			}
		}

		if(marca != null && placa.trim().equals("")) {
			retornar = this.ValidarMarca(marca);
			if (retornar == false) {
				return false;
			}
		}

		if(modelo != null && modelo.trim().equals("")) {
			retornar = this.ValidarModelo(modelo);
			if (retornar == false) {
				return false;
			}
		}

		if(cor != null && cor.trim().equals("")) {
			retornar = this.ValidarCor(cor);
			if (retornar == false) {
				return false;
			}
		}

		if(ano != 0) {
			retornar = this.ValidarAno(ano);
			if (retornar == false) {
				return false;
			}
		}

		if(preco !=0) {
			retornar = this.ValidarPreco(preco);
			if (retornar == false) {
				return false;
			}
		}

		return retornar;
	}

}
