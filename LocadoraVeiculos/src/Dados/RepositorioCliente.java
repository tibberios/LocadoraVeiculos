package Dados;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BancodeDados.Conexao;
import Entidades.Cliente;
import Util.UtilFunctions;

public class RepositorioCliente implements UtilFunctions {
	private ArrayList<Cliente> clientes;
	private Cliente Cliente;
	
	public RepositorioCliente() {
		this.clientes = new ArrayList<Cliente>();
	}
	
	@Override
	public void getAll() {
		clientes.clear();
		String sql = "SELECT * FROM cliente";
		Conexao.getInstance().buscarSQL(sql);
		try {
			while (Conexao.getInstance().getResultset().next()) {
				Cliente = new Cliente(Conexao.getInstance().getResultset().getString("nome"), Conexao.getInstance().getResultset().getString("cpf"),
						Conexao.getInstance().getResultset().getString("telefone"), Integer.parseInt(Conexao.getInstance().getResultset().getString("ativo")));
				clientes.add(Cliente);
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
					Cliente = new Cliente(Conexao.getInstance().getResultset().getString("nome"), Conexao.getInstance().getResultset().getString("cpf"),
							Conexao.getInstance().getResultset().getString("telefone"), Integer.parseInt(Conexao.getInstance().getResultset().getString("ativo")));
					clientes.add(Cliente);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro interno, solicite a equipe tecnica", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		Conexao.getInstance().setResultset(null);	
	}
	
	public boolean verificarSeExiste(Cliente Cliente) {
		this.find(Cliente.getCpf());
		for (Cliente func: clientes) {
			if (Cliente.getCpf().equals(func.getCpf())) {
				return true;
			} 
		}
		return false;
	}

	public void inserirCliente(Cliente Cliente) {
		if (this.verificarSeExiste(Cliente) == true) {
			JOptionPane.showMessageDialog(null, "Cliente ja existe!", "Erro", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				String sql = "INSER INTO cliente (nome, cpf, senha, telefone, email) VALUES (";
				if (!Cliente.getNome().isEmpty() && !Cliente.getCpf().isEmpty() && !Cliente.getTelefone().isEmpty()) {
					sql += "'" + Cliente.getNome() + "', " + "'" + Cliente.getCpf() + "'" + Cliente.getTelefone() + "')";
				}
				
				int rowInsered = Conexao.getInstance().executaSQL(sql);
				if (rowInsered == 200) {
					this.clientes.add(Cliente);
					JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!");
				}				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Houve um erro interno, solicite a equipe tecnica", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
}
