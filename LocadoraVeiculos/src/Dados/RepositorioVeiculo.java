package Dados;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import BancodeDados.Conexao;
import Entidades.Funcionario;
import Entidades.Veiculo;
import Excecoes.PlacaExisteExeception;
import Util.UtilFunctions;


public class RepositorioVeiculo implements UtilFunctions{
	private ArrayList <Veiculo> veiculos;
	private Veiculo veiculo;

	public RepositorioVeiculo() {
		veiculos = new ArrayList <Veiculo>();
	}

	public boolean verifarSeexiste(Veiculo veiculo) {
		this.find(veiculo.getPlaca());
		for(Veiculo car : veiculos) {
			if(veiculo.getPlaca().equals(car.getPlaca())){
				return true;
			}
		}

		return false;
	}

	public void inserirVeiculo(Veiculo veiculo) throws PlacaExisteExeception {
		String sql = "INSERT INTO veiculo(placa, marca, modelo, cor, km_rodados, ano, preco) VALUES (";
	
		if(this.verifarSeexiste(veiculo)==false) {
			sql += "'"+veiculo.getPlaca()+"', ";
			sql += "'"+veiculo.getMarca()+"', ";
			sql += "'"+veiculo.getModelo()+"', ";
			sql += "'"+veiculo.getCor()+"', ";
			sql += "'"+veiculo.getKilometragem()+"', ";
			sql += "'"+veiculo.getAno()+"', ";
			sql += "'"+veiculo.getPreco()+"')";
		Conexao.getInstance().executaSQL(sql);
		}else {
			throw new PlacaExisteExeception (veiculo.getPlaca());
		}
	}

	public void removerVeiculo(Veiculo veiculo) {
		for(Veiculo car : veiculos) {
			if(veiculo.getPlaca().equals(car.getPlaca())== true){



			}
		}
	}

	@Override
	public void getAll() {
		veiculos.clear();
		String sql = "SELECT * FROM funcionario";
		Conexao.getInstance().buscarSQL(sql);

		try {
			while (Conexao.getInstance().getResultset().next()) {
				veiculo = new Veiculo(Conexao.getInstance().getResultset().getString("placa"), Conexao.getInstance().getResultset().getString("marca"),
						Conexao.getInstance().getResultset().getString("modelo"), Conexao.getInstance().getResultset().getString("cor"),
						Integer.parseInt(Conexao.getInstance().getResultset().getString("ano")), Double.parseDouble((Conexao.getInstance().getResultset().getString("preco"))), 
						Integer.parseInt(Conexao.getInstance().getResultset().getString("km_rodados")), Integer.parseInt(Conexao.getInstance().getResultset().getString("ativo")));
				veiculos.add(veiculo);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro interno, solicite a equipe tecnica", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}



	@Override
	public void find(String placa) {
		try {
			if (placa != null && !placa.trim().equals("")) {
				veiculos.clear();
				String sql = "SELECT * FROM veiculo WHERE placa = '" + placa + "'";
				Conexao.getInstance().buscarSQL(sql);
				while (Conexao.getInstance().getResultset().next()) {
					veiculo = new Veiculo(Conexao.getInstance().getResultset().getString("placa"), Conexao.getInstance().getResultset().getString("marca"),
							Conexao.getInstance().getResultset().getString("modelo"), Conexao.getInstance().getResultset().getString("cor"),
							Integer.parseInt(Conexao.getInstance().getResultset().getString("ano")), Double.parseDouble((Conexao.getInstance().getResultset().getString("preco"))), 
							Integer.parseInt(Conexao.getInstance().getResultset().getString("km_rodados")), Integer.parseInt(Conexao.getInstance().getResultset().getString("ativo")));
					veiculos.add(veiculo);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro interno, solicite a equipe tecnica", "Erro", JOptionPane.ERROR_MESSAGE);
		}

		Conexao.getInstance().setResultset(null);	
	}

	@Override
	public void remove(String string_to_remove) {
		// TODO Auto-generated method stub
		
	}

}
