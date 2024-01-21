package projetS5.cloud.projetCloud.Controllers;

import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import projetS5.cloud.projetCloud.Model.DataObjects.Bag;
import projetS5.cloud.projetCloud.Model.DatabaseConnection.ConnectionPostgres;
import projetS5.cloud.projetCloud.Model.Entities.Admin;
import projetS5.cloud.projetCloud.Model.Objects.Client;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ClientController {
    @PostMapping("/create_compte_client")
    public Map<String, Object> create_compte_client(@RequestBody Map<String, Object> requestBody) {
        Map<String, Object> resultat = new HashMap<>();
        int status = 0;
        String titre = null;
        String message = null;
        Map<String, Object> donnes = new HashMap<>();
    
        try {
            String name = (String) requestBody.get("name");
            String password = (String) requestBody.get("password");
            Client client = new Client();
            client.setName(name);
            client.setPassword(password);
            Connection connection = ConnectionPostgres.connectDefault();
            // ConnectionPostgres.loadConfigFromXML();
            // System.out.println("IP : "+ConnectionPostgres.getIp()+" ; PORT : "+ConnectionPostgres.getPort()+" ; USERNAME : "+ConnectionPostgres.getUserName()+" ; PASSWORD : "+ConnectionPostgres.getPassword()+" ; DATABASE : "+ConnectionPostgres.getDatabaseName());
            client.addNewClient(connection);
            status = 200;
            titre = "Creation de compte a fait avec succees";
            message = "Excellent , votre compte a ete bien creer";
            donnes.put("name", name);
            donnes.put("password", password);
            
        } catch (Exception e) {
            status = 500;
            titre = "Creation de compte a echoue";
            message = e.getMessage();
        } finally {
            resultat.put("data", donnes);
            resultat.put("status", status);
                resultat.put("titre", titre);
                resultat.put("message", message);
        }
    
        return resultat;
    }
    
}
