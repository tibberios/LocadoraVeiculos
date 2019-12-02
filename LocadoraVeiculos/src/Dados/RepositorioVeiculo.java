package Dados;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;

import BancodeDados.Conexao;
import Entidades.Veiculo;
import Excecoes.PlacaExisteExeception;
import Util.UtilFunctions;


public class RepositorioVeiculo implements UtilFunctions{
	private ArrayList <Veiculo> veiculos;
	private Veiculo veiculo;

	public RepositorioVeiculo() {
		veiculos = new ArrayList <Veiculo>();
	}

	
	
	
	public ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}




	public void setVeiculos(ArrayList<Veiculo> veiculos) {
		this.veiculos = veiculos;
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
			int aux = Conexao.getInstance().executaSQL(sql);
			
			if(aux == 200) {
				JOptionPane.showMessageDialog(null, "Veiculo Inserido");
			}
		}else {
			throw new PlacaExisteExeception (veiculo.getPlaca());
		}
		
		
	}



	@Override
	public void getAll() {
		veiculos.clear();
		String sql = "SELECT * FROM veiculo WHERE ativo = 1";
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
	public void remove(String placa) {
		try {
			if (placa != null && !placa.trim().equals("")){
				String sql = "UPDATE veiculo SET ativo = '0' WHERE placa = '"+ placa + "'";
				System.out.println(sql);
				int rowInsered = Conexao.getInstance().executaSQL(sql);
				if (rowInsered == 200) {
					JOptionPane.showMessageDialog(null, "Veiculo desativado com sucesso!");
				}
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro interno, solicite a equipe tecnica", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void update(String placa,String marca,String modelo,String cor,int km_rodados,int ano,double preco) {
		try {
			String sql = "UPDATE veiculo SET";
			int aux = 0;

			if(marca != null && !marca.trim().equals("")) {
				sql += " marca = '" + marca + "'";
				aux = 1;
			}
			if(modelo!= null && !modelo.trim().equals("")) {
				if (aux == 1) {
					sql += ", modelo = '" + modelo + "'";
				} else {
					aux = 1;
					sql += " modelo = '" + modelo + "'";
				}
			}

			if(cor != null && !cor.trim().equals("")) {
				if(aux==1) {
					sql+= ", cor = '" + cor + "'";
				}else {
					aux=1;
					sql+= " cor = '" + cor + "'";	
				}
			}

			if(km_rodados > 0) {
				if(aux==1) {
					sql+= ", km_rodados = '" + km_rodados + "'";
				}else {
					aux=1;
					sql+= " km_rodados = '" + km_rodados + "'";	
				}
			}

			if(ano !=0 ) {
				if(aux==1) {
					sql+= ", ano = '" + ano + "'";
				}else {
					aux=1;
					sql+= " ano = '" + ano + "'";	
				}
			}

			if(preco!=0) {
				if(aux==1) {
					sql+= ", preco = '" + preco + "'";
				}else {
					aux=1;
					sql+= " preco = '" + preco + "'";
				}	
			}
			sql += " WHERE placa = '" + placa + "'";
			System.out.println(sql);
			Conexao.getInstance().executaSQL(sql);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro interno, solicite a equipe tecnica", "Erro", JOptionPane.ERROR_MESSAGE);
		}

	}







}


