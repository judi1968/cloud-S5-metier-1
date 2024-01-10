package projetS5.cloud.projetCloud.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projetS5.cloud.projetCloud.Context.PgsqlContext;
import projetS5.cloud.projetCloud.Model.DataObjects.Bag;
import projetS5.cloud.projetCloud.Model.Entities.Admin;

import java.sql.Connection;
import java.sql.SQLException;

@RestController
@RequestMapping("login")
public class LoginController {

    @PostMapping("admin")
    public Bag Login(HttpServletRequest request) throws SQLException {
        String exception = null;
        Object object = null;
        Connection connection = null;
        try {
            connection = PgsqlContext.connect();
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
}
