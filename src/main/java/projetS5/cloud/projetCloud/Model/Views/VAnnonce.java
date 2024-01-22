package projetS5.cloud.projetCloud.Model.Views;


import projetS5.cloud.projetCloud.Model.Tables.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public VAnnonce(AnnonceValidee annonceValidee, CatalogVoiture catalogVoiture, VoiturePrix voiturePrix, Personne personneAdmin, PersonneAutentification personneAuthUtilisateur) {
        this.annonceValidee = annonceValidee;
        this.catalogVoiture = catalogVoiture;
        this.voiturePrix = voiturePrix;
        this.personneAdmin = personneAdmin;
        this.personneAuthUtilisateur = personneAuthUtilisateur;
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

        String sql = "SELECT *FROM v_annonce WHERE date_fin != null ";
        try (Statement prstmt = connection.createStatement()) {

            try (ResultSet rs = prstmt.executeQuery(sql)) {
                while (rs.next()) {
                    AnnonceValidee annonceValidee = new AnnonceValidee(rs.getDate("date_validation"));
                    Personne personneAdmin = new Personne(rs.getString("nom_admin"), rs.getString("renom"), rs.getString("address"));
                    PersonneAutentification utilisateur = new PersonneAutentification(rs.getString("utilisateur_id"));;
                    VoiturePrix voiturePrix = new VoiturePrix(rs.getDouble("prix"));
                    CatalogVoiture catalogVoiture = new CatalogVoiture(rs.getDate("annee_fabrication"), rs.getString("couleur"), rs.getDouble("consommation"), rs.getString("nom_categorie"),rs.getString("description_categorie"), rs.getString("nom_marque"), rs.getString("description_marque"), rs.getDate("date_creation"), rs.getString("nom_type_carburant"), rs.getString("nom_transmission"), rs.getString("nom_freignage"));

                    VAnnonce vAnnonce = new VAnnonce(annonceValidee, catalogVoiture, voiturePrix, personneAdmin, personneAuthUtilisateur);
                    annonceValideeList.add(vAnnonce);
                }
            }
        }
        return annonceValideeList;
    }

}
