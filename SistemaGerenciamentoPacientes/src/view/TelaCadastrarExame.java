package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.ExameDAO;
import model.Exame;

public class TelaCadastrarExame extends JFrame {

	private ExameDAO exameDAO;
	private TelaExame telaExame;

	public TelaCadastrarExame(ExameDAO exameDAO, TelaExame telaExame) {
		this.exameDAO = exameDAO;
		this.telaExame = telaExame;

		setTitle("Cadastrar Exame");
		setSize(400, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());

		JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
		formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JLabel lblDescricao = new JLabel("Descrição:");
		JTextField txtDescricao = new JTextField();
		JLabel lblDataExame = new JLabel("Data do Exame (AAAA-MM-DD):");
		JTextField txtDataExame = new JTextField();
		JLabel lblPacienteId = new JLabel("ID do Paciente:");
		JTextField txtPacienteId = new JTextField();

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(
				e -> cadastrarExame(txtDescricao.getText(), txtDataExame.getText(), txtPacienteId.getText()));

		formPanel.add(lblDescricao);
		formPanel.add(txtDescricao);
		formPanel.add(lblDataExame);
		formPanel.add(txtDataExame);
		formPanel.add(lblPacienteId);
		formPanel.add(txtPacienteId);
		formPanel.add(new JLabel());
		formPanel.add(btnCadastrar);

		add(formPanel, BorderLayout.CENTER);

		setVisible(true);
	}

	private void setLayout(BorderLayout borderLayout) {
		// TODO Auto-generated method stub
		
	}

	private void cadastrarExame(String descricao, String dataExame, String pacienteId) {
		try {
			Date data = Date.valueOf(dataExame);
			Long idPaciente = Long.parseLong(pacienteId);

			Exame exame = new Exame(descricao, data, idPaciente);

			exameDAO.cadastrar(exame);

			JOptionPane.showMessageDialog(this, "Exame cadastrado com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
			telaExame.loadTableExame();
			dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erro ao cadastrar exame: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}