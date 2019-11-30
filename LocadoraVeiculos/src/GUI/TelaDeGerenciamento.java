package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class TelaDeGerenciamento extends JFrame {

	private JPanel contentPane;
	JRadioButton rdbtnFuncionario = new JRadioButton("Funcionario");
	JRadioButton rdbtnCliente = new JRadioButton("Cliente");
	JRadioButton rdbtnVeiculo = new JRadioButton("Veiculo");
	public static TelaDeGerenciamento instance;
	public static TelaDeGerenciamento getInstace() {
		if (TelaDeGerenciamento.instance == null) {
			return TelaDeGerenciamento.instance = new TelaDeGerenciamento();
		}
		return TelaDeGerenciamento.instance;
	}
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public void isFuncADM() {
		if(Login.funcADM == 1) {
			rdbtnVeiculo.setEnabled(true);
			rdbtnFuncionario.setEnabled(true);
			rdbtnCliente.setEnabled(true);
			
		}else if(Login.funcADM == 0){
			rdbtnVeiculo.setEnabled(true);
			rdbtnCliente.setEnabled(true);
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeGerenciamento frame = new TelaDeGerenciamento();
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
	public TelaDeGerenciamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		buttonGroup.add(rdbtnVeiculo);
		rdbtnVeiculo.setBounds(31, 225, 66, 23);
		contentPane.add(rdbtnVeiculo);
		rdbtnVeiculo.setEnabled(false);
		
		
		buttonGroup.add(rdbtnFuncionario);
		rdbtnFuncionario.setBounds(117, 225, 81, 23);
		contentPane.add(rdbtnFuncionario);
		rdbtnFuncionario.setEnabled(false);
		
		
		buttonGroup.add(rdbtnCliente);
		rdbtnCliente.setBounds(219, 225, 59, 23);
		contentPane.add(rdbtnCliente);
		rdbtnCliente.setEnabled(false);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnVeiculo.isSelected() == true) {
					Cadastro_Veiculo.getInstace().setVisible(true);
					dispose();
				}else if(rdbtnCliente.isSelected() == true) {
					CadastroUsuario.getInstace().setVisible(true);
					dispose();
				}else if(rdbtnFuncionario.isSelected() == true) {
					CadastroUsuario.getInstace().setVisible(true);
					dispose();
				}
			}
		});
		btnCadastrar.setBounds(31, 76, 91, 23);
		contentPane.add(btnCadastrar);
		btnCadastrar.setEnabled(false);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnVeiculo.isSelected() == true) {
					RemoverVeiculo.getInstace().setVisible(true);
					dispose();
				}else if(rdbtnCliente.isSelected() == true) {
					RemoverCliente.getInstace().setVisible(true);
					dispose();
				}else if(rdbtnFuncionario.isSelected() == true) {
					RemoverFuncionario.getInstace().setVisible(true);
					dispose();
				}
			}
		});
		btnRemover.setBounds(143, 76, 91, 23);
		contentPane.add(btnRemover);
		btnRemover.setEnabled(false);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnVeiculo.isSelected() == true) {
					BuscarVeiculo.getInstace().setVisible(true);
					dispose();
				}else if(rdbtnCliente.isSelected() == true) {
					BuscarCliente.getInstace().setVisible(true);
					dispose();
				}else if(rdbtnFuncionario.isSelected() == true) {
					BuscarFuncionario.getInstace().setVisible(true);
					dispose();
				}
			}
		});
		btnBuscar.setBounds(31, 146, 91, 23);
		contentPane.add(btnBuscar);
		btnBuscar.setEnabled(false);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(rdbtnVeiculo.isSelected() == true) {
						AtualizarVeiculo.getInstace().setVisible(true);
						dispose();
					}else if(rdbtnCliente.isSelected() == true) {
						AtualizarCliente.getInstace().setVisible(true);
						dispose();
					}else if(rdbtnFuncionario.isSelected() == true) {
						AtualizarFuncionario.getInstace().setVisible(true);
						dispose();
					}
			}
		});
		btnAtualizar.setBounds(143, 146, 91, 23);
		contentPane.add(btnAtualizar);
		btnAtualizar.setEnabled(false);
		
		JLabel lblTelaDeGerenciamento = new JLabel("Tela de Gerenciamento");
		lblTelaDeGerenciamento.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTelaDeGerenciamento.setBounds(117, 11, 212, 14);
		contentPane.add(lblTelaDeGerenciamento);
		
		JButton btnFazerLocacao = new JButton("Fazer Loca\u00E7\u00E3o");
		btnFazerLocacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FazerLocacao.getInstace().setVisible(true);
				dispose();
				
			}
		});
		btnFazerLocacao.setBounds(287, 146, 109, 23);
		contentPane.add(btnFazerLocacao);
		btnFazerLocacao.setEnabled(false);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(SystemColor.textHighlight);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.getInstace().setVisible(true);
				dispose();
				Login.funcADM = -1;
			}
		});
		btnVoltar.setBounds(305, 225, 91, 23);
		contentPane.add(btnVoltar);
		
		JButton btnVerLocacao = new JButton("Loca\u00E7\u00F5es");
		btnVerLocacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerLocacoes.getInstace().setVisible(true);
				dispose();
			}
		});
		btnVerLocacao.setBounds(284, 76, 109, 23);
		contentPane.add(btnVerLocacao);
		btnVerLocacao.setEnabled(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 56, 251, 135);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(271, 56, 140, 135);
		contentPane.add(panel_1);
		
		isFuncADM();
		rdbtnVeiculo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnCadastrar.setEnabled(true);
				btnRemover.setEnabled(true);
				btnBuscar.setEnabled(true);
				btnAtualizar.setEnabled(true);
				btnFazerLocacao.setEnabled(false);
				btnVerLocacao.setEnabled(false);
			}
		});
		
		rdbtnFuncionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnCadastrar.setEnabled(true);
				btnRemover.setEnabled(true);
				btnBuscar.setEnabled(true);
				btnAtualizar.setEnabled(true);
				btnFazerLocacao.setEnabled(false);
				btnVerLocacao.setEnabled(false);
			}
		});
		
		rdbtnCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnCadastrar.setEnabled(true);
				btnRemover.setEnabled(true);
				btnBuscar.setEnabled(true);
				btnAtualizar.setEnabled(true);
				btnFazerLocacao.setEnabled(true);
				btnVerLocacao.setEnabled(true);
			}
		});
	}
}
