package dao;

import java.sql.SQLException;

import exceptions.CPFDuplicadoException;
import model.Paciente;

public class TestePacienteDAO {
	public static void main(String[] args) {
		PacienteDAO pacienteDAO = new PacienteDAOImpl();

		try {
			// Teste de cadastro
			Paciente paciente1 = new Paciente("123.456.789-00", "João Silva");
			pacienteDAO.cadastrar(paciente1);
			System.out.println("Paciente cadastrado: " + paciente1.getNome());

			// Teste de listagem
			System.out.println("Listando pacientes:");
			for (Paciente p : pacienteDAO.listar()) {
				System.out.println(p);
			}

			// Teste de atualização
			paciente1.setNome("João Silva Santos");
			pacienteDAO.atualizar(paciente1);
			System.out.println("Paciente atualizado: " + paciente1.getNome());

			// Teste de deleção
			pacienteDAO.deletar(paciente1.getId());
			System.out.println("Paciente deletado: " + paciente1.getNome());
		} catch (CPFDuplicadoException e) {
			System.out.println("Erro: " + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
