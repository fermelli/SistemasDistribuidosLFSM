package database;

import comun.Banco;
import comun.Cuenta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author fermelli
 */
public class Database implements IDatabase {

    String database;
    String hostname;
    String username;
    String password;
    Connection conexion = null;

    public Database(String database, String hostname, String username, String password) {
        this.database = database;
        this.hostname = hostname;
        this.username = username;
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public void conectar() {
    }

    public void desconectar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar conexión: " + ex);
        }
    }

    @Override
    public int obtenerIdCliente(String ci, String nombres, String apellidos) {
        ResultSet rs = null;
        Statement stmt = null;
        int id = -1;
        try {
            conectar();
            String query = String.format("SELECT id FROM clientes WHERE LOWER(ci)=LOWER('%s') AND LOWER(nombres)=LOWER('%s') AND LOWER(apellidos)=LOWER('%s')", ci, nombres, apellidos);
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta: " + ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }

                stmt = null;
            }
            desconectar();
        }
        return id;
    }

    @Override
    public ArrayList<Cuenta> obtenerCuentasCliente(String ci, String nombres, String apellidos) {
        int idCliente = obtenerIdCliente(ci, nombres, apellidos);
        ResultSet rs = null;
        Statement stmt = null;
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        if (idCliente != -1) {
            try {
                conectar();
                String query = String.format("SELECT numero, saldo FROM cuentas where cliente_id=%d", idCliente);
                stmt = conexion.createStatement();
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Cuenta cuenta = new Cuenta(ci, nombres, apellidos, rs.getString("numero"), rs.getDouble("saldo"), Banco.BANCO_BNB);
                    cuentas.add(cuenta);
                }
            } catch (SQLException ex) {
                System.out.println("Error en la consulta: " + ex);
            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }

                    rs = null;
                }

                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }

                    stmt = null;
                }
                desconectar();
            }
        }
        return cuentas;
    }

    @Override
    public String obtenerCadenaCuentasCliente(String ci, String nombres, String apellidos) {
        ArrayList<Cuenta> cuentas = obtenerCuentasCliente(ci, nombres, apellidos);
        String cadenaCuentas = "";
        int tamanio = cuentas.size();
        for (int i = 0; i < tamanio; i++) {
            cadenaCuentas += String.format(Locale.ROOT, "%s-%.4f", cuentas.get(i).getNrocuenta(), cuentas.get(i).getSaldo());
            if (i < tamanio - 1) {
                cadenaCuentas += ":";
            }
        }
        return cadenaCuentas;
    }

    public boolean congelarMonto(Cuenta cuenta, double monto) {
        int idCliente = obtenerIdCliente(cuenta.getCi(), cuenta.getNombres(), cuenta.getApellidos());
        ResultSet rs = null;
        Statement stmt = null;
        int response = 0;
        if (idCliente != -1) {
            try {
                conectar();
                String query = String.format(Locale.ROOT, "UPDATE cuentas SET saldo=saldo-%.4f WHERE saldo >= %.4f AND numero='%s' AND cliente_id=%d", monto, monto, cuenta.getNrocuenta(), idCliente);
                stmt = conexion.createStatement();
                response = stmt.executeUpdate(query);
                return response == 1;
            } catch (SQLException ex) {
                System.out.println("Error en la consulta: " + ex);
            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }

                    rs = null;
                }

                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }

                    stmt = null;
                }
                desconectar();
            }
        }
        return response == 1;
    }

    public boolean congelarMonto(String nroCuenta, double monto) {
        ResultSet rs = null;
        Statement stmt = null;
        int response = 0;
        try {
            conectar();
            String query = String.format(Locale.ROOT, "UPDATE cuentas SET saldo=saldo-%.4f WHERE saldo >= %.4f AND numero='%s'", monto, monto, nroCuenta);
            stmt = conexion.createStatement();
            response = stmt.executeUpdate(query);
            return response == 1;
        } catch (SQLException ex) {
            System.out.println("Error en la consulta: " + ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }

                stmt = null;
            }
            desconectar();
        }
        return response == 1;
    }
}
