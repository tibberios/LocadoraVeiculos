package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Fachada.Fachada;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;

public class CadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField inputNome;
	private JTextField inputCpf;
	private JTextField inputTelefone;
	private JTextField inputSenha;
	private JTextField inputEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuario frame = new CadastroUsuario();
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
	public CadastroUsuario() {
		Fachada fachada = new Fachada();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 30, 377, 206);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 37, 46, 14);
		panel.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(10, 62, 46, 14);
		panel.add(lblCpf);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setBounds(10, 87, 51, 14);
		panel.add(lblTelefone);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(10, 112, 46, 14);
		panel.add(lblSenha);
		
		inputNome = new JTextField();
		inputNome.setBounds(79, 31, 245, 20);
		panel.add(inputNome);
		inputNome.setColumns(10);
		
		inputCpf = new JTextField();
		inputCpf.setBounds(79, 56, 245, 20);
		panel.add(inputCpf);
		inputCpf.setColumns(10);
		
		inputTelefone = new JTextField();
		inputTelefone.setBounds(79, 81, 245, 20);
		panel.add(inputTelefone);
		inputTelefone.setColumns(10);
		
		inputSenha = new JTextField();
		inputSenha.setBounds(79, 106, 245, 20);
		panel.add(inputSenha);
		inputSenha.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");

		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(278, 172, 89, 23);
		panel.add(btnSalvar);
		
		JButton btnVoltar = new JButton("< Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(10, 174, 89, 23);
		panel.add(btnVoltar);
		
		JRadioButton rdbtnFunc = new JRadioButton("Funcionario");
		rdbtnFunc.setBounds(107, 174, 93, 23);
		panel.add(rdbtnFunc);
		
		JRadioButton rdbtnCliente = new JRadioButton("Cliente");
		rdbtnCliente.setBounds(202, 174, 70, 23);
		panel.add(rdbtnCliente);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 137, 46, 14);
		panel.add(lblEmail);
		
		inputEmail = new JTextField();
		inputEmail.setBounds(79, 136, 245, 20);
		panel.add(inputEmail);
		inputEmail.setColumns(10);
		
		JLabel lblCasoDesejaCadastrar = new JLabel("Caso deseja cadastrar um cliente, n\u00E3o preencha o EMAIL");
		lblCasoDesejaCadastrar.setFont(new Font("Tahoma", Font.ITALIC, 9));
		lblCasoDesejaCadastrar.setForeground(Color.GRAY);
		lblCasoDesejaCadastrar.setBounds(79, 11, 245, 14);
		panel.add(lblCasoDesejaCadastrar);
		
		JLabel lblCadastroDeUsurio = new JLabel("Cadastro de Usu\u00E1rio");
		lblCadastroDeUsurio.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCadastroDeUsurio.setBounds(125, 11, 212, 14);
		contentPane.add(lblCadastroDeUsurio);
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnFunc.isSelected() == true) {
					fachada.inserirPessoa(inputNome.getText(), inputCpf.getText(), inputSenha.getText(), inputTelefone.getText(), inputEmail.getText());
				} else if (rdbtnCliente.isSelected() == true) {
					if (!inputEmail.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "O email será desconsiderado por ser um cliente!", "Erro", JOptionPane.WARNING_MESSAGE);
					}
					//gambiarra o email
					fachada.inserirPessoa(inputNome.getText(), inputCpf.getText(), inputSenha.getText(), inputTelefone.getText(), "cliente");
				} else {
					JOptionPane.showMessageDialog(null, "Selecione o tipo do usuário!", "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
}
