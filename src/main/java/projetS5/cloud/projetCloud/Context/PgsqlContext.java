package projetS5.cloud.projetCloud.Context;

import java.sql.Connection;

import projetS5.cloud.projetCloud.Model.DatabaseConnection.ConnectionPostgres;

public class PgsqlContext {

    private static final String host = "localhost:5432";
    private static final String user = "postgres";
    private static final String password = "Etu002057";
    private static final String database = "vente_voiture";

    public static Connection connect() throws Exception {

        return ConnectionPostgres.connectDefault();
    }
}
