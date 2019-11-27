package Entidades;

import java.io.Serializable;

import Util.Pessoa;

public class Cliente extends Pessoa implements Serializable{
	private int status;

	public Cliente(String nome, String cpf, String telefone, int ativo) {
		super(nome, cpf, telefone);
		this.status = ativo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
