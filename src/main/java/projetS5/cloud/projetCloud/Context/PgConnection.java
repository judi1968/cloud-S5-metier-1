package projetS5.cloud.projetCloud.Context;


import java.sql.Connection;

import projetS5.cloud.projetCloud.Model.DatabaseConnection.ConnectionPostgres;

public class PgConnection {

    public static Connection connect() throws Exception {
        return ConnectionPostgres.connectDefault();
    }
}
