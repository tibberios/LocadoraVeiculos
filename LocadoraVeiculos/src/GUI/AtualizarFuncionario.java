package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Fachada.Fachada;

import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class AtualizarFuncionario extends JFrame {
	
	private JPanel contentPane;
	private JTextField inputNome;
	private JTextField inputCpf;
	private JTextField inputTelefone;
	private JTextField inputSenha;
	private JTextField inputEmail;
	JComboBox comboBox = new JComboBox();
	public static AtualizarFuncionario instance;
	public static AtualizarFuncionario getInstace() {
		if (AtualizarFuncionario.instance == null) {
			return AtualizarFuncionario.instance = new AtualizarFuncionario();
		}
		return AtualizarFuncionario.instance;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarFuncionario frame = new AtualizarFuncionario();
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
	public AtualizarFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 79, 377, 172);
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
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(10, 92, 46, 14);
		panel.add(lblSenha);
		
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
		
		inputSenha = new JTextField();
		inputSenha.setBounds(79, 86, 245, 20);
		panel.add(inputSenha);
		inputSenha.setColumns(10);
		
		JButton btnSalvar = new JButton("Atualizar");
		btnSalvar.setBackground(new Color(50, 205, 50));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fachada.getInstance().getFuncionario().atualizarFuncionario((String)inputCpf.getText(), (String)inputNome.getText(), (String)inputSenha.getText(), (String)inputTelefone.getText(), (String)inputEmail.getText());
			}
		});

		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(278, 147, 89, 23);
		panel.add(btnSalvar);
		
		JButton btnVoltar = new JButton("< Voltar");
		btnVoltar.setBackground(SystemColor.textHighlight);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDeGerenciamento.getInstace().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(10, 147, 89, 23);
		panel.add(btnVoltar);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 117, 46, 14);
		panel.add(lblEmail);
		
		inputEmail = new JTextField();
		inputEmail.setBounds(79, 116, 245, 20);
		panel.add(inputEmail);
		inputEmail.setColumns(10);
		
		
		comboBox.setBounds(28, 32, 377, 22);
		contentPane.add(comboBox);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(SystemColor.textHighlight);
		btnBuscar.setBounds(168, 56, 91, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblAtualizarFuncionario = new JLabel("Atualizar Funcionario");
		lblAtualizarFuncionario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAtualizarFuncionario.setBounds(126, 11, 212, 14);
		contentPane.add(lblAtualizarFuncionario);
	}

}
