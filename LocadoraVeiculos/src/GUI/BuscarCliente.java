package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JLabel lblBuscarCliente = new JLabel("Buscar Cliente");
		lblBuscarCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBuscarCliente.setBounds(145, 11, 185, 22);
		contentPane.add(lblBuscarCliente);
		
		
		comboBoxClientes.setBounds(68, 52, 324, 22);
		contentPane.add(comboBoxClientes);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnBuscar.setBounds(174, 85, 91, 23);
		contentPane.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 119, 351, 120);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDeGerenciamento.getInstace().setVisible(true);
				dispose();
			}
		});
		button.setBounds(341, 250, 91, 23);
		contentPane.add(button);
	}
}
