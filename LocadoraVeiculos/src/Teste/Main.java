package Teste;

import BancodeDados.Conexao;
import Dados.RepositorioFuncionario;
import Dados.RepositorioVeiculo;
import Entidades.Funcionario;
import Entidades.Veiculo;

public class Main {

	public static void main(String[] args) {
		RepositorioFuncionario funcionario = new RepositorioFuncionario();

		Conexao.getInstance().conectar();
		Funcionario f = new Funcionario ("Funcionario Teste", "70614897401", "123456", "819985959221", "teste@teste.com", 1, 2);
		funcionario.inserirFuncionario(f);
		Conexao.getInstance().desconectar();
	}

}
