package Negocio;

import Dados.RepositorioFuncionario;
import Entidades.Funcionario;
import Excecoes.FormatoDadosException;

public class ControleFuncionario extends ControlePessoa {
	private RepositorioFuncionario repositorio;
	Funcionario funcionario;

	
	
	public RepositorioFuncionario getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(RepositorioFuncionario repositorio) {
		this.repositorio = repositorio;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public ControleFuncionario() {
		repositorio = new RepositorioFuncionario();
	}

	public void inserirFuncionario(String nome, String cpf, String senha, String telefone, String email) throws FormatoDadosException {	
		funcionario = new Funcionario(nome, cpf, senha, telefone, email, 1, 2);	
		repositorio.inserirFuncionario(funcionario);
	}

	public void atualizarFuncionario(String cpf, String nome, String senha, String telefone, String email)  {
		repositorio.update(cpf, nome, senha, telefone, email);
	}
	
	public void removerFuncionario(String cpf) {
		repositorio.remove(cpf);
	}
	
	public void getAllFuncionarios() {
		repositorio.getAll();
	}

	public void findByName(String nome) {
		repositorio.findByName(nome);
	}
}
