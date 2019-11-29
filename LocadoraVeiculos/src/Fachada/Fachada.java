package Fachada;

import javax.swing.JOptionPane;

import BancodeDados.Conexao;
import Entidades.Funcionario;
import Excecoes.EmailNaoCadastradoException;
import Excecoes.FormatoDadosException;
import Excecoes.SenhaInvalidaException;
import Negocio.ControleCliente;
import Negocio.ControleFuncionario;
import Negocio.ControlePessoa;

public class Fachada {
	private ControlePessoa pessoa;     
	private ControleFuncionario funcionario;
	private ControleCliente cliente;


	public Fachada() {
		pessoa = new ControlePessoa();
		funcionario = new ControleFuncionario();
		cliente = new ControleCliente();
	}
	public static Fachada instance;
	public static Fachada getInstance() {
		if(Fachada.instance == null) {
			return Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}



	public ControlePessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(ControlePessoa pessoa) {
		this.pessoa = pessoa;
	}

	public ControleFuncionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(ControleFuncionario funcionario) {
		this.funcionario = funcionario;
	}

	public ControleCliente getCliente() {
		return cliente;
	}

	public void setCliente(ControleCliente cliente) {
		this.cliente = cliente;
	}

	public static void setInstance(Fachada instance) {
		Fachada.instance = instance;
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

	public int Login(String email, String senha) throws SenhaInvalidaException,EmailNaoCadastradoException{
		String sql = "SELECT email, senha, tipo FROM funcionario WHERE email = '" + email + "'";
		
		Conexao.getInstance().buscarSQL(sql);
		
		funcionario.getRepositorio().getFuncionarios().clear();
		
		try {
			
			while (Conexao.getInstance().getResultset().next()) {
				Funcionario funcionario = new Funcionario("", "",
						Conexao.getInstance().getResultset().getString("senha"), "",
						Conexao.getInstance().getResultset().getString("email"), 0, 
						Integer.parseInt(Conexao.getInstance().getResultset().getString("tipo")));
				this.funcionario.getRepositorio().getFuncionarios().add(funcionario);
			}
			
			if(this.funcionario.getRepositorio().getFuncionarios().size() > 0) {
				for(Funcionario f : this.funcionario.getRepositorio().getFuncionarios()) {
					if(f.getEmail().equals(email)) {
						if(f.getSenha().equals(senha)) {
							if(f.getTipo() == 0) {
								return 0;
							}else if(f.getTipo() == 1) {
								return 1;
							}
						}else {
							throw new SenhaInvalidaException();
						}
					}else {
						throw new EmailNaoCadastradoException();
					}
				}
			}else {
				throw new EmailNaoCadastradoException();
			}
			
			Conexao.getInstance().setResultset(null);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}

		return -1;
	}
}
