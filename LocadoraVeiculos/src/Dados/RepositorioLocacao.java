package Dados;

import java.util.ArrayList;

import Entidades.Locacao;
import Util.UtilFunctions;

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
	
}
