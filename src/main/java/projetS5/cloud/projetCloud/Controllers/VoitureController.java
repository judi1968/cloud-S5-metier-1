package projetS5.cloud.projetCloud.Controllers;

import org.springframework.beans.factory.support.ManagedList;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projetS5.cloud.projetCloud.Context.PgConnection;
import projetS5.cloud.projetCloud.Model.Bag;
import projetS5.cloud.projetCloud.Model.Tables.*;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

@RestController
public class VoitureController {

    @GetMapping("liste-categories")
    public Bag ListCategoriesVoiture(Model model) throws Exception {
        Connection connection = null;
        Bag bag = new Bag(null, null, null);
        int status = 0;
        try {
            connection = PgConnection.connect();
            List<CategorieVoiture> categorieVoitureList = new CategorieVoiture().read(connection);
            bag = new Bag(null, null, categorieVoitureList);
            status = 200;
        }
        catch (Exception e) {
            bag = new Bag("Selection", e.getMessage(), null);
            status = 500;
        }
        finally {
            if (connection!=null) {   
                if (!connection.isClosed() && connection != null)
                connection.close();
            }
        }

        return bag;
    }

    @GetMapping("liste-marques")
    public Bag ListeMarquesVoiture(Model model) throws Exception {
        Connection connection = null;
        Bag bag = new Bag(null, null, null);
        try {
            connection = PgConnection.connect();
            List<MarqueVoiture> marqueVoitureList = new MarqueVoiture().read(connection);
            bag = new Bag(null, null, marqueVoitureList);
        }
        catch (Exception e) {
            bag = new Bag("Selection", e.getMessage(), null);
        }
        finally {
            if (!connection.isClosed() && connection != null)
                connection.close();
        }

        return bag;
    }

    @GetMapping("liste-types-carburant")
    public Bag ListeTypesCarburantsVoiture(Model model) throws Exception {
        Connection connection = null;
        Bag bag = new Bag(null, null, null);
        try {
            connection = PgConnection.connect();
            List<TypeCarburantVoiture> typeCarburantVoitureList = new TypeCarburantVoiture().read(connection);
            bag = new Bag(null, null, typeCarburantVoitureList);
        }
        catch (Exception e) {
            bag = new Bag("Selection", e.getMessage(), null);
        }
        finally {
            if (!connection.isClosed() && connection != null)
                connection.close();
        }

        return bag;
    }

    @GetMapping("liste-transmissions")
    public Bag ListeTransmissionsVoiture(Model model) throws Exception {
        Connection connection = null;
        Bag bag = new Bag(null, null, null);
        try {
            connection = PgConnection.connect();
            List<TransmissionVoiture> transmissionVoitureList = new TransmissionVoiture().read(connection);
            bag = new Bag(null, null, transmissionVoitureList);
        }
        catch (Exception e) {
            bag = new Bag("Selection", e.getMessage(), null);
        }
        finally {
            if (!connection.isClosed() && connection != null)
                connection.close();
        }

        return bag;
    }


    @GetMapping("liste-freinages")
    public Bag ListeFreinageVoiture(Model model) throws Exception {
        Connection connection = null;
        Bag bag = new Bag(null, null, null);
        try {
            connection = PgConnection.connect();
            List<FreignageVoiture> freignageVoitureList = new FreignageVoiture().read(connection);
            bag = new Bag(null, null, freignageVoitureList);
        }
        catch (Exception e) {
            bag = new Bag("Selection", e.getMessage(), null);
        }
        finally {
            if (!connection.isClosed() && connection != null)
                connection.close();
        }

        return bag;
    }

    @GetMapping("liste-equipements-internes")
    public Bag ListeEquipemenstInternesVoiture(Model model) throws Exception {
        Connection connection = null;
        Bag bag = new Bag(null, null, null);
        try {
            connection = PgConnection.connect();
            List<EquipementInterne> equipementInterneList = new EquipementInterne().read(connection);
            bag = new Bag(null, null, equipementInterneList);
        }
        catch (Exception e) {
            bag = new Bag("Selection", e.getMessage(), null);
        }
        finally {
            if (!connection.isClosed() && connection != null)
                connection.close();
        }

        return bag;
    }


}
