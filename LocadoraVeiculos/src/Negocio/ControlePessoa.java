package Negocio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;


import Util.Pessoa;

public class ControlePessoa {
	Pessoa pessoa;
	
	public ControlePessoa() {
		
	}

	public boolean validarNome(String nome) {
		if (nome.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nome nao pode ficar em branco!", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			//verificar se existe numeros no nome
			Pattern pattern = Pattern.compile("[0-9]");
			Matcher matcher = pattern.matcher(nome);
			if (matcher.find()) {
				JOptionPane.showMessageDialog(null, "Nome nao pode conter numeros!", "Erro", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}

	public boolean validarCPF(String cpf) {
		int i, j, digito2 = 0;

		if (cpf.length() != 11) {
			JOptionPane.showMessageDialog(null, "CPF invalido!", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if ((cpf == "00000000000") || (cpf == "11111111111") || (cpf == "22222222222") ||
				(cpf == "33333333333") || (cpf == "44444444444") || (cpf == "55555555555") ||
				(cpf == "66666666666") || (cpf == "77777777777") || (cpf == "88888888888") ||
				(cpf == "99999999999")) {
			JOptionPane.showMessageDialog(null, "CPF invalido!", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			for (i = 0, j = 11; i < cpf.length() - 1; i++, j--) {
				digito2 += (cpf.charAt(i) - 48) * j;
				digito2 *= 11;
			}
			if (digito2 < 2) {
				digito2 = 0;

			} else {
				digito2 = 11 - digito2;
			}
			return true;
		}
	}

	public boolean validarSenha(String senha) {
		//verificar se existe um espaço na senha
		boolean encontrou_espaco = false;
		encontrou_espaco = senha.contains(" ");
		
		if (senha.isEmpty() || senha.length() < 6) {
			JOptionPane.showMessageDialog(null, "A senha deve conter mais do que 6 caracteres!", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (encontrou_espaco == true) {
			JOptionPane.showMessageDialog(null, "Caracter invalido na senha!", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}
	
	public boolean validarTelefone(String telefone) {
		if (telefone.matches("[0-9]+") && telefone.length() < 12 && telefone.length() > 10) {
			return true;
		} 
		return false;
	}
	
	public boolean validarDadosPessoa(String nome, String cpf, String senha, String telefone) {
		boolean validar_nome = this.validarNome(nome);
		boolean validar_cpf = this.validarCPF(cpf);
		boolean validar_senha = this.validarSenha(senha);
		boolean validar_telefone = this.validarTelefone(telefone);
		
		if (validar_nome == true && validar_cpf == true && validar_senha == true && validar_telefone == true) {
			return true;
		}
		return false;
	}
}
