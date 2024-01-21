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
            name = name.trim();
            password = password.trim();
            if(name.length()==0 && password.length()==0){
                throw new Exception("Nom et mot de passe invalide");
            }else
            if (name.length()==0) {
                throw new Exception("Nom invalide");
            }else
            if (password.length()==0) {
                throw new Exception("Mot de passe invalide");
            }
            Client client = new Client();
            client.setName(name);
            client.setPassword(password);
            Connection connection = ConnectionPostgres.connectDefault();
            if (client.clientisExist(connection)) {
                throw new Exception("Modifier l'information s'il vous plait");
            }
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
    
    // login client
    @PostMapping("/authentification_client")
    public Map<String, Object> authentification_client(@RequestBody Map<String, Object> requestBody) {
        Map<String, Object> resultat = new HashMap<>();
        int status = 0;
        String titre = null;
        String message = null;
        Map<String, Object> donnes = new HashMap<>();
        String name = (String) requestBody.get("username");
        String password = (String) requestBody.get("password");
        try {
            name = name.trim();
            password = password.trim();
            if(name.length()==0 && password.length()==0){
                throw new Exception("Nom et mot de passe invalide");
            }else
            if (name.length()==0) {
                throw new Exception("Nom invalide");
            }else
            if (password.length()==0) {
                throw new Exception("Mot de passe invalide");
            }
            Client client = new Client();
            client.setName(name);
            client.setPassword(password);
            Connection connection = ConnectionPostgres.connectDefault();
            client.connect(connection);

            // si le connection est reussi
            String token = Jwts.builder()
                .setSubject("tokentheclient")
                .claim("name", client.getName())
                .claim("password", client.getPassword())
                .claim("idClient", client.getIdClient())
                .signWith(SignatureAlgorithm.HS256, "projetclouds5") // Remplacez "votre-cle-secrete" par une clé secrète réelle
                .compact();
                
                resultat.put("token", token);

            status = 200;
            titre = "Connection du client reussi";
            message = "Excellent , vous avez bien connecter a votre compte , "+client.getName();
            
        } catch (Exception e) {
            status = 500;
            titre = "Connection de compte a echoue";
            message = e.getMessage();
        } finally {
            donnes.put("name", name);
            donnes.put("password", password);
            resultat.put("data", donnes);
            resultat.put("status", status);
            resultat.put("titre", titre);
            resultat.put("message", message);
        }
    
        return resultat;
    }
}
