package Negocio;

import Dados.RepositorioCliente;
import Entidades.Cliente;

public class ControleCliente  {
	private RepositorioCliente repositorio;
	Cliente Cliente;

	public ControleCliente() {
		repositorio = new RepositorioCliente();
	}

	public void inserirCliente(String nome, String cpf, String telefone) {
		Cliente = new Cliente(nome, cpf, telefone, 1);	
		repositorio.inserirCliente(Cliente);
	}
	
	public void atualizarCliente(String nome, String cpf, String telefone)  {
		repositorio.update(cpf, nome, telefone);
	}
	
	public void removerCliente(String cpf) {
		repositorio.remove(cpf);
	}
	
	public void getAllClientes() {
		repositorio.getAll();
	}

	public void findByName(String nome) {
		repositorio.findByName(nome);
	}
	
	public RepositorioCliente getRepositorio() {
		return this.repositorio;
	}
}
