package petshop.bd.Banco;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDriver {

    private final String nomeBanco;

    public SQLiteDriver(String banco) {
        this.nomeBanco = banco;
    }

    public Connection iniciarConexao() {
        Connection conexao = null;
        try {
            String url;
            url = "jdbc:sqlite:" + this.nomeBanco;
            conexao = DriverManager.getConnection(url);

            if (conexao != null) {
                System.out.println("O nome do driver: " + conexao.getMetaData().getDriverName());
                System.out.println("Um novo banco de dados foi criado");
                try (Statement stmt = conexao.createStatement()) {
                    stmt.execute("PRAGMA foreign_keys = ON;");
                    System.out.println("Chaves estrangeiras habilitadas para esta conexão.");
                } catch (SQLException ePragma) {
                    System.err.println("Erro ao habilitar chaves estrangeiras: " + ePragma.getMessage());
                    ePragma.printStackTrace();
                }
            }

        } catch (SQLException sqe) {
            System.out.println("Problemas na conexao com o banco. Erro: " + sqe.getMessage());
        }
        return conexao;
    }
}
