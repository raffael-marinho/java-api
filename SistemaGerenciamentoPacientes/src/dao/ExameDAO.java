package dao;

import java.util.List;

import model.Exame;

public interface ExameDAO {
	void cadastrar(Exame exame);

	List<Exame> listar();

	void atualizar(Exame exame);

	void deletar(Long id);
}
