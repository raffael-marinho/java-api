package app;

import javax.swing.SwingUtilities;
import dao.ExameDAO;
import dao.ExameDAOImpl;
import dao.PacienteDAO;
import dao.PacienteDAOImpl;
import view.TelaExame;
import view.TelaPrincipal;

public class Aplicativo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			PacienteDAO pacienteDAO = new PacienteDAOImpl();
			ExameDAO exameDAO = new ExameDAOImpl();

			TelaPrincipal telaPrincipal = new TelaPrincipal(pacienteDAO);
			telaPrincipal.setVisible(true);

			TelaExame telaExame = new TelaExame(exameDAO);
			telaExame.setVisible(true);
		});
	}
}