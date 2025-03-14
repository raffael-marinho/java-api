package dao;

import java.sql.SQLException;
import java.util.List;

import exceptions.CPFDuplicadoException;
import model.Paciente;

public interface PacienteDAO {
	void cadastrar(Paciente paciente) throws CPFDuplicadoException, SQLException;

	List<Paciente> listar();

	void atualizar(Paciente paciente) throws SQLException;

	void deletar(Long id) throws SQLException;
}
