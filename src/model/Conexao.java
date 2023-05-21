package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class Conexao {

    public Connection conexaoBD() throws ClassNotFoundException {

        Connection connect = null;

        try {
            String url = "jdbc:mysql://localhost:3306/dbbibliotecaisptec?user=root&password=";
            connect = DriverManager.getConnection(url);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro aqui" + e.getMessage());
        }
        return connect;
    }

}
