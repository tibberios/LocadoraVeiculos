package Dados;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BancodeDados.Conexao;
import Entidades.Funcionario;
import Util.UtilFunctions;

public class RepositorioFuncionario implements UtilFunctions{
	private ArrayList<Funcionario> funcionarios;
	private Funcionario funcionario;

	public RepositorioFuncionario() {
		this.funcionarios = new ArrayList<Funcionario>();
	}
	
	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	@Override
	public void getAll() {
		funcionarios.clear();
		String sql = "SELECT * FROM funcionario WHERE  ativo = 1";
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

	@Override
	public void find(String cpf) {
		try {
			if (cpf != null && !cpf.trim().equals("")) {
				funcionarios.clear();
				String sql = "SELECT * FROM funcionario WHERE cpf = '" + cpf + "'";
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
		this.find(funcionario.getCpf());
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
				String sql = "INSERT INTO funcionario (nome, cpf, senha, telefone, email) VALUES (";
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

	@Override
	public void remove(String cpf) {
		try {
			if (cpf != null && !cpf.trim().equals("")) {
				String sql = "UPDATE funcionario SET ativo = '0' WHERE cpf = '" + cpf + "'";
			
				int rowInsered = Conexao.getInstance().executaSQL(sql);
				if (rowInsered == 200) {
					JOptionPane.showMessageDialog(null, "Funcionario removido com sucesso!");
				}				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro interno, solicite a equipe tecnica", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void update(String cpf, String nome, String senha, String telefone, String email) {
		try {
			String sql = "UPDATE funcionario SET";
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

			if (email != null && !email.trim().equals("")) {
				if (aux == 1) {
					sql += ", email = '" + email + "'";
				} else {
					sql += " email = '" + email + "'";
				}
			}
			
			if (senha != null && !senha.trim().equals("")) {
				if (aux == 1) {
					sql += ", senha = '" + senha + "'";
				} else {
					sql += " senha = '" + senha + "'";
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
				funcionarios.clear();
				String sql = "SELECT * FROM funcionario WHERE nome = '" + nome + "'";
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

}
