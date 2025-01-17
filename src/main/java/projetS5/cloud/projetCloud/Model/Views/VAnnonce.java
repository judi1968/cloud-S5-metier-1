package projetS5.cloud.projetCloud.Model.Views;


import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projetS5.cloud.projetCloud.Model.Tables.Annonce;
import projetS5.cloud.projetCloud.Model.Tables.AnnonceValidee;
import projetS5.cloud.projetCloud.Model.Tables.Personne;
import projetS5.cloud.projetCloud.Model.Tables.PersonneAutentification;
import projetS5.cloud.projetCloud.Model.Tables.VoiturePrix;

public class VAnnonce {
    Annonce annonce;
    AnnonceValidee annonceValidee;
    CatalogVoiture catalogVoiture;
    VoiturePrix voiturePrix;
    Personne personneAdmin;
    PersonneAutentification personneAuthUtilisateur;

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    public AnnonceValidee getAnnonceValidee() {
        return annonceValidee;
    }

    public void setAnnonceValidee(AnnonceValidee annonceValidee) {
        this.annonceValidee = annonceValidee;
    }

    public CatalogVoiture getCatalogVoiture() {
        return catalogVoiture;
    }

    public void setCatalogVoiture(CatalogVoiture catalogVoiture) {
        this.catalogVoiture = catalogVoiture;
    }

    public VoiturePrix getVoiturePrix() {
        return voiturePrix;
    }

    public void setVoiturePrix(VoiturePrix voiturePrix) {
        this.voiturePrix = voiturePrix;
    }

    public Personne getPersonneAdmin() {
        return personneAdmin;
    }

    public void setPersonneAdmin(Personne personneAdmin) {
        this.personneAdmin = personneAdmin;
    }

    public PersonneAutentification getPersonneAuthUtilisateur() {
        return personneAuthUtilisateur;
    }

    public void setPersonneAuthUtilisateur(PersonneAutentification personneAuthUtilisateur) {
        this.personneAuthUtilisateur = personneAuthUtilisateur;
    }

    public VAnnonce(Annonce annonce,AnnonceValidee annonceValidee, CatalogVoiture catalogVoiture, VoiturePrix voiturePrix, Personne personneAdmin, PersonneAutentification personneAuthUtilisateur) {
        this.annonceValidee = annonceValidee;
        this.catalogVoiture = catalogVoiture;
        this.voiturePrix = voiturePrix;
        this.personneAdmin = personneAdmin;
        this.personneAuthUtilisateur = personneAuthUtilisateur;
        this.annonce = annonce;
    }

    public VAnnonce () {

    }

    public List<VAnnonce> getAnnoncesValideesBetweenPrices( List<VAnnonce> vAnnonces, double prixMin, double prixMax) throws SQLException {
        List<VAnnonce> annonceValideeList = new ArrayList<>();

        for (VAnnonce vAnnonce : vAnnonces) {
            double prixVoiture = vAnnonce.getVoiturePrix().getPrix();
            if (prixMin <= prixVoiture && prixVoiture <= prixMax) {
                annonceValideeList.add(vAnnonce);
            }
        }
        return annonceValideeList;
    }

    public List<VAnnonce> getAnnoncesValidees(Connection connection) throws Exception {
        List<VAnnonce> annonceValideeList = new ArrayList<>();

        String sql = "SELECT * FROM v_annonce WHERE date_validation is not null and date_fin is null ";
        try (Statement prstmt = connection.createStatement()) {

            try (ResultSet rs = prstmt.executeQuery(sql)) {
                while (rs.next()) {
                    AnnonceValidee annonceValidee = new AnnonceValidee(rs.getDate("date_validation"));
                    Personne personneAdmin = new Personne(rs.getString("nom_admin"), rs.getString("prenom_admin"), rs.getString("address_admin"));
                    PersonneAutentification utilisateur = new PersonneAutentification(rs.getString("utilisateur_id"));;
                    VoiturePrix voiturePrix = new VoiturePrix(rs.getDouble("prix"));
                    CatalogVoiture catalogVoiture = new CatalogVoiture(rs.getDate("annee_fabrication"), rs.getString("couleur"), rs.getDouble("consommation"), rs.getString("nom_categorie"),rs.getString("description_categorie"), rs.getString("nom_marque"), rs.getString("description_marque"), rs.getDate("date_creation_marque"), rs.getString("nom_type_carburant"), rs.getString("nom_transmission"), rs.getString("nom_freignage"));
                    Annonce annonce = new Annonce();
                    annonce.setAnnonceId(rs.getString("annonce_id"));
                    annonce.setDateDebut(Date.valueOf(rs.getString("date_debut")));
                    VAnnonce vAnnonce = new VAnnonce(annonce, annonceValidee, catalogVoiture, voiturePrix, personneAdmin, personneAuthUtilisateur);
                    annonceValideeList.add(vAnnonce);
                }
            }
        }
        return annonceValideeList;
    }
    public List<VAnnonce> getAnnoncesNotValidees(Connection connection) throws Exception {
        List<VAnnonce> annonceValideeList = new ArrayList<>();

        String sql = "SELECT * FROM v_annonce WHERE date_validation is null and date_fin is null ";
        try (Statement prstmt = connection.createStatement()) {

            try (ResultSet rs = prstmt.executeQuery(sql)) {
                while (rs.next()) {
                    AnnonceValidee annonceValidee = new AnnonceValidee(rs.getDate("date_validation"));
                    Personne personneAdmin = new Personne(rs.getString("nom_admin"), rs.getString("prenom_admin"), rs.getString("address_admin"));
                    PersonneAutentification utilisateur = new PersonneAutentification(rs.getString("utilisateur_id"));;
                    VoiturePrix voiturePrix = new VoiturePrix(rs.getDouble("prix"));
                    CatalogVoiture catalogVoiture = new CatalogVoiture(rs.getDate("annee_fabrication"), rs.getString("couleur"), rs.getDouble("consommation"), rs.getString("nom_categorie"),rs.getString("description_categorie"), rs.getString("nom_marque"), rs.getString("description_marque"), rs.getDate("date_creation_marque"), rs.getString("nom_type_carburant"), rs.getString("nom_transmission"), rs.getString("nom_freignage"));
                    Annonce annonce = new Annonce();
                    annonce.setAnnonceId(rs.getString("annonce_id"));
                    annonce.setDateDebut(rs.getDate("date_debut"));
                    VAnnonce vAnnonce = new VAnnonce(annonce,annonceValidee, catalogVoiture, voiturePrix, personneAdmin, personneAuthUtilisateur);
                    annonceValideeList.add(vAnnonce);
                }
            }
        }
        return annonceValideeList;
    }

}
