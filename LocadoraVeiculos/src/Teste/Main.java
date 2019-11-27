package Teste;

import BancodeDados.Conexao;
import Dados.RepositorioVeiculo;
import Entidades.Veiculo;

public class Main {

	public static void main(String[] args) {
		
		RepositorioVeiculo  repositorio = new RepositorioVeiculo();
		
		Veiculo veiculo = new Veiculo("PDA-0715", "Nissan", "HB20", "Branco", 2015, 200000.0);
		
		Conexao.getInstance().conectar();
		repositorio.inserirVeiculo(veiculo);
		Conexao.getInstance().desconectar();
		
		
		
		
	}

}
