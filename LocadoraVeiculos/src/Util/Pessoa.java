package Util;

public class Pessoa {
	private String cpf;
	private String nome;
	private String telefone;

	public Pessoa (String nome, String cpf, String telefone) {
		this.setNome(nome);
		this.setCpf(cpf);		
		this.setTelefone(telefone);
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
}
