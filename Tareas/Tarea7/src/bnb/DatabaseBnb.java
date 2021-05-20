package bnb;

import database.Database;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fermelli
 */
public class DatabaseBnb extends Database {

    public DatabaseBnb(String database, String hostname, String username, String password) {
        super(database, hostname, username, password);
    }

    public void conectar() {
        try {
            String jdbc = String.format("jdbc:mysql://%s/%s?user=%s&password=%s", getHostname(), getDatabase(), getUsername(), getPassword());
            setConexion(DriverManager.getConnection(jdbc));
        } catch (SQLException ex) {
            System.out.println("Error al establecer conexión: " + ex);
        }
    }
}
