package projetS5.cloud.projetCloud.Model.Tables;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class Annonce {
    String annonceId;
    Date dateDebut;
    Date dateFin;
    String codeAnnonce;
    String voitureId;
    String personneAutentificationId;

    Voiture voiture;
    Personne personne;

    public String getAnnonceId() {
        return annonceId;
    }

    public void setAnnonceId(String annonceId) {
        this.annonceId = annonceId;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getCodeAnnonce() {
        return codeAnnonce;
    }

    public void setCodeAnnonce(String codeAnnonce) {
        this.codeAnnonce = codeAnnonce;
        if (codeAnnonce == null && codeAnnonce.isEmpty()) {
            this.codeAnnonce = "An"+getVoitureId()+getPersonneAutentificationId();
        }
    }

    public String getVoitureId() {
        return voitureId;
    }

    public void setVoitureId(String voitureId) {
        this.voitureId = voitureId;
    }

    public String getPersonneAutentificationId() {
        return personneAutentificationId;
    }

    public void setPersonneAutentificationId(String personneAutentificationId) {
        this.personneAutentificationId = personneAutentificationId;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Annonce(Date dateDebut, Date dateFin, String codeAnnonce, String voitureId, String personneAutentificationId) {
        this.setDateDebut(dateDebut);
        this.setDateFin(dateFin);
        this.setCodeAnnonce(codeAnnonce);
        this.setVoitureId(voitureId);
        this.setPersonneAutentificationId(personneAutentificationId);
    }

    public Annonce() {
        //TODO Auto-generated constructor stub
    }

    public void create(Connection connection) throws Exception {
        String sql = "INSERT INTO annonce(date_debut, date_fin, code_annonce, voiture_id, personne_autentification_id) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement prstmt = connection.prepareStatement(sql);
        prstmt.setDate(1, getDateDebut());
        prstmt.setDate(2, getDateFin());
        prstmt.setString(3, getCodeAnnonce());
        prstmt.setString(4, getVoitureId());
        prstmt.setString(5, getPersonneAutentificationId());

        prstmt.executeUpdate();
    }


}
