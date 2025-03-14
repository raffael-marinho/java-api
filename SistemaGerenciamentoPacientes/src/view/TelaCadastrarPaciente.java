package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.PacienteDAO;
import model.Paciente;

public class TelaCadastrarPaciente extends JFrame {

	private PacienteDAO pacienteDAO;
	private TelaPrincipal telaPrincipal;

	public TelaCadastrarPaciente(PacienteDAO pacienteDAO, TelaPrincipal telaPrincipal) {
		this.pacienteDAO = pacienteDAO;
		this.telaPrincipal = telaPrincipal;

		setTitle("Cadastrar Paciente");
		setSize(400, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());

		JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
		formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JLabel lblCpf = new JLabel("CPF:");
		JTextField txtCpf = new JTextField();
		JLabel lblNome = new JLabel("Nome:");
		JTextField txtNome = new JTextField();

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(e -> cadastrarPaciente(txtCpf.getText(), txtNome.getText()));

		formPanel.add(lblCpf);
		formPanel.add(txtCpf);
		formPanel.add(lblNome);
		formPanel.add(txtNome);
		formPanel.add(new JLabel()); 
		formPanel.add(btnCadastrar);

		add(formPanel, BorderLayout.CENTER);

		setVisible(true);
	}

	private void setLayout(BorderLayout borderLayout) {
		// TODO Auto-generated method stub
		
	}

	private void cadastrarPaciente(String cpf, String nome) {
		try {
			Paciente paciente = new Paciente(cpf, nome);
			pacienteDAO.cadastrar(paciente);
			JOptionPane.showMessageDialog(this, "Paciente cadastrado com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
			telaPrincipal.loadTablePaciente(); 
			dispose(); 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erro ao cadastrar paciente: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
