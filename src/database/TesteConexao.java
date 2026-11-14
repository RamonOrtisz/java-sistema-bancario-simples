package database;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) {

        try (Connection conn = ConnectDB.conectar()) {

            System.out.println("Conexao realizada com sucesso!");
            System.out.println("Banco conectado: " + conn.getCatalog());

        } catch (SQLException e) {

            System.out.println("Erro ao conectar com o banco de dados!");
            e.printStackTrace();

        }
    }
}
