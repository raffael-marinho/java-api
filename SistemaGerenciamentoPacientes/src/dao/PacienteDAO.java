package dao;

import java.util.List;

import model.Paciente;

public interface PacienteDAO {
	void cadastrar(Paciente paciente);

	List<Paciente> listar();

	void atualizar(Paciente paciente);

	void deletar(Long id);
}
