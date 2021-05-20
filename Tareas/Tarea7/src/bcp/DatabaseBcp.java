package bcp;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import comun.Banco;
import comun.Cuenta;
import database.Database;
import java.util.ArrayList;
import java.util.Locale;
import org.bson.Document;

/**
 *
 * @author fermelli
 */
public class DatabaseBcp extends Database {

    int port;
    MongoClient mongoClient;
    MongoDatabase mongoDatabase;

    public DatabaseBcp(String database, String hostname, int port, String username, String password) {
        super(database, hostname, username, password);
        this.port = port;
        conectar();
    }

    public void conectar() {
        String cadenaConexion = String.format("mongodb://%s:%d", getHostname(), port);
        mongoClient = MongoClients.create(cadenaConexion);
        mongoDatabase = mongoClient.getDatabase(getDatabase());
    }

    public Document obtenerCliente(String ci, String nombres, String apellidos) {
        MongoCollection<Document> clientesCollection = mongoDatabase.getCollection("clientes");
        Document cliente = clientesCollection.find(and(eq("ci", ci), eq("nombres", nombres), eq("apellidos", apellidos))).first();
        return cliente;
    }

    public ArrayList<Cuenta> obtenerCuentasCliente(String ci, String nombres, String apellidos) {
        ArrayList<Cuenta> cuentas = new ArrayList<>();

        Document cliente = obtenerCliente(ci, nombres, apellidos);

        MongoCollection<Document> cuentasCollection = mongoDatabase.getCollection("cuentas");

        if (cliente != null) {
            FindIterable<Document> cuentasIterable = cuentasCollection.find(eq("cliente", cliente.getObjectId("_id")));
            for (Document cuenta : cuentasIterable) {
                String nroCuenta = cuenta.getString("numero");
                Double saldo = cuenta.getDouble("saldo");
                cuentas.add(new Cuenta(ci, nombres, apellidos, nroCuenta, saldo, Banco.BANCO_BCP));
            }
        }
        return cuentas;
    }

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
        Document cliente = obtenerCliente(cuenta.getCi(), cuenta.getNombres(), cuenta.getApellidos());
        if (cliente != null) {
            MongoCollection<Document> cuentasCollection = mongoDatabase.getCollection("cuentas");
            UpdateResult result = cuentasCollection.updateOne(and(eq("numero", cuenta.getNrocuenta()), gte("saldo", monto), eq("cliente", cliente.getObjectId("_id"))), inc("saldo", -monto));
            return result.getModifiedCount() != 0;
        }
        return false;
    }

    public boolean congelarMonto(String nroCuenta, double monto) {
        MongoCollection<Document> cuentasCollection = mongoDatabase.getCollection("cuentas");
        UpdateResult result = cuentasCollection.updateOne(and(eq("numero", nroCuenta), gte("saldo", monto)), inc("saldo", -monto));
        return result.getModifiedCount() != 0;
    }
}
