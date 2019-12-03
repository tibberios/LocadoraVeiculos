package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Entidades.Cliente;
import Entidades.Locacao;
import Fachada.Fachada;

public class VerLocacoes extends JFrame {

	private JPanel contentPane;
	JComboBox<String> comboBox = new JComboBox<String>();
	public static VerLocacoes instance;
	public static VerLocacoes getInstace() {
		if (VerLocacoes.instance == null) {
			return VerLocacoes.instance = new VerLocacoes();
		}
		return VerLocacoes.instance;
	}
	/**
	 * Launch the application.
	 */
	public void preencheCMB() {
		comboBox.removeAllItems();
		for (Cliente c : Fachada.getInstance().getAllClientes()) {
			comboBox.addItem(c.getNome());
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerLocacoes frame = new VerLocacoes();
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
	public VerLocacoes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		preencheCMB();
		
//		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(53, 25, 347, 22);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 92, 351, 120);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			textArea.setText("");
			String cpf = Fachada.getInstance().findClientesByName((String) comboBox.getSelectedItem()).get(0).getCpf();
			Fachada.getInstance().todasLocacoesCliente(cpf);
			
			for(Locacao l : Fachada.getInstance().getLocacao().getRepositorio().getLocacoes()) {
				textArea.setText("Placa: " + l.getVeiculoPlaca() + "\nValor: " + l.getValorTotal() + "\nDataDevolucao: " + l.getData_devolucao()
				+ "\nDataLocacao: " + l.getData_locacao() + "\n\n");
			}
			
			}
		});
		btnBuscar.setBackground(SystemColor.textHighlight);
		btnBuscar.setBounds(171, 58, 91, 23);
		contentPane.add(btnBuscar);
	}
}
