package mercantil;

import database.Database;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fermelli
 */
public class DatabaseMercantil extends Database {

    int port;

    public DatabaseMercantil(String database, String hostname, int port, String username, String password) {
        super(database, hostname, username, password);
        this.port = port;
    }

    public void conectar() {
        try {
            String jdbc = String.format("jdbc:postgresql://%s:%d/%s", getHostname(), port, getDatabase());
            setConexion(DriverManager.getConnection(jdbc, getUsername(), getPassword()));
        } catch (SQLException ex) {
            System.out.println("Error al establecer conexión: " + ex);
        }
    }
}
