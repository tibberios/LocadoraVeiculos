package Fachada;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BancodeDados.Conexao;
import Entidades.Cliente;
import Entidades.Funcionario;
import Entidades.Locacao;
import Excecoes.EmailNaoCadastradoException;
import Excecoes.FormatoDadosException;
import Excecoes.PlacaExisteExeception;
import Excecoes.SenhaInvalidaException;
import Negocio.ControleCliente;
import Negocio.ControleFuncionario;
import Negocio.ControleLocacao;
import Negocio.ControlePessoa;
import Negocio.ControleVeiculo;

public class Fachada {
	private ControlePessoa pessoa;     
	private ControleFuncionario funcionario;
	private ControleCliente cliente;
	private ControleLocacao locacao;
	private ControleVeiculo veiculo;
	
	public Fachada() {
		pessoa = new ControlePessoa();
		funcionario = new ControleFuncionario();
		cliente = new ControleCliente();
		locacao = new ControleLocacao();
		veiculo = new ControleVeiculo();
	}
	
	public static Fachada instance;
	public static Fachada getInstance() {
		if(Fachada.instance == null) {
			return Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}

	
	
	
	public ControleLocacao getLocacao() {
		return locacao;
	}




	public void setLocacao(ControleLocacao locacao) {
		this.locacao = locacao;
	}




	public ControleVeiculo getVeiculo() {
		return veiculo;
	}




	public void setVeiculo(ControleVeiculo veiculo) {
		this.veiculo = veiculo;
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
			if (email != null && !email.isEmpty() && !email.equals("cliente")) {
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
			if (email != null && !email.isEmpty() && !email.equals("cliente")) {
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

	public void removerPessoa(String cpf, String tipo_de_remocao) {
		if (tipo_de_remocao.equals("funcionario")) {
			this.funcionario.removerFuncionario(cpf);
		} else if (tipo_de_remocao.equals("cliente")) {
			this.cliente.removerCliente(cpf);
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
							if(f.getTipo() == 2) {
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
	
	public ArrayList<Funcionario> getAllFuncionarios() {
		this.funcionario.getAllFuncionarios();
		return this.funcionario.getRepositorio().getFuncionarios();
	}
	
	public ArrayList<Funcionario> findFuncionarioByName(String nome) {
		this.funcionario.findByName(nome);
		return this.funcionario.getRepositorio().getFuncionarios();
	}
	
	public ArrayList<Cliente> getAllClientes() {
		this.cliente.getAllClientes();
		return this.cliente.getRepositorio().getClientes();
	}
	
	public ArrayList<Cliente> findClientesByName(String nome) {
		this.cliente.findByName(nome);
		return this.cliente.getRepositorio().getClientes();
	}
	
	public void inserirLocacao(String clienteCPF, String veiculoPlaca, double valorTotal, String data_devolucao) {
		System.out.println(1);
		this.locacao.inserirLocacao(clienteCPF, veiculoPlaca, valorTotal, data_devolucao);
	}
	
	public void atualizarLocacao(String clienteCPF, String veiculoPlaca, double valorTotal, String data_devolucao) {
		this.locacao.atualizarLocacao(clienteCPF, veiculoPlaca, valorTotal, data_devolucao);
	}
	
	public ArrayList<Locacao> encontrarLocacao(String clienteCPF, String veiculoPlaca) {
		this.locacao.encontrarLocacao(clienteCPF, veiculoPlaca);
		return this.locacao.getRepositorio().getLocacoes();
	}
	
	public ArrayList<Locacao> todasLocacoesCliente(String clienteCPF) {
		this.locacao.encontrarTodasLocacoesCliente(clienteCPF);
		return this.locacao.getRepositorio().getLocacoes();
	}
	
	public void inserirVeiculo(String placa , String marca , String modelo , String cor , int ano , double preco, int km_rodados) throws PlacaExisteExeception {
		this.veiculo.inserir(placa, marca, modelo, cor, ano, preco, km_rodados);
	}
	
	public void atualizarVeiculo(String placa , String marca , String modelo , String cor , int ano , double preco, int km_rodados) {
		System.out.println(1);
		this.veiculo.atualizar(placa, marca, modelo, cor, ano, preco, km_rodados);
	}
	
	public void removerVeiculo(String placa) {
		System.out.println(1);
		this.veiculo.remove(placa);
	}
}
