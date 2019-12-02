package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Entidades.Cliente;
import Excecoes.FormatoDadosException;
import Fachada.Fachada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

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
	
	public void preencherCMB() {
		comboBox.removeAllItems();
		
		for (Cliente c : Fachada.getInstance().getAllClientes()) {
			comboBox.addItem(c.getNome());
		}
		
		
	}
	
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
		
		preencherCMB();
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 99, 377, 149);
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
		btnSalvar.setBackground(new Color(50, 205, 50));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Fachada.getInstance().inserirPessoa((String)inputNome.getText(),(String) inputCpf.getText(),"", inputTelefone.getText(), "cliente", "atualizar");
			} catch (FormatoDadosException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e.toString());
			}
			preencherCMB();
			}
		});

		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(278, 117, 89, 23);
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
		btnVoltar.setBounds(10, 117, 89, 23);
		panel.add(btnVoltar);
		
		
		comboBox.setBounds(28, 32, 377, 22);
		contentPane.add(comboBox);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente c = Fachada.getInstance().findClientesByName((String) comboBox.getSelectedItem()).get(0);
				
				inputNome.setText(c.getNome());
				inputCpf.setText(c.getCpf());
				inputTelefone.setText(c.getTelefone());
				
			}
		});
		btnBuscar.setBackground(SystemColor.textHighlight);
		btnBuscar.setBounds(174, 65, 91, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblAtualizarCliente = new JLabel("Atualizar Cliente");
		lblAtualizarCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAtualizarCliente.setBounds(126, 11, 212, 14);
		contentPane.add(lblAtualizarCliente);
	}

}
