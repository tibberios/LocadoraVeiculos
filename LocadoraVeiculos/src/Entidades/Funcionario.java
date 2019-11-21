package Entidades;

import Util.Pessoa;

public class Funcionario extends Pessoa {
	private boolean status;
	private String email;

	public Funcionario (String nome, String cpf, String senha, String telefone, String email) {
		super (nome, cpf, senha, telefone);
		this.setEmail(email);
		this.setStatus(true);
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
