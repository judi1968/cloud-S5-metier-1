package projetS5.cloud.projetCloud.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import projetS5.cloud.projetCloud.Context.PgsqlContext;
import projetS5.cloud.projetCloud.Model.DataObjects.Bag;
import projetS5.cloud.projetCloud.Model.Entities.Admin;
import projetS5.cloud.projetCloud.Model.JsonDataObjects.Login;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

@RestController
public class LoginController {

    @PostMapping("admin")
    public Bag Login(HttpServletRequest request) throws SQLException {
        String exception = null;
        Object object = null;
        Connection connection = null;
        try {
            //connection = PgsqlContext.connect();
            String email = request.getParameter("name");
            String password = request.getParameter("password");

            String adminId = Admin.login(connection, email, password);
            object = password;
            exception = email;
        }
        catch (Exception e) {
            //exception = e.getMessage();
        }
        finally {
            if (!connection.isClosed() && connection != null) connection.close();
        }

        return new Bag(exception, object);
    }

    @PostMapping("/log_admin_traitement")
    public Map<String, Object> initializer(@RequestBody Map<String, Object> requestBody) {
        Map<String, Object> resultat = new HashMap<>();
        int status = 0;
        String titre = null;
        String message = null;
        Map<String, Object> data = new HashMap<>();
        Vector<String> donnes = new Vector<>();

        try {
            String name = (String) requestBody.get("name");
            donnes.add(name);
            donnes.add((String) requestBody.get("password"));
            if (name.compareToIgnoreCase("judi")!=0) {
                throw new Exception("Nom non valider");
            }
            // Générer un token JWT
            String token = Jwts.builder()
                .setSubject(name)
                .signWith(SignatureAlgorithm.HS256, "PER_AT0001") // Remplacez "votre-cle-secrete" par une clé secrète réelle : eto zao izy idPersonne
                .compact();
            status = 200;
            titre = "S'authentification VaikaNet";
            message = "Vous êtes le bienvenu sur le projet";
            data.put("token", token);
        } catch (Exception e) {
            status = 500;
            titre = "Authentification a échoué";
            message = e.getMessage();
        } finally {
            resultat.put("status", status);
            resultat.put("titre", titre);
            resultat.put("message", message);
            resultat.put("data", donnes);
            return resultat;
        }
    }
}
