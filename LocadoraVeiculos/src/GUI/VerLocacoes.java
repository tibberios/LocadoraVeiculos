package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Entidades.Cliente;
import Fachada.Fachada;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.setBackground(SystemColor.textHighlight);
		btnBuscar.setBounds(171, 58, 91, 23);
		contentPane.add(btnBuscar);
		
		JButton btnEncerrarLocao = new JButton("Encerrar Loca\u00E7\u00E3o");
		btnEncerrarLocao.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		btnEncerrarLocao.setBounds(277, 219, 127, 23);
		contentPane.add(btnEncerrarLocao);
		
		JLabel lblCodigoDaLocap = new JLabel("Codigo Da Loca\u00E7\u00E3o");
		lblCodigoDaLocap.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCodigoDaLocap.setBounds(53, 228, 91, 14);
		contentPane.add(lblCodigoDaLocap);
		
		textCodigoLocacao = new JTextField();
		textCodigoLocacao.setBounds(153, 223, 91, 20);
		contentPane.add(textCodigoLocacao);
		textCodigoLocacao.setColumns(10);
	}
}
