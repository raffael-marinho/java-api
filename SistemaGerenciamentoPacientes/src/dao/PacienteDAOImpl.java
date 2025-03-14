package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Paciente;
import util.DatabaseConnection;

public class PacienteDAOImpl implements PacienteDAO {
	private Connection connection;

	public PacienteDAOImpl() {
		this.connection = DatabaseConnection.getConnection();
	}

	@Override
	public void cadastrar(Paciente paciente) {
		String sql = "INSERT INTO PACIENTES (cpf, nome) VALUES (?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, paciente.getCpf());
			stmt.setString(2, paciente.getNome());
			stmt.executeUpdate();
			System.out.println("Paciente cadastrado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Paciente> listar() {
		List<Paciente> pacientes = new ArrayList<>();
		String sql = "SELECT * FROM PACIENTES";
		try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Paciente paciente = new Paciente();
				paciente.setId(rs.getLong("id"));
				paciente.setCpf(rs.getString("cpf"));
				paciente.setNome(rs.getString("nome"));
				pacientes.add(paciente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pacientes;
	}

	@Override
	public void atualizar(Paciente paciente) {
		String sql = "UPDATE PACIENTES SET cpf = ?, nome = ? WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, paciente.getCpf());
			stmt.setString(2, paciente.getNome());
			stmt.setLong(3, paciente.getId());
			stmt.executeUpdate();
			System.out.println("Paciente atualizado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletar(Long id) {
		String sql = "DELETE FROM PACIENTES WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, id);
			stmt.executeUpdate();
			System.out.println("Paciente deletado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
