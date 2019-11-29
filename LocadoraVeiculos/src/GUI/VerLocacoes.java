package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VerLocacoes extends JFrame {

	private JPanel contentPane;
	JComboBox comboBox = new JComboBox();
	private JTextField textCodigoLocacao;
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(53, 25, 347, 22);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 92, 351, 120);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(171, 58, 91, 23);
		contentPane.add(btnBuscar);
		
		JButton btnEncerrarLocao = new JButton("Encerrar Loca\u00E7\u00E3o");
		btnEncerrarLocao.setBounds(309, 239, 123, 23);
		contentPane.add(btnEncerrarLocao);
		
		JLabel lblCodigoDaLocap = new JLabel("Codigo Da Loca\u00E7\u00E3o");
		lblCodigoDaLocap.setBounds(22, 243, 107, 14);
		contentPane.add(lblCodigoDaLocap);
		
		textCodigoLocacao = new JTextField();
		textCodigoLocacao.setBounds(139, 240, 123, 20);
		contentPane.add(textCodigoLocacao);
		textCodigoLocacao.setColumns(10);
	}
}
