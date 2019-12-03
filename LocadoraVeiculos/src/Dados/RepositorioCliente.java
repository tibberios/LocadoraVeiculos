package Dados;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BancodeDados.Conexao;
import Entidades.Cliente;
import Entidades.Funcionario;
import Util.UtilFunctions;

public class RepositorioCliente implements UtilFunctions {
	private ArrayList<Cliente> clientes;
	private Cliente cliente;
	
	public RepositorioCliente() {
		this.clientes = new ArrayList<Cliente>();
	}
	
	public ArrayList<Cliente> getClientes() {
		return this.clientes;
	}
	
	@Override
	public void getAll() {
		clientes.clear();
		String sql = "SELECT * FROM cliente WHERE ativo = 1";
		Conexao.getInstance().buscarSQL(sql);
		try {
			while (Conexao.getInstance().getResultset().next()) {
				cliente = new Cliente(Conexao.getInstance().getResultset().getString("nome"), Conexao.getInstance().getResultset().getString("cpf"),
						Conexao.getInstance().getResultset().getString("telefone"), Integer.parseInt(Conexao.getInstance().getResultset().getString("ativo")));
				clientes.add(cliente);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro interno, solicite a equipe tecnica", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void find(String cpf) {
		try {
			if (cpf != null && !cpf.trim().equals("")) {
				clientes.clear();
				String sql = "SELECT * FROM cliente WHERE cpf = '" + cpf + "'";
				Conexao.getInstance().buscarSQL(sql);
				while (Conexao.getInstance().getResultset().next()) {
					cliente = new Cliente(Conexao.getInstance().getResultset().getString("nome"), Conexao.getInstance().getResultset().getString("cpf"),
							Conexao.getInstance().getResultset().getString("telefone"), Integer.parseInt(Conexao.getInstance().getResultset().getString("ativo")));
					clientes.add(cliente);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro interno, solicite a equipe tecnica", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		Conexao.getInstance().setResultset(null);	
	}
	
	public boolean verificarSeExiste(Cliente cliente) {
		this.find(cliente.getCpf());
		for (Cliente func: clientes) {
			if (cliente.getCpf().equals(func.getCpf())) {
				return true;
			} 
		}
		return false;
	}

	public void inserirCliente(Cliente cliente) {
		if (this.verificarSeExiste(cliente) == true) {
			JOptionPane.showMessageDialog(null, "Cliente ja existe!", "Erro", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				String sql = "INSERT INTO cliente (nome, cpf, telefone) VALUES (";
				if (!cliente.getNome().isEmpty() && !cliente.getCpf().isEmpty() && !cliente.getTelefone().isEmpty()) {
					sql += "'" + cliente.getNome() + "', " + "'" + cliente.getCpf() + "', '" + cliente.getTelefone() + "')";
				}
				
				int rowInsered = Conexao.getInstance().executaSQL(sql);
				if (rowInsered == 200) {
					this.clientes.add(cliente);
					JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!");
				}				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Houve um erro interno, solicite a equipe tecnica", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	@Override
	public void remove(String cpf) {
		try {
			if (cpf != null && !cpf.trim().equals("")) {
				String sql = "UPDATE cliente SET ativo = '0' WHERE cpf = '" + cpf + "'";
		
				int rowInsered = Conexao.getInstance().executaSQL(sql);
				if (rowInsered == 200) {
					JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
				}				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro interno, solicite a equipe tecnica", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void update(String cpf, String nome, String telefone) {
		try {
			String sql = "UPDATE cliente SET";
			int aux = 0;
			
			if (nome != null && !nome.trim().equals("")) {
				sql += " nome = '" + nome + "'";
				aux = 1;
			}

			if (telefone != null && !telefone.trim().equals("")) {
				if (aux == 1) {
					sql += ", telefone = '" + telefone + "'";
				} else {
					aux = 1;
					sql += " telefone = '" + telefone + "'";
				}
			}

			sql += " WHERE cpf = '" + cpf + "'";
	
			Conexao.getInstance().executaSQL(sql);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro interno, solicite a equipe tecnica", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void findByName(String nome) {
		try {
			if (nome != null && !nome.trim().equals("")) {
				clientes.clear();
				String sql = "SELECT * FROM cliente WHERE nome = '" + nome + "'";
				Conexao.getInstance().buscarSQL(sql);
				while (Conexao.getInstance().getResultset().next()) {
					cliente = new Cliente(Conexao.getInstance().getResultset().getString("nome"), Conexao.getInstance().getResultset().getString("cpf"),
							Conexao.getInstance().getResultset().getString("telefone"), Integer.parseInt(Conexao.getInstance().getResultset().getString("ativo")));
					clientes.add(cliente);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro interno, solicite a equipe tecnica", "Erro", JOptionPane.ERROR_MESSAGE);
		}

		Conexao.getInstance().setResultset(null);	
	}
}
