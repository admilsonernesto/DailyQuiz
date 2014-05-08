package br.com.sidlar.dailyQuiz.domain;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by ADMILSON on 23/04/14.
 */
public class ConnectionFactory {
    public Connection getConnectionMySql() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/dailyquiz", "root", "ROOT");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Este método utilizado para obter uma conexão do pool de conexões que é gerenciado pelo Container(TomCat)
     * @return conexão com mysql conforme arquivo de configuração do TomCat(META-INF/context.xml)
     */
    public Connection getConexao() {
        String JNDINome = "jdbc/dailyquizpool";
        Connection conn = null;
        try {
            // Obtém a raiz da hierarquia de nomes
            InitialContext contexto= new InitialContext();
            // Obtém a origem dos dados
            DataSource ds = (DataSource)contexto.lookup("java:comp/env/" + JNDINome);

            // Obtém uma conexão
            conn = ds.getConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        // Retorna a conexão
        return conn;
    }
}
