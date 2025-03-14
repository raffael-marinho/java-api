package view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Exame;

public class TabelaExameModel extends AbstractTableModel {

	private List<Exame> exames;
	private String[] colunas = { "ID", "Descrição", "Data do Exame", "ID do Paciente" };

	public TabelaExameModel(List<Exame> exames) {
		this.exames = exames;
	}

	@Override
	public int getRowCount() {
		return exames.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Exame exame = exames.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return exame.getId();
		case 1:
			return exame.getDescricao();
		case 2:
			return exame.getDataExame();
		case 3:
			return exame.getPacienteId();
		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}
}