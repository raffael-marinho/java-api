package app;

import javax.swing.SwingUtilities;

import dao.PacienteDAO;
import dao.PacienteDAOImpl;
import view.TelaPrincipal;

public class Aplicativo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			PacienteDAO pacienteDAO = new PacienteDAOImpl();

			TelaPrincipal telaPrincipal = new TelaPrincipal(pacienteDAO);
			telaPrincipal.setVisible(true);
		});
	}

}
