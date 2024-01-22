package projetS5.cloud.projetCloud.Controllers;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projetS5.cloud.projetCloud.Context.PgConnection;
import projetS5.cloud.projetCloud.Model.Bag;
import projetS5.cloud.projetCloud.Model.Tables.*;
import projetS5.cloud.projetCloud.Model.Views.VAnnonce;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("annonce")
public class AnnonceController {

    @PostMapping("create")
    public Bag create(@RequestBody double prix, @RequestBody String code_annonce, @RequestBody Date date, @RequestBody Date annee_fabrication, @RequestBody String couleur, @RequestBody double consommation, @RequestBody String categorie_voiture_id, @RequestBody String marque_voiture_id, @RequestBody String type_carburant_voiture_id, @RequestBody String transmission_voiture_id, @RequestBody String freignage_voiture_id  ) throws Exception {
        Connection connection = null;
        Bag bag = new Bag(null, null, null);
        try {
            connection = PgConnection.connect();
            connection.setAutoCommit(false);

            Voiture voiture = new Voiture(annee_fabrication, couleur, consommation, categorie_voiture_id, marque_voiture_id, type_carburant_voiture_id, transmission_voiture_id, freignage_voiture_id, null);
            String voitureId = voiture.create(connection);//Insertion de voiture

            VoiturePrix voiturePrix = new VoiturePrix(date, prix, voitureId);
            voiturePrix.create(connection);//Insertion prix de voiture

            Date dateDebutAnnonce = new Date(new java.util.Date().getTime());//Date Actuel
            String perAuth = null;//SESSION
            Annonce annonce = new Annonce(dateDebutAnnonce, null, code_annonce, voitureId, perAuth);
            annonce.create(connection);//Insertion de l'annonce

            connection.commit();
        }
        catch (Exception e) {
            connection.rollback();
            bag = new Bag("Insertion", e.getMessage(), null);
        }
        finally {
            if (!connection.isClosed() && connection != null)
                connection.close();
        }

        return bag;
    }

    @PostMapping("validees-liste")
    public Bag ListeAnnonceValidee() throws Exception {

        Connection connection = null;
        Bag bag = new Bag(null, null, null);
        try {
            connection = PgConnection.connect();
            List<VAnnonce> annoncesValideesList = new VAnnonce().getAnnoncesValidees(connection);
            bag = new Bag(null, null, annoncesValideesList);
        }
        catch (Exception e) {
            connection.rollback();
            bag = new Bag("Insertion", e.getMessage(), null);
        }
        finally {
            if (!connection.isClosed() && connection != null)
                connection.close();
        }

        return bag;
    }

    @PostMapping("validees-liste-par-prix")
    public Bag ListeAnnonceValideeByPrix(@RequestBody double min_prix, @RequestBody double max_prix) throws Exception {

        Connection connection = null;
        Bag bag = new Bag(null, null, null);
        try {
            connection = PgConnection.connect();
            List<VAnnonce> annonceValideesList = new VAnnonce().getAnnoncesValidees(connection);
            List<VAnnonce> annoncesValideesList1 = new VAnnonce().getAnnoncesValideesBetweenPrices(annonceValideesList, min_prix, max_prix);
            bag = new Bag(null, null, annoncesValideesList1);
        }
        catch (Exception e) {
            connection.rollback();
            bag = new Bag("Insertion", e.getMessage(), null);
        }
        finally {
            if (!connection.isClosed() && connection != null)
                connection.close();
        }

        return bag;
    }

    @PostMapping("validee-create")
    public Bag CreateAnnonceValidee(@RequestBody String annonce_id) throws Exception {

        Connection connection = null;
        Bag bag = new Bag(null, null, null);
        try {
            connection = PgConnection.connect();

            Date dateValidation = new Date(new java.util.Date().getTime());//date actuel
            String personneAuthId = null;//SESSION
            AnnonceValidee annonceValidee = new AnnonceValidee(dateValidation, annonce_id, personneAuthId);
            annonceValidee.create(connection);
        }
        catch (Exception e) {
            connection.rollback();
            bag = new Bag("Insertion", e.getMessage(), null);
        }
        finally {
            if (!connection.isClosed() && connection != null)
                connection.close();
        }

        return bag;

    }
}
