package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField inputEmail;
	private JTextField inputSenha;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
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
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEntrar.setBounds(315, 147, 89, 23);
		panel.add(btnEntrar);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLogin.setBounds(188, 28, 90, 30);
		contentPane.add(lblLogin);
	}
}
