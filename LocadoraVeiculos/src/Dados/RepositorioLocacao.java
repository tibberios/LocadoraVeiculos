package Dados;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BancodeDados.Conexao;
import Entidades.Funcionario;
import Entidades.Locacao;

public class RepositorioLocacao{
	private ArrayList<Locacao> locacoes;
	private Locacao locacao;
	
	public RepositorioLocacao() {
		this.setLocacoes(new ArrayList<Locacao>());
	}

	public ArrayList<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(ArrayList<Locacao> locacoes) {
		this.locacoes = locacoes;
	}
	
	public void encontrarLocacao(String clienteCPF, String veiculoPlaca) {
		try {
			if ((clienteCPF != null && !clienteCPF.trim().equals("")) && (veiculoPlaca != null && !veiculoPlaca.trim().equals(""))) {
				locacoes.clear();
				String sql = "SELECT * FROM locacao WHERE clienteCPF = '" + clienteCPF + "'" + " AND veiculoPlaca = '" + veiculoPlaca + "'";
				Conexao.getInstance().buscarSQL(sql);
				while (Conexao.getInstance().getResultset().next()) {
					locacao = new Locacao(Conexao.getInstance().getResultset().getString("clienteCPF"), Conexao.getInstance().getResultset().getString("veiculoPlaca"),
							Double.parseDouble(Conexao.getInstance().getResultset().getString("valorTotal")), Conexao.getInstance().getResultset().getString("data_locacao"),
							Conexao.getInstance().getResultset().getString("data_devolucao"));
					locacoes.add(locacao);
				}
			}
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro interno, solicite a equipe tecnica", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		Conexao.getInstance().setResultset(null);	
	}
	
	public boolean verificarSeExiste(Locacao locacao) {
		this.encontrarLocacao(locacao.getClienteCPF(), locacao.getVeiculoPlaca());
		for (Locacao loc: locacoes) {
			if (locacao.getClienteCPF().equals(loc.getClienteCPF()) && locacao.getVeiculoPlaca().equals(loc.getVeiculoPlaca())) {
				return true;
			} 
		}
		return false;
	}
	
	public void inserirLocacao(Locacao locacao) {
		if (this.verificarSeExiste(locacao) == true) {
			JOptionPane.showMessageDialog(null, "Locacao ja existe!", "Erro", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				String sql = "INSERT INTO locacao (clienteCPF, veiculoPlaca, valorTotal, data_devolucao) VALUES (";
				if (!locacao.getClienteCPF().isEmpty() && !locacao.getVeiculoPlaca().isEmpty() && locacao.getValorTotal() > 0 && !locacao.getData_devolucao().isEmpty()) {
					sql += "'" + locacao.getClienteCPF() + "', " + "'" + locacao.getVeiculoPlaca() + "', "  + locacao.getValorTotal() + ", " + "'" + locacao.getData_devolucao() + "')"; 
				}

				int rowInsered = Conexao.getInstance().executaSQL(sql);
				if (rowInsered == 200) {
					this.locacoes.add(locacao);
					JOptionPane.showMessageDialog(null, "Locacao inserida com sucesso!");
				}				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Houve um erro interno, solicite a equipe tecnica", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void encontrarTodasLocacoes() {
		locacoes.clear();
		String sql = "SELECT * FROM locacao";
		Conexao.getInstance().buscarSQL(sql);
		try {
			while (Conexao.getInstance().getResultset().next()) {
				locacao = new Locacao(Conexao.getInstance().getResultset().getString("clienteCPF"), Conexao.getInstance().getResultset().getString("veiculoPlaca"),
						Double.parseDouble(Conexao.getInstance().getResultset().getString("valorTotal")), Conexao.getInstance().getResultset().getString("data_locacao"),
						Conexao.getInstance().getResultset().getString("data_devolucao"));
				locacoes.add(locacao);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro interno, solicite a equipe tecnica", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void atualizarLocacao(String clienteCPF, String veiculoPlaca, double valorTotal, String data_devolucao) {
		try {
			String sql = "UPDATE funcionario SET";
			int aux = 0;
			
			if (valorTotal > 0) {
				sql += " valorTotal = '" + valorTotal + "'";
				aux = 1;
			}

			if (data_devolucao != null && !data_devolucao.trim().equals("")) {
				if (aux == 1) {
					sql += ", data_devolucao = '" + data_devolucao + "'";
				} else {
					aux = 1;
					sql += " data_devolucao = '" + data_devolucao + "'";
				}
			}
			
			sql += " WHERE clienteCPF = '" + clienteCPF + "'" + " AND veiculoPlaca = '" + veiculoPlaca + "'";
			Conexao.getInstance().executaSQL(sql);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro interno, solicite a equipe tecnica", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
