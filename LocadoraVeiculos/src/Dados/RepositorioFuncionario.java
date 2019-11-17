package Dados;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entidades.Funcionario;

public class RepositorioFuncionario {
	private ArrayList<Funcionario> funcionario;

	public RepositorioFuncionario() {
		funcionario = new ArrayList<Funcionario>();
	}

	public boolean verificarSeExiste(Funcionario funcionario) {
		if (this.funcionario.contains(funcionario)) {
			return true;
		}
		return false;
	}

	public void inserirFuncionario(Funcionario funcionario) {
		if (this.verificarSeExiste(funcionario) == true) {
			JOptionPane.showMessageDialog(null, "Funcionario ja existe!", "Erro", JOptionPane.ERROR_MESSAGE);
		} else {
			this.funcionario.add(funcionario);
			JOptionPane.showMessageDialog(null, "Funcionario inserido com sucesso!");
		}
	}
}
