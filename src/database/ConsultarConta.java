package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultarConta {

    public static void main(String[] args) {

        String sql = "SELECT * FROM contas";

        try(Connection conn = ConnectDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery()) {


            while (resultado.next()) {
                int id = resultado.getInt("id");
                String titular = resultado.getString("titular");
                double saldo = resultado.getDouble("saldo");

                System.out.println("----------------------");
                System.out.println("ID: " + id);
                System.out.println("Titular: " + titular);
                System.out.printf("Saldo: R$ %.2f%n", saldo);
                System.out.println("----------------------");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar a conta!");
            e.printStackTrace();
        }
    }
}
