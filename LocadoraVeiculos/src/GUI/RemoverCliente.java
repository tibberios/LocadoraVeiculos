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

import Entidades.Cliente;
import Fachada.Fachada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class RemoverCliente extends JFrame {

	private JPanel contentPane;
	JComboBox comboBoxClientes = new JComboBox();
	public static RemoverCliente instance;
	public static RemoverCliente getInstace() {
		if (RemoverCliente.instance == null) {
			return RemoverCliente.instance = new RemoverCliente();
		}
		return RemoverCliente.instance;
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
					RemoverCliente frame = new RemoverCliente();
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
	public RemoverCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		preencherCMB();
		
		JLabel lblBuscarCliente = new JLabel("Remover Cliente");
		lblBuscarCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBuscarCliente.setBounds(145, 11, 185, 22);
		contentPane.add(lblBuscarCliente);
		
		
		comboBoxClientes.setBounds(54, 52, 351, 22);
		contentPane.add(comboBoxClientes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 119, 351, 120);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente c = Fachada.getInstance().findClientesByName((String) comboBoxClientes.getSelectedItem()).get(0);
				
				textArea.setText("Nome" + c.getNome() + "\nCPF: " + c.getCpf() + "\nTelefone: " + c.getTelefone() );
				
			}
		});
		btnBuscar.setBackground(UIManager.getColor("TextPane.selectionBackground"));
		btnBuscar.setBounds(172, 85, 91, 23);
		contentPane.add(btnBuscar);

		JButton btnRemover = new JButton("Remover");
		btnRemover.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = Fachada.getInstance().findClientesByName((String) comboBoxClientes.getSelectedItem()).get(0).getCpf();
				
				Fachada.getInstance().removerPessoa(cpf, "cliente");
				preencherCMB();
			}
		});
		btnRemover.setBounds(54, 239, 91, 23);
		contentPane.add(btnRemover);
		
		JButton button = new JButton("Voltar");
		button.setBackground(UIManager.getColor("TextPane.selectionBackground"));
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
