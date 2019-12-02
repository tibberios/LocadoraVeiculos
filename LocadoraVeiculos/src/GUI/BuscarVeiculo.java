package GUI;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Entidades.Veiculo;
import Fachada.Fachada;

public class BuscarVeiculo extends JFrame {

	private JPanel contentPane;
	JComboBox comboBoxVeiculos = new JComboBox();
	public static BuscarVeiculo instance;
	public static BuscarVeiculo getInstace() {
		if (BuscarVeiculo.instance == null) {
			return BuscarVeiculo.instance = new BuscarVeiculo();
		}
		return BuscarVeiculo.instance;
	}

	public void preencherCMB() {
		Fachada.getInstance().getVeiculo().getRv().getAll();
		comboBoxVeiculos.removeAllItems();
		for(Veiculo v : Fachada.getInstance().getVeiculo().getRv().getVeiculos()){

			comboBoxVeiculos.addItem(v.getPlaca());
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarVeiculo frame = new BuscarVeiculo();
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
	public BuscarVeiculo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		preencherCMB();
		
		JLabel lblBuscarCliente = new JLabel("Buscar Veiculo");
		lblBuscarCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBuscarCliente.setBounds(145, 11, 185, 22);
		contentPane.add(lblBuscarCliente);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 119, 351, 120);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);

		comboBoxVeiculos.setBounds(53, 52, 351, 22);
		contentPane.add(comboBoxVeiculos);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Fachada.getInstance().getVeiculo().getRv().find((String) comboBoxVeiculos.getSelectedItem());
			Veiculo v = Fachada.getInstance().getVeiculo().getRv().getVeiculos().get(0);
			
			textArea.setText("Marca: " + v.getMarca() + "\nModelo: " + v.getModelo()+ "\nCor: " + v.getCor() + "\nAno:" + v.getAno() + "\nPreco: " + v.getPreco() + "KM: " + v.getKilometragem());
			
			}
		});
		btnBuscar.setBackground(SystemColor.textHighlight);
		btnBuscar.setBounds(173, 85, 91, 23);
		contentPane.add(btnBuscar);

	

		JButton button = new JButton("Voltar");
		button.setBackground(SystemColor.textHighlight);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDeGerenciamento.getInstace().setVisible(true);
				dispose();
			}
		});
		button.setBounds(313, 239, 91, 23);
		contentPane.add(button);
	}

}
