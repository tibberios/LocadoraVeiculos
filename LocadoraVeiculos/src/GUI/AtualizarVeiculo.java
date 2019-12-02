package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Entidades.Veiculo;
import Fachada.Fachada;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class AtualizarVeiculo extends JFrame {

	private JPanel contentPane;
	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textCor;
	private JTextField textAno;
	private JTextField textPreco;
	JComboBox comboBoxVeiculos = new JComboBox();
	public static AtualizarVeiculo instance;
	private JTextField textKm;
	public static AtualizarVeiculo getInstace() {
		if (AtualizarVeiculo.instance == null) {
			return AtualizarVeiculo.instance = new AtualizarVeiculo();
		}
		return AtualizarVeiculo.instance;
	}
	/**
	 * Launch the application.
	 */
	public void preencherCMB() {
		Fachada.getInstance().getVeiculo().getRv().getAll();
		comboBoxVeiculos.removeAllItems();
		for(Veiculo v : Fachada.getInstance().getVeiculo().getRv().getVeiculos()){

			comboBoxVeiculos.addItem(v.getPlaca());
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarVeiculo frame = new AtualizarVeiculo();
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
	public AtualizarVeiculo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		preencherCMB();
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(50, 89, 347, 193);
		getContentPane().add(panel);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMarca.setBounds(10, 17, 46, 14);
		panel.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModelo.setBounds(10, 42, 51, 14);
		panel.add(lblModelo);
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCor.setBounds(10, 67, 46, 14);
		panel.add(lblCor);
		
		textMarca = new JTextField();
		textMarca.setColumns(10);
		textMarca.setBounds(79, 11, 245, 20);
		panel.add(textMarca);
		
		textModelo = new JTextField();
		textModelo.setColumns(10);
		textModelo.setBounds(79, 36, 245, 20);
		panel.add(textModelo);
		
		textCor = new JTextField();
		textCor.setColumns(10);
		textCor.setBounds(79, 61, 245, 20);
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
		button_1.setBounds(10, 179, 89, 14);
		panel.add(button_1);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAno.setBounds(10, 92, 46, 14);
		panel.add(lblAno);
		
		textAno = new JTextField();
		textAno.setColumns(10);
		textAno.setBounds(79, 91, 245, 20);
		panel.add(textAno);
		
		textPreco = new JTextField();
		textPreco.setColumns(10);
		textPreco.setBounds(79, 116, 245, 20);
		panel.add(textPreco);
		
		JLabel lblQuilometros = new JLabel("Quilometros");
		lblQuilometros.setBounds(10, 154, 46, 14);
		panel.add(lblQuilometros);
		
		textKm = new JTextField();
		textKm.setBounds(79, 147, 245, 20);
		panel.add(textKm);
		textKm.setColumns(10);
		
		JButton btnAtualizarVeiculo = new JButton("Atualizar Veiculo");
		btnAtualizarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Fachada.getInstance().atualizarVeiculo((String)comboBoxVeiculos.getSelectedItem(),(String) textMarca.getText(),(String) textModelo.getText(),(String) textCor.getText(), Integer.parseInt(textAno.getText()), Double.parseDouble(textPreco.getText()), Integer.parseInt(textKm.getText()));
			preencherCMB();
			}
		});
		btnAtualizarVeiculo.setBackground(new Color(50, 205, 50));
		btnAtualizarVeiculo.setBounds(213, 180, 124, 16);
		panel.add(btnAtualizarVeiculo);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreco.setBounds(10, 117, 46, 14);
		panel.add(lblPreco);
		
	
		
		JLabel lblAtualizarVeiculo = new JLabel("Atualizar Veiculo");
		lblAtualizarVeiculo.setBounds(137, 11, 185, 22);
		contentPane.add(lblAtualizarVeiculo);
		lblAtualizarVeiculo.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		
		comboBoxVeiculos.setBounds(39, 37, 377, 22);
		contentPane.add(comboBoxVeiculos);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.getInstance().getVeiculo().getRv().find((String) comboBoxVeiculos.getSelectedItem());
				Veiculo v = Fachada.getInstance().getVeiculo().getRv().getVeiculos().get(0);
				
				textMarca.setText(v.getMarca());
				textModelo.setText(v.getModelo());
				textCor.setText(v.getCor());
				textAno.setText(""+v.getAno());
				textPreco.setText(""+ v.getPreco());
				textKm.setText(""+v.getKilometragem());
				
								
			}
		});
		btnBuscar.setBackground(SystemColor.textHighlight);
		btnBuscar.setBounds(183, 66, 91, 22);
		contentPane.add(btnBuscar);
	}

}
