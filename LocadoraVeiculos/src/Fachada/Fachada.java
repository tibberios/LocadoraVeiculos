package Fachada;

import Negocio.ControleFuncionario;
import Negocio.ControlePessoa;

public class Fachada {
	private ControlePessoa pessoa;     
	private ControleFuncionario funcionario;

	static Fachada instance;

	public Fachada() {
		pessoa = new ControlePessoa();
		funcionario = new ControleFuncionario();
	}

	public static Fachada getInstance() {
		if (Fachada.instance == null) {
			return Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}

	public void inserirPessoa (String nome, String cpf, String senha, String telefone, String email, String tipo_inserir) {
		//no botao inserir da inteface grafica, ao chamar essa função, ira passar no ultimo parametro "funcionario" ou "cliente" para saber o tipo de pessoa que irá inserir
		if (tipo_inserir.equals("funcionario")) {
			boolean inserido = this.pessoa.validarDadosPessoa(nome, cpf, senha, telefone);
			if (inserido == true) {
				this.funcionario.inserirFuncionario(nome, cpf, senha, telefone, email);
			}
		}
	}
}
