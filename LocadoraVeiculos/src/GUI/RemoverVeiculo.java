package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class RemoverVeiculo extends JFrame {

	private JPanel contentPane;
	JComboBox comboBoxVeiculos = new JComboBox();
	public static RemoverVeiculo instance;
	public static RemoverVeiculo getInstace() {
		if (RemoverVeiculo.instance == null) {
			return RemoverVeiculo.instance = new RemoverVeiculo();
		}
		return RemoverVeiculo.instance;
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
					RemoverVeiculo frame = new RemoverVeiculo();
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
	public RemoverVeiculo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		preencherCMB();
		JLabel lblBuscarCliente = new JLabel("Remover Veiculo");
		lblBuscarCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBuscarCliente.setBounds(145, 11, 185, 22);
		contentPane.add(lblBuscarCliente);
		
		
		comboBoxVeiculos.setBounds(54, 52, 351, 22);
		contentPane.add(comboBoxVeiculos);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 119, 351, 120);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.getInstance().getVeiculo().getRv().find((String) comboBoxVeiculos.getSelectedItem());
				Veiculo v = Fachada.getInstance().getVeiculo().getRv().getVeiculos().get(0);
				
				textArea.setText("Marca: " + v.getMarca() + "\nModelo: " + v.getModelo()+ "\nCor: " + v.getCor() + "\nAno:" + v.getAno() + "\nPreco: " + v.getPreco() + "KM: " + v.getKilometragem());
				
			}
		});
		btnBuscar.setBackground(UIManager.getColor("TextPane.selectionBackground"));
		btnBuscar.setBounds(172, 85, 91, 23);
		contentPane.add(btnBuscar);
	
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.getInstance().removerVeiculo((String)comboBoxVeiculos.getSelectedItem());
				preencherCMB();
			}
		});
		btnRemover.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		btnRemover.setBounds(54, 239, 91, 23);
		contentPane.add(btnRemover);
		
		JButton button = new JButton("Voltar");
		button.setBackground(SystemColor.textHighlight);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDeGerenciamento.getInstace().setVisible(true);
				dispose();
			}
		});
		button.setBounds(314, 239, 91, 23);
		contentPane.add(button);
	
	}

}
