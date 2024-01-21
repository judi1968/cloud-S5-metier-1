package projetS5.cloud.projetCloud.Model.Objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import projetS5.cloud.projetCloud.Model.DatabaseConnection.ConnectionPostgres;

public class Client {

    private String idClient;
    private String name;
    private String password;
    private Timestamp dateCreationCompte;

    // Constructeur par défaut
    public Client() {
    }

    // Constructeur avec tous les paramètres
    public Client(String idClient, String name, String password, Timestamp dateCreationCompte) {
        this.idClient = idClient;
        this.name = name;
        this.password = password;
        this.dateCreationCompte = dateCreationCompte;
    }

    // Getters et Setters
    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getDateCreationCompte() {
        return dateCreationCompte;
    }

    public void setDateCreationCompte(Timestamp dateCreationCompte) {
        this.dateCreationCompte = dateCreationCompte;
    }

    public void addNewClient(Connection connection) throws Exception{
        String query = "INSERT INTO client (id_client, name, password, date_creation_compte) VALUES (generate_client_id(), ? , ? , CURRENT_TIMESTAMP)";
        PreparedStatement statement = null;
		ResultSet resultset= null;
		boolean statementOpen = false;
		boolean resultsetOpen = false;
		boolean closeable = false;
		try {
            if(connection==null) {
                connection = ConnectionPostgres.connectDefault();
				connection.setAutoCommit(false);
                closeable = true;
			}
			
			statement = connection.prepareStatement(query);
            statement.setString(1, this.getName());
			statement.setString(2, this.getPassword());

			statementOpen = true;
			
			statement.executeUpdate();
            statement.close();
		}catch (Exception e) {
			throw e;
		}finally {
			if(statementOpen) {
				statement.close();
			}
			if(resultsetOpen) {
				resultset.close();
			}
			if(closeable) {
				connection.commit();
				connection.close();
			}
		}
    }
}

