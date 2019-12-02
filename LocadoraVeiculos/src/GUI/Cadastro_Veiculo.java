package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Excecoes.PlacaExisteExeception;
import Fachada.Fachada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class Cadastro_Veiculo extends JFrame {

	private JPanel contentPane;
	private JTextField textPlaca;
	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textCor;
	private JTextField textAno;
	private JTextField textPreco;
	public static Cadastro_Veiculo instance;
	private JTextField textKm;
	public static Cadastro_Veiculo getInstace() {
		if (Cadastro_Veiculo.instance == null) {
			return Cadastro_Veiculo.instance = new Cadastro_Veiculo();
		}
		return Cadastro_Veiculo.instance;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Veiculo frame = new Cadastro_Veiculo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cadastro_Veiculo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(39, 37, 377, 214);
		getContentPane().add(panel);
		
		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlaca.setBounds(10, 17, 46, 14);
		panel.add(lblPlaca);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMarca.setBounds(10, 42, 46, 14);
		panel.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModelo.setBounds(10, 67, 51, 14);
		panel.add(lblModelo);
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCor.setBounds(10, 92, 46, 14);
		panel.add(lblCor);
		
		textPlaca = new JTextField();
		textPlaca.setColumns(10);
		textPlaca.setBounds(79, 11, 245, 20);
		panel.add(textPlaca);
		
		textMarca = new JTextField();
		textMarca.setColumns(10);
		textMarca.setBounds(79, 36, 245, 20);
		panel.add(textMarca);
		
		textModelo = new JTextField();
		textModelo.setColumns(10);
		textModelo.setBounds(79, 61, 245, 20);
		panel.add(textModelo);
		
		textCor = new JTextField();
		textCor.setColumns(10);
		textCor.setBounds(79, 86, 245, 20);
		panel.add(textCor);
		
		JButton button_1 = new JButton("< Voltar");
		button_1.setBackground(SystemColor.textHighlight);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDeGerenciamento.getInstace().setVisible(true);
				dispose();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBounds(10, 189, 89, 23);
		panel.add(button_1);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAno.setBounds(10, 117, 46, 14);
		panel.add(lblAno);
		
		textAno = new JTextField();
		textAno.setColumns(10);
		textAno.setBounds(79, 116, 245, 20);
		panel.add(textAno);
		
		textPreco = new JTextField();
		textPreco.setColumns(10);
		textPreco.setBounds(79, 141, 245, 20);
		panel.add(textPreco);
		
		JButton btnIncluirVeiculo = new JButton("Incluir Veiculo");
		btnIncluirVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Fachada.getInstance().inserirVeiculo((String)textPlaca.getText(), (String)textMarca.getText(), (String)textModelo.getText(), (String)textCor.getText(), Integer.parseInt(textAno.getText()), Double.parseDouble(textPreco.getText()), Integer.parseInt(textKm.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.toString());
				} catch (PlacaExisteExeception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.toString());
				}
			}
		});
		btnIncluirVeiculo.setBackground(new Color(50, 205, 50));
		btnIncluirVeiculo.setBounds(243, 191, 124, 23);
		panel.add(btnIncluirVeiculo);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreco.setBounds(10, 142, 46, 14);
		panel.add(lblPreco);
		
		JLabel lblQuilometros = new JLabel("Quilometros");
		lblQuilometros.setBounds(10, 164, 64, 14);
		panel.add(lblQuilometros);
		
		textKm = new JTextField();
		textKm.setBounds(79, 167, 245, 20);
		panel.add(textKm);
		textKm.setColumns(10);
		
		
		JLabel lblCadastroDeVeiculo = new JLabel("Cadastro de Veiculo");
		lblCadastroDeVeiculo.setBounds(137, 11, 185, 22);
		contentPane.add(lblCadastroDeVeiculo);
		lblCadastroDeVeiculo.setFont(new Font("Tahoma", Font.BOLD, 18));
	}
}
