package Fachada;

import javax.swing.JOptionPane;

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

	public void inserirPessoa (String nome, String cpf, String senha, String telefone, String email) {
		if (email != null || !email.isEmpty() && !email.equals("cliente")) {
			boolean inserido = this.pessoa.validarDadosPessoa(nome, cpf, senha, telefone, email);
			if (inserido == true) {
				this.funcionario.inserirFuncionario(nome, cpf, senha, telefone, email);
			} else {
				JOptionPane.showMessageDialog(null, "Parametros obrigatorios nao preenchidos", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			boolean inserido = this.pessoa.validarDadosPessoa(nome, cpf, senha, telefone, email);
			if (inserido == true) {
				this.cliente.inserirCliente(nome, cpf, telefone);
			} else {
				JOptionPane.showMessageDialog(null, "Parametros obrigatorios nao preenchidos", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
