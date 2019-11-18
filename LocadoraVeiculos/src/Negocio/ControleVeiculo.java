package Negocio;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import Dados.RepositorioVeiculo;
import Entidades.Veiculo;


public class ControleVeiculo {
	
	private RepositorioVeiculo repositorio;
	Veiculo veiculo;

	public ControleVeiculo() {
		
		repositorio = new RepositorioVeiculo();
		
	}
	public void inserirVeiculo(String placa , String marca , String modelo , String cor , int ano , double preco) {
		veiculo = new Veiculo(placa,marca,modelo,cor,ano,preco);
		repositorio.inserirVeiculo(veiculo);
	}

}
