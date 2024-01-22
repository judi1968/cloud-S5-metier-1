package projetS5.cloud.projetCloud.Controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projetS5.cloud.projetCloud.Context.PgConnection;
import projetS5.cloud.projetCloud.Model.Bag;
import projetS5.cloud.projetCloud.Model.Tables.CategorieVoiture;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("voiture")
public class VoitureController {

    @PostMapping("liste-categorie")
    public Bag create(Model model) throws Exception {
        Connection connection = null;
        Bag bag = new Bag(null, null, null);
        try {
            connection = PgConnection.connect();
            connection.setAutoCommit(false);
            List<CategorieVoiture> categorieVoitureList = new CategorieVoiture().read(connection);
            bag = new Bag(null, null, categorieVoitureList);
        }
        catch (Exception e) {
            connection.rollback();
            bag = new Bag("Selection", e.getMessage(), null);
        }
        finally {
            if (!connection.isClosed() && connection != null)
                connection.close();
        }

        return bag;
    }
}
