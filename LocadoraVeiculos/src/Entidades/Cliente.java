package Entidades;

import java.io.Serializable;

import Util.Pessoa;

public class Cliente extends Pessoa implements Serializable{
	private String status = "Ativo";

	public Cliente(String nome, String cpf, String senha , String telefone) {
		super(nome, cpf, senha ,telefone);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
