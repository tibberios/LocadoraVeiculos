package Negocio;

import Dados.RepositorioFuncionario;
import Entidades.Funcionario;
import Excecoes.FormatoDadosException;

public class ControleFuncionario extends ControlePessoa {
	private RepositorioFuncionario repositorio;
	Funcionario funcionario;

	public ControleFuncionario() {
		repositorio = new RepositorioFuncionario();
	}

	public void inserirFuncionario(String nome, String cpf, String senha, String telefone, String email) throws FormatoDadosException {
		
		if(validarDadosPessoa(nome,cpf,senha,telefone,email) == true) {
			funcionario = new Funcionario(nome, cpf, senha, telefone, email, 1, 2);	
			repositorio.inserirFuncionario(funcionario);
		}else {
			throw new FormatoDadosException();
		}
			
	
	}	
}
