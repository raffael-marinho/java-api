package dao;

import java.sql.SQLException;
import java.util.Date;

import exceptions.DataExameInvalidaException;
import model.Exame;

public class TesteExameDAO {
    public static void main(String[] args) {
    	ExameDAO exameDAO = new ExameDAOImpl();

        try {
        	 // Teste de cadastro
            Exame exame1 = new Exame("Exame de Sangue", new Date(System.currentTimeMillis()), Long.valueOf(5));
            exameDAO.cadastrar(exame1);
            System.out.println("Exame cadastrado: " + exame1.getDescricao());

            // Teste de listagem
            System.out.println("Listando exames:");
            for (Exame e : exameDAO.listar()) {
                System.out.println(e);
            }

            // Teste de atualização
            exame1.setDescricao("Exame de Sangue Completo");
            exameDAO.atualizar(exame1);
            System.out.println("Exame atualizado: " + exame1.getDescricao());

            // Teste de deleção
            exameDAO.deletar(exame1.getId());
            System.out.println("Exame deletado: " + exame1.getDescricao());
        } catch (DataExameInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}