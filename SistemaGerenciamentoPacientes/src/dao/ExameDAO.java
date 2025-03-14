package dao;

import java.sql.SQLException;
import java.util.List;

import exceptions.DataExameInvalidaException;
import model.Exame;

public interface ExameDAO {
	void cadastrar(Exame exame) throws SQLException, DataExameInvalidaException;

	List<Exame> listar();

	void atualizar(Exame exame) throws SQLException;

	void deletar(Long id) throws SQLException;
}
