package Fachada;

import javax.swing.JOptionPane;

import Excecoes.FormatoDadosException;
import Negocio.ControleCliente;
import Negocio.ControleFuncionario;
import Negocio.ControlePessoa;

public class Fachada {
	private ControlePessoa pessoa;     
	private ControleFuncionario funcionario;
	private ControleCliente cliente;

	static Fachada instance;

	public Fachada() {
		pessoa = new ControlePessoa();
		funcionario = new ControleFuncionario();
		cliente = new ControleCliente();
	}

	public static Fachada getInstance() {
		if (Fachada.instance == null) {
			return Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}

	public void inserirPessoa (String nome, String cpf, String senha, String telefone, String email, String tipo_de_insercao) throws FormatoDadosException {
		if (tipo_de_insercao.equals("inserir")) {
			if (email != null || !email.isEmpty() && !email.equals("cliente")) {
				boolean inserido = this.pessoa.validarDadosPessoa(nome, cpf, senha, telefone, email);
				if (inserido == true) {
					this.funcionario.inserirFuncionario(nome, cpf, senha, telefone, email);
				} else {
					throw new FormatoDadosException();
				}
			} else {
				boolean inserido = this.pessoa.validarDadosPessoa(nome, cpf, null, telefone, null);
				if (inserido == true) {
					this.cliente.inserirCliente(nome, cpf, telefone);
				} else {
					throw new FormatoDadosException();
				}
			}
		} else if (tipo_de_insercao.equals("atualizar")) {
			if (email != null || !email.isEmpty() && !email.equals("cliente")) {
				boolean inserido = this.pessoa.validarDadosPessoa(nome, cpf, senha, telefone, email);
				if (inserido == true) {
					this.funcionario.atualizarFuncionario(cpf, nome, senha, telefone, email);
				} else {
					throw new FormatoDadosException();
				}
			} else {
				boolean inserido = this.pessoa.validarDadosPessoa(nome, cpf, null, telefone, null);
				if (inserido == true) {
					this.cliente.atualizarCliente(nome, cpf, telefone);
				} else {
					throw new FormatoDadosException();
				}
			}
		}
	}
	
	public void removerPessoa(String cpf, String tipo_de_insercao) {
		if (tipo_de_insercao.equals("funcionario")) {
			this.funcionario.removerFuncionario(cpf);
		} else if (tipo_de_insercao.equals("atualizar")) {
			this.funcionario.removerFuncionario(cpf);
		}
	}

}
