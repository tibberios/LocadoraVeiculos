package Negocio;

import Dados.RepositorioCliente;
import Entidades.Cliente;

public class ControleCliente {
	private RepositorioCliente repositorio;
	Cliente Cliente;

	public ControleCliente() {
		repositorio = new RepositorioCliente();
	}

	public void inserirCliente(String nome, String cpf, String telefone) {
		Cliente = new Cliente(nome, cpf, telefone, 1);	
		repositorio.inserirCliente(Cliente);
	}
}
