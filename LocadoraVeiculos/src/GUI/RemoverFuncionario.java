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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class RemoverFuncionario extends JFrame {

	private JPanel contentPane;
	JComboBox comboBoxFuncionarios = new JComboBox();
	public static RemoverFuncionario instance;
	public static RemoverFuncionario getInstace() {
		if (RemoverFuncionario.instance == null) {
			return RemoverFuncionario.instance = new RemoverFuncionario();
		}
		return RemoverFuncionario.instance;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverFuncionario frame = new RemoverFuncionario();
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
	public RemoverFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBuscarCliente = new JLabel("Remover Funcionario");
		lblBuscarCliente.setBounds(145, 11, 185, 22);
		lblBuscarCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblBuscarCliente);
		comboBoxFuncionarios.setBounds(54, 52, 351, 22);
		contentPane.add(comboBoxFuncionarios);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.setBackground(UIManager.getColor("TextPane.selectionBackground"));
		btnBuscar.setBounds(172, 85, 91, 23);
		contentPane.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 119, 351, 120);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		btnRemover.setBounds(52, 239, 91, 23);
		contentPane.add(btnRemover);
		
		JButton button = new JButton("Voltar");
		button.setBackground(UIManager.getColor("TextPane.selectionBackground"));
		button.setBounds(314, 239, 91, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDeGerenciamento.getInstace().setVisible(true);
				dispose();
			}
		});
		contentPane.add(button);
	
	}

}
