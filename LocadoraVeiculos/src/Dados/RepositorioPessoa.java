package Dados;

import java.util.ArrayList;

import Util.Pessoa;

public class RepositorioPessoa {
	private ArrayList<Pessoa> pessoa;

	public RepositorioPessoa() {
		pessoa = new ArrayList<Pessoa>();
	}

	public boolean verificarSeExiste(Pessoa pessoa) {
		if (this.pessoa.contains(pessoa)) {
			return true;
		}
		return false;
	}

	public void inserirPessoa(Pessoa pessoa) {
		this.pessoa.add(pessoa);
	}
}
