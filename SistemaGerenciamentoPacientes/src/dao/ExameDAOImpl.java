package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.DataExameInvalidaException;
import model.Exame;
import util.DatabaseConnection;

public class ExameDAOImpl implements ExameDAO {
	private Connection connection;

	public ExameDAOImpl() {
		this.connection = DatabaseConnection.getConnection();
	}

	@Override
	public void cadastrar(Exame exame) throws SQLException, DataExameInvalidaException {
		if (exame.getDataExame() == null) {
			throw new DataExameInvalidaException("A data do exame não pode ser nula.");
		}

		String sql = "INSERT INTO EXAMES (descricao, data_exame, paciente_id) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, exame.getDescricao());
			stmt.setDate(2, new java.sql.Date(exame.getDataExame().getTime()));
			stmt.setLong(3, exame.getPacienteId());
			stmt.executeUpdate();

			// Recupera o ID gerado pelo banco de dados
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				exame.setId(rs.getLong(1));
			}

			System.out.println("Exame cadastrado com sucesso! ID: " + exame.getId());
		}
	}

	@Override
	public List<Exame> listar() {
		List<Exame> exames = new ArrayList<>();
		String sql = "SELECT * FROM EXAMES";
		try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Exame exame = new Exame();
				exame.setId(rs.getLong("id"));
				exame.setDescricao(rs.getString("descricao"));
				exame.setDataExame(rs.getDate("data_exame"));
				exame.setPacienteId(rs.getLong("paciente_id"));
				exames.add(exame);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exames;
	}

	@Override
	public void atualizar(Exame exame) throws SQLException {
		String sql = "UPDATE EXAMES SET descricao = ?, data_exame = ?, paciente_id = ? WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, exame.getDescricao());
			stmt.setDate(2, new java.sql.Date(exame.getDataExame().getTime()));
			stmt.setLong(3, exame.getPacienteId());
			stmt.setLong(4, exame.getId());
			stmt.executeUpdate();
			System.out.println("Exame atualizado com sucesso!");
		}
	}

	@Override
	public void deletar(Long id) throws SQLException {
		String sql = "DELETE FROM EXAMES WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, id);
			stmt.executeUpdate();
			System.out.println("Exame deletado com sucesso!");
		}
	}

}
