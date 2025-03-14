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

import dao.ExameDAO;
import model.Exame;

public class TelaExame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JMenuBar barraMenu;
	private JMenu menuExame;
	private JMenuItem menuItemAdicionarExame;
	private JMenuItem menuItemAtualizarExame;
	private JScrollPane scrollPane;
	private JTable tableExames;
	private ExameDAO exameDAO;
	private JTabbedPane tabbed;

	public TelaExame(ExameDAO exameDAO) {
		this.exameDAO = exameDAO;
		setTitle("Gerenciamento de Exames");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());

		barraMenu = new JMenuBar();
		menuExame = new JMenu("Exame");
		barraMenu.add(menuExame);

		menuItemAdicionarExame = new JMenuItem("Adicionar");
		menuItemAdicionarExame.addActionListener(e -> new TelaCadastrarExame(exameDAO, this));
		menuItemAtualizarExame = new JMenuItem("Atualizar");
		menuExame.add(menuItemAdicionarExame);
		menuExame.add(menuItemAtualizarExame);

		add(barraMenu, BorderLayout.NORTH);

		tableExames = new JTable();
		scrollPane = new JScrollPane(tableExames);

		tabbed = new JTabbedPane();
		tabbed.addTab("Exames", scrollPane);
		add(tabbed, BorderLayout.CENTER);

		loadTableExame();
	}

	private void setLayout(BorderLayout borderLayout) {
		// TODO Auto-generated method stub
		
	}

	protected void loadTableExame() {
		try {
			List<Exame> exames = exameDAO.listar();
			tableExames.setModel(new TabelaExameModel(exames));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erro ao carregar exames: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}