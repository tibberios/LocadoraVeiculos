package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Fachada.Fachada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AtualizarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField inputNome;
	private JTextField inputCpf;
	private JTextField inputTelefone;
	JComboBox comboBox = new JComboBox();
	public static AtualizarCliente instance;
	public static AtualizarCliente getInstace() {
		if (AtualizarCliente.instance == null) {
			return AtualizarCliente.instance = new AtualizarCliente();
		}
		return AtualizarCliente.instance;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarCliente frame = new AtualizarCliente();
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
	public AtualizarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 113, 377, 149);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 17, 46, 14);
		panel.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(10, 42, 46, 14);
		panel.add(lblCpf);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setBounds(10, 67, 51, 14);
		panel.add(lblTelefone);
		
		inputNome = new JTextField();
		inputNome.setBounds(79, 11, 245, 20);
		panel.add(inputNome);
		inputNome.setColumns(10);
		
		inputCpf = new JTextField();
		inputCpf.setEditable(false);
		inputCpf.setBounds(79, 36, 245, 20);
		panel.add(inputCpf);
		inputCpf.setColumns(10);
		
		inputTelefone = new JTextField();
		inputTelefone.setBounds(79, 61, 245, 20);
		panel.add(inputTelefone);
		inputTelefone.setColumns(10);
		
		JButton btnSalvar = new JButton("Atualizar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.getInstance().getCliente().atualizarCliente((String)inputCpf.getText(), (String)inputNome.getText(), (String)inputTelefone.getText());
			}
		});

		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(278, 117, 89, 23);
		panel.add(btnSalvar);
		
		JButton btnVoltar = new JButton("< Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDeGerenciamento.getInstace().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(10, 117, 89, 23);
		panel.add(btnVoltar);
		
		
		comboBox.setBounds(28, 32, 377, 22);
		contentPane.add(comboBox);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(174, 65, 91, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblAtualizarCliente = new JLabel("Atualizar Cliente");
		lblAtualizarCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAtualizarCliente.setBounds(126, 11, 212, 14);
		contentPane.add(lblAtualizarCliente);
	}

}
