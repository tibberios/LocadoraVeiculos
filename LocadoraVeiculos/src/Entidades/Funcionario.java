package Entidades;

import Util.Pessoa;

public class Funcionario extends Pessoa {
	private int status;
	private String email;
	private int tipo;
	
	public Funcionario (String nome, String cpf, String senha, String telefone, String email, int status, int tipo) {
		super (nome, cpf, senha, telefone);
		this.setEmail(email);
		if (status != 0) {
			this.setStatus(status);
		}
		
		if (tipo != 0) {
			this.setTipo(tipo);
		}
	}
	
	public int isStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
}
