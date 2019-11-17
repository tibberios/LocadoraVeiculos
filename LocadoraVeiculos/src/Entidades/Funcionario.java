package Entidades;

import Util.Pessoa;

public class Funcionario extends Pessoa {
	private boolean status;

	public Funcionario (String nome, String cpf, String senha, String telefone) {
		super (nome, cpf, senha, telefone);
		this.setStatus(true);
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
}
