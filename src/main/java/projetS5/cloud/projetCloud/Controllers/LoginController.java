package projetS5.cloud.projetCloud.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import projetS5.cloud.projetCloud.Context.PgsqlContext;
import projetS5.cloud.projetCloud.Model.DataObjects.Bag;
import projetS5.cloud.projetCloud.Model.Entities.Admin;

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
    public Map initializer(@RequestParam String name,@RequestParam String password) {
		Map resultat = new HashMap();
		int status = 0;
		String titre = null;
		String message = null;
		Map data = new HashMap();
		Vector<String> donnes = new Vector<>();
		try {
            donnes.add(name);
            donnes.add(password);

			status = 200;
			titre = "Login du VaikaNet";
			message = "Vous etes le bienvenue sur le projet";
		}catch (Exception e) {
			status = 500;
			titre = "Prendre des articles a echoue";
			message = e.getMessage();
		}finally {
			resultat.put("status",status);
			resultat.put("titre",titre);
			resultat.put("message",message);
			resultat.put("data",donnes);
			return resultat;
		}
	}
}
