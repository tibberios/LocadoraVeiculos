package Teste;

import BancodeDados.Conexao;

public class Main {

	public static void main(String[] args) {
		Conexao.getInstance().conectar();
		
		String sql = "INSERT INTO cliente(cpf, nome, senha, telefone) VALUES ('11111111111','TesteBD','123456','')";
		
		Conexao.getInstance().executaSQL(sql);

		Conexao.getInstance().desconectar();
	}

}
