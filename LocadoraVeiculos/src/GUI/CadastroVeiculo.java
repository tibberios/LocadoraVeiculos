package GUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class CadastroVeiculo extends JPanel {
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtCor;
	private JTextField txtHodometroInicial;

	/**
	 * Create the panel.
	 */
	public CadastroVeiculo() {
		setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(0, 0, 6, 368);
		add(textPane);
		
		JButton btnIncluirVeiculo = new JButton("Incluir Veiculo");
		btnIncluirVeiculo.setBounds(199, 265, 124, 23);
		add(btnIncluirVeiculo);
		
		JTextPane txtpnPlaca = new JTextPane();
		txtpnPlaca.setText("Placa ");
		txtpnPlaca.setBounds(48, 56, 91, 20);
		add(txtpnPlaca);
		
		txtMarca = new JTextField();
		txtMarca.setText("Marca");
		txtMarca.setBounds(48, 89, 91, 20);
		add(txtMarca);
		txtMarca.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setText("Modelo ");
		txtModelo.setBounds(48, 123, 91, 20);
		add(txtModelo);
		txtModelo.setColumns(10);
		
		txtCor = new JTextField();
		txtCor.setText("Cor");
		txtCor.setBounds(48, 154, 91, 20);
		add(txtCor);
		txtCor.setColumns(10);
		
		txtHodometroInicial = new JTextField();
		txtHodometroInicial.setText("Hodometro Inicial ");
		txtHodometroInicial.setBounds(48, 185, 101, 20);
		add(txtHodometroInicial);
		txtHodometroInicial.setColumns(10);

	}
}
