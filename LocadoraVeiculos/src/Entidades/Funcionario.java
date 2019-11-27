package Entidades;

import Util.Pessoa;

public class Funcionario extends Pessoa {
	private int status;
	private String email;
	private int tipo;
	private String senha;
	
	public Funcionario (String nome, String cpf, String senha, String telefone, String email, int status, int tipo) {
		super (nome, cpf, telefone);
		this.setEmail(email);
		this.setStatus(status);
		this.setTipo(tipo);
		this.setSenha(senha);
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
