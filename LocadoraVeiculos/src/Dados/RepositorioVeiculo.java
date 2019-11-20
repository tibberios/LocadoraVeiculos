package Dados;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entidades.Veiculo;


public class RepositorioVeiculo {
	private ArrayList <Veiculo> veiculo;

	public RepositorioVeiculo() {
		veiculo = new ArrayList <Veiculo>();
	}

	public boolean verifarSeexiste(Veiculo veiculo) {
		if (this.veiculo.contains(veiculo)){
			return true;
		}
		return false;
	}

	public void inserirVeiculo(Veiculo veiculo) {
		if(this.veiculo.contains(veiculo)) {
			JOptionPane.showMessageDialog(null, "Veiculo já existe!", "Erro", JOptionPane.ERROR_MESSAGE);
		}else {
			this.veiculo.add(veiculo);
			JOptionPane.showMessageDialog(null, "Veiculo inserido com sucesso!");
		}
	}

	public void ProcurarVeiculo(String placa) {
		
	}

	public void removerVeiculo() {

	}

}
