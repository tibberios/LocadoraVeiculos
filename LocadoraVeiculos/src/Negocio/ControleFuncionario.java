package Negocio;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import Dados.RepositorioFuncionario;
import Entidades.Funcionario;

public class ControleFuncionario {
	private RepositorioFuncionario repositorio;
	Funcionario funcionario;

	public ControleFuncionario() {
		repositorio = new RepositorioFuncionario();
	}

	public void inserirFuncionario(String nome, String cpf, String senha, String telefone, String email) {
		funcionario = new Funcionario(nome, cpf, senha, telefone, email, 1, 2);	
		repositorio.inserirFuncionario(funcionario);
	}	
}
