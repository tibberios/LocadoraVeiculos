package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FazerLocacao extends JFrame {

	private JPanel contentPane;
	public static FazerLocacao instance;
	private JTextField textField_1;
	JComboBox comboBox = new JComboBox();
	JComboBox comboBox_1 = new JComboBox();
	public static FazerLocacao getInstace() {
		if (FazerLocacao.instance == null) {
			return FazerLocacao.instance = new FazerLocacao();
		}
		return FazerLocacao.instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FazerLocacao frame = new FazerLocacao();
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
	public FazerLocacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		comboBox.setBounds(98, 45, 334, 22);
		contentPane.add(comboBox);
		
		
		comboBox_1.setBounds(98, 103, 334, 22);
		contentPane.add(comboBox_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(218, 177, 149, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDataDevoluo = new JLabel("Data Devolu\u00E7\u00E3o ");
		lblDataDevoluo.setBounds(110, 180, 81, 14);
		contentPane.add(lblDataDevoluo);
		
		JButton btnLocar = new JButton("Locar");
		btnLocar.setBounds(252, 208, 91, 23);
		contentPane.add(btnLocar);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(10, 49, 46, 14);
		contentPane.add(lblCliente);
		
		JLabel lblVeiculo = new JLabel("Veiculo");
		lblVeiculo.setBounds(10, 107, 46, 14);
		contentPane.add(lblVeiculo);
		
		JLabel lblLocao = new JLabel("Loca\u00E7\u00E3o");
		lblLocao.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLocao.setBounds(198, 11, 212, 14);
		contentPane.add(lblLocao);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDeGerenciamento.getInstace().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 239, 91, 23);
		contentPane.add(btnVoltar);
	}

}