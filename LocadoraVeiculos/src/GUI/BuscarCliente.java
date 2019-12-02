package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidades.Cliente;
import Entidades.Funcionario;
import Fachada.Fachada;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class BuscarCliente extends JFrame {

	private JPanel contentPane;
	JComboBox comboBoxClientes = new JComboBox();
	public static BuscarCliente instance;
	public static BuscarCliente getInstace() {
		if (BuscarCliente.instance == null) {
			return BuscarCliente.instance = new BuscarCliente();
		}
		return BuscarCliente.instance;
	}
	
	public void preencherCMB() {
		comboBoxClientes.removeAllItems();
		
		for (Cliente c : Fachada.getInstance().getAllClientes()) {
			comboBoxClientes.addItem(c.getNome());
		}
		
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarCliente frame = new BuscarCliente();
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
	public BuscarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		preencherCMB();
		
		JLabel lblBuscarCliente = new JLabel("Buscar Cliente");
		lblBuscarCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBuscarCliente.setBounds(145, 11, 185, 22);
		contentPane.add(lblBuscarCliente);
		
		
		comboBoxClientes.setBounds(53, 52, 351, 22);
		contentPane.add(comboBoxClientes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 119, 351, 120);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(SystemColor.textHighlight);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Cliente c = Fachada.getInstance().findClientesByName((String) comboBoxClientes.getSelectedItem()).get(0);
			
			textArea.setText("Nome" + c.getNome() + "\nCPF: " + c.getCpf() + "\nTelefone: " + c.getTelefone() );
			
			}
		});
		btnBuscar.setBounds(174, 85, 91, 23);
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
