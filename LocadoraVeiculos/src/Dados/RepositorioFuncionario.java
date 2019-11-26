package Dados;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BancodeDados.Conexao;
import Entidades.Funcionario;

public class RepositorioFuncionario {
	private ArrayList<Funcionario> funcionarios;
	Funcionario funcionario;
	
	public RepositorioFuncionario() {
		funcionarios = new ArrayList<Funcionario>();
	}
	
	public void getAllFuncionarios() {
		funcionarios.clear();
		String sql = "SELECT * FROM usuario";
		Conexao.getInstance().buscarSQL(sql);
		try {
			while (Conexao.getInstance().getResultset().next()) {
				funcionario = new Funcionario(Conexao.getInstance().getResultset().getString("nome"), Conexao.getInstance().getResultset().getString("cpf"),
						Conexao.getInstance().getResultset().getString("senha"), Conexao.getInstance().getResultset().getString("telefone"),
						Conexao.getInstance().getResultset().getString("email"), Integer.parseInt(Conexao.getInstance().getResultset().getString("ativo")), 
						Integer.parseInt(Conexao.getInstance().getResultset().getString("tipo")));
				funcionarios.add(funcionario);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro interno, solicite a equipe tecnica", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void findFuncionario(String cpf) {
		try {
			if (cpf != null && !cpf.trim().equals("")) {
				funcionarios.clear();
				String sql = "SELECT * FROM usuario WHERE cpf = '" + cpf + "'";
				Conexao.getInstance().buscarSQL(sql);
				while (Conexao.getInstance().getResultset().next()) {
					funcionario = new Funcionario(Conexao.getInstance().getResultset().getString("nome"), Conexao.getInstance().getResultset().getString("cpf"),
							Conexao.getInstance().getResultset().getString("senha"), Conexao.getInstance().getResultset().getString("telefone"),
							Conexao.getInstance().getResultset().getString("email"), Integer.parseInt(Conexao.getInstance().getResultset().getString("ativo")), 
							Integer.parseInt(Conexao.getInstance().getResultset().getString("tipo")));
					funcionarios.add(funcionario);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro interno, solicite a equipe tecnica", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		Conexao.getInstance().setResultset(null);
	}
	
	public boolean verificarSeExiste(Funcionario funcionario) {
		for (Funcionario func: funcionarios) {
			if (funcionario.getCpf().equals(func.getCpf())) {
				return true;
			} 
		}
		return false;
	}

	public void inserirFuncionario(Funcionario funcionario) {
		if (this.verificarSeExiste(funcionario) == true) {
			JOptionPane.showMessageDialog(null, "Funcionario ja existe!", "Erro", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				String sql = "INSER INTO funcionario (nome, cpf, senha, telefone, email) VALUES (";
				if (!funcionario.getNome().isEmpty() && !funcionario.getCpf().isEmpty() && !funcionario.getSenha().isEmpty() && !funcionario.getTelefone().isEmpty() && !funcionario.getEmail().isEmpty()) {
					sql += "'" + funcionario.getNome() + "', " + "'" + funcionario.getCpf() + "', " + "'" + funcionario.getSenha() + "', " + "'" + funcionario.getTelefone() + "', " + "'" + funcionario.getEmail() + "')";
				}
				
				int rowInsered = Conexao.getInstance().executaSQL(sql);
				if (rowInsered == 200) {
					this.funcionarios.add(funcionario);
					JOptionPane.showMessageDialog(null, "Funcionario inserido com sucesso!");
				}				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Houve um erro interno, solicite a equipe tecnica", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
