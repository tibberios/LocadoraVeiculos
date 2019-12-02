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

import Entidades.Funcionario;
import Fachada.Fachada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class BuscarFuncionario extends JFrame {

	private JPanel contentPane;
	JComboBox<String> comboBoxFuncionarios = new JComboBox<String>();
	public static BuscarFuncionario instance;
	public static BuscarFuncionario getInstace() {
		if (BuscarFuncionario.instance == null) {
			return BuscarFuncionario.instance = new BuscarFuncionario();
		}
		return BuscarFuncionario.instance;
	}
	
	public void preencherCMB() {
		
		
		for(Funcionario f : Fachada.getInstance().getAllFuncionarios()) {
			comboBoxFuncionarios.addItem(f.getNome());
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarFuncionario frame = new BuscarFuncionario();
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
	public BuscarFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		preencherCMB();
		
		JLabel lblBuscarCliente = new JLabel("Buscar Funcionario");
		lblBuscarCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBuscarCliente.setBounds(145, 11, 185, 22);
		contentPane.add(lblBuscarCliente);
		
		
		comboBoxFuncionarios.setBounds(53, 52, 351, 22);
		contentPane.add(comboBoxFuncionarios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 119, 351, 120);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Funcionario f = Fachada.getInstance().findFuncionarioByName((String) comboBoxFuncionarios.getSelectedItem()).get(0);
				
				textArea.setText("Nome: " + f.getNome() + "\nEmail: " + f.getEmail() + "\nCPF: " + f.getCpf() + "\nTelefone: " + f.getTelefone());
			}
		});
		btnBuscar.setBackground(SystemColor.textHighlight);
		btnBuscar.setBounds(171, 85, 91, 23);
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
