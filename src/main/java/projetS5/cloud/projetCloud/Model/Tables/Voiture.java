package projetS5.cloud.projetCloud.Model.Tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

public class Voiture {

    String id;
    Date anneeFabrication;
    String couleur;
    double consommation;
    String categorieVoitureId;
    String marqueVoitureId;
    String typeCarburantId;
    String transmissionVoitureId;
    String freignageVoitureId;
    List<EquipementInterne> equipementInterneList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getAnneeFabrication() {
        return anneeFabrication;
    }

    public void setAnneeFabrication(Date anneeFabrication) {
        this.anneeFabrication = anneeFabrication;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public double getConsommation() {
        return consommation;
    }

    public void setConsommation(double consommation) {
        this.consommation = consommation;
    }

    public String getCategorieVoitureId() {
        return categorieVoitureId;
    }

    public void setCategorieVoitureId(String categorieVoitureId) {
        this.categorieVoitureId = categorieVoitureId;
    }

    public String getMarqueVoitureId() {
        return marqueVoitureId;
    }

    public void setMarqueVoitureId(String marqueVoitureId) {
        this.marqueVoitureId = marqueVoitureId;
    }

    public String getTypeCarburantId() {
        return typeCarburantId;
    }

    public void setTypeCarburantId(String typeCarburantId) {
        this.typeCarburantId = typeCarburantId;
    }

    public String getTransmissionVoitureId() {
        return transmissionVoitureId;
    }

    public void setTransmissionVoitureId(String transmissionVoitureId) {
        this.transmissionVoitureId = transmissionVoitureId;
    }

    public String getFreignageVoitureId() {
        return freignageVoitureId;
    }

    public void setFreignageVoitureId(String freignageVoitureId) {
        this.freignageVoitureId = freignageVoitureId;
    }


    public List<EquipementInterne> getEquipementInterneList() {
        return equipementInterneList;
    }

    public void setEquipementInterneList(List<EquipementInterne> equipementInterneList) {
        this.equipementInterneList = equipementInterneList;
    }

    public Voiture(Date anneeFabrication, String couleur, double consommation, String categorieVoitureId, String marqueVoitureId, String typeCarburantId, String transmissionVoitureId, String freignageVoitureId, List<EquipementInterne> equipementInterneList) {
        this.setAnneeFabrication(anneeFabrication);
        this.setCouleur(couleur);
        this.setConsommation(consommation);
        this.setCategorieVoitureId(categorieVoitureId);
        this.setMarqueVoitureId(marqueVoitureId);
        this.setTypeCarburantId(typeCarburantId);
        this.setTransmissionVoitureId(transmissionVoitureId);
        this.setFreignageVoitureId(freignageVoitureId);
        this.setEquipementInterneList(equipementInterneList);
    }

    public Voiture () {

    }

    public String create(Connection connection) throws Exception {
        String sql = "INSERT INTO voiture (annee_fabrication, couleur, consommation, categorie_voiture_id, marque_voiture_id, type_carburant_id, transmission_voiture_id, freignage_voiture_id) VALUES" +
                "(?, ?, ?, ?, ?, ?, ?, ?) RETURNING voiture_id";
        try (PreparedStatement prstmt = connection.prepareStatement(sql)) {

            prstmt.setDate(1, getAnneeFabrication());
            prstmt.setString(2, getCouleur());
            prstmt.setDouble(3, getConsommation());
            prstmt.setString(4, getCategorieVoitureId());
            prstmt.setString(5, getMarqueVoitureId());
            prstmt.setString(6, getTypeCarburantId());
            prstmt.setString(7, getTransmissionVoitureId());
            prstmt.setString(8, getFreignageVoitureId());

            try (ResultSet rs = prstmt.executeQuery(sql)) {
                if (rs.next()) {
                    return rs.getString("voiture_id");
                }
            }
        }
        return null;
    }
}
