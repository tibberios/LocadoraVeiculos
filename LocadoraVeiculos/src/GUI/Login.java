package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BancodeDados.Conexao;
import Excecoes.EmailNaoCadastradoException;
import Excecoes.SenhaInvalidaException;
import Fachada.Fachada;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField inputEmail;
	private JTextField inputSenha;
	static int funcADM = -1;
	public static Login instance;
	public static Login getInstace() {
		if (Login.instance == null) {
			return Login.instance = new Login();
		}
		return Login.instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		Conexao.getInstance().conectar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 70, 414, 181);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 34, 39, 14);
		panel.add(lblEmail);

		inputEmail = new JTextField();
		inputEmail.setBounds(59, 33, 345, 20);
		panel.add(inputEmail);
		inputEmail.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(10, 78, 46, 14);
		panel.add(lblSenha);

		inputSenha = new JTextField();
		inputSenha.setBounds(59, 77, 345, 20);
		panel.add(inputSenha);
		inputSenha.setColumns(10);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(SystemColor.textHighlight);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int aux = Fachada.getInstance().Login((String)inputEmail.getText(), (String)inputSenha.getText());
					
					if(aux == 1) {
						funcADM = 1;
						TelaDeGerenciamento.getInstace().setVisible(true);
						dispose();
					}else if(aux == 0){			
						funcADM = 0;
						TelaDeGerenciamento.getInstace().setVisible(true);
						dispose();
					}
				} catch (SenhaInvalidaException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.toString());
				} catch (EmailNaoCadastradoException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.toString());
				}

			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEntrar.setBounds(315, 147, 89, 23);
		panel.add(btnEntrar);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblLogin.setBounds(176, 29, 90, 30);
		contentPane.add(lblLogin);



	}
}
