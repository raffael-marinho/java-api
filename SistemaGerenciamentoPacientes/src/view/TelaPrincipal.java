package view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import dao.PacienteDAO;
import dao.PacienteDAOImpl;
import model.Paciente;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JMenuBar barraMenu;
	private JMenu menuPaciente;
	private JMenu menuExame;
	private JMenuItem menuItemAdicionarPaciente;
	private JMenuItem menuItemAtualizarPaciente;
	private JScrollPane scrollPane;
	private JTable tablePacientes;
	private PacienteDAO pacienteDAO;
	private JTabbedPane tabbed;

	public TelaPrincipal(PacienteDAO pacienteDAO) {
		this.pacienteDAO = pacienteDAO;
		setTitle("Gerenciamento de Pacientes e Exames");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		barraMenu = new JMenuBar();
		menuPaciente = new JMenu("Paciente");
		barraMenu.add(menuPaciente);

		menuItemAdicionarPaciente = new JMenuItem("Adicionar");
		menuItemAdicionarPaciente.addActionListener(e -> new TelaCadastrarPaciente(pacienteDAO, this));
		menuItemAtualizarPaciente = new JMenuItem("Atualizar");
		menuPaciente.add(menuItemAdicionarPaciente);
		menuPaciente.add(menuItemAtualizarPaciente);

		add(barraMenu, BorderLayout.NORTH);

		tablePacientes = new JTable();
		scrollPane = new JScrollPane(tablePacientes);

		tabbed = new JTabbedPane();
		tabbed.addTab("Pacientes", scrollPane);
		add(tabbed, BorderLayout.CENTER);

		loadTablePaciente();
	}

	private void setLayout(BorderLayout borderLayout) {
		// TODO Auto-generated method stub
		
	}

	protected void loadTablePaciente() {
		try {
			List<Paciente> pacientes = pacienteDAO.listar();
			tablePacientes.setModel(new TabelaPacienteModel(pacientes));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erro ao carregar pacientes: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			PacienteDAO pacienteDAO = new PacienteDAOImpl();
			new TelaPrincipal(pacienteDAO).setVisible(true);
		});
	}
}