package view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Paciente;

public class TabelaPacienteModel extends AbstractTableModel {

    private List<Paciente> pacientes;
    private String[] colunas = {"ID", "CPF", "Nome"};

    public TabelaPacienteModel(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public int getRowCount() {
        return pacientes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Paciente paciente = pacientes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return paciente.getId();
            case 1:
                return paciente.getCpf();
            case 2:
                return paciente.getNome();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
}
