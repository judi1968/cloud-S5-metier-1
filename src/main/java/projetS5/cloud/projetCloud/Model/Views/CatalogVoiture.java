package projetS5.cloud.projetCloud.Model.Views;


import projetS5.cloud.projetCloud.Model.Tables.EquipementInterne;

import java.sql.Date;
import java.util.List;

public class CatalogVoiture {

    String id;
    Date anneeFabrication;
    String couleur;
    double consommation;
    String categorieVoitureId;
    String marqueVoitureId;
    String typeCarburantId;
    String transmissionVoitureId;
    String freignageVoitureId;
    String categorieVoitureNom;
    String categorieVoitureDescription;
    String marqueVoitureNom;
    String marqueVoitureDescription;
    Date marqueVoitureDateCretion;
    String typeCarburantNom;
    String transmissionVoitureNom;
    String freignageVoitureNom;

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

    public String getCategorieVoitureNom() {
        return categorieVoitureNom;
    }

    public void setCategorieVoitureNom(String categorieVoitureNom) {
        this.categorieVoitureNom = categorieVoitureNom;
    }

    public String getCategorieVoitureDescription() {
        return categorieVoitureDescription;
    }

    public void setCategorieVoitureDescription(String categorieVoitureDescription) {
        this.categorieVoitureDescription = categorieVoitureDescription;
    }

    public String getMarqueVoitureNom() {
        return marqueVoitureNom;
    }

    public void setMarqueVoitureNom(String marqueVoitureNom) {
        this.marqueVoitureNom = marqueVoitureNom;
    }

    public String getMarqueVoitureDescription() {
        return marqueVoitureDescription;
    }

    public void setMarqueVoitureDescription(String marqueVoitureDescription) {
        this.marqueVoitureDescription = marqueVoitureDescription;
    }

    public Date getMarqueVoitureDateCretion() {
        return marqueVoitureDateCretion;
    }

    public void setMarqueVoitureDateCretion(Date marqueVoitureDateCretion) {
        this.marqueVoitureDateCretion = marqueVoitureDateCretion;
    }

    public String getTypeCarburantNom() {
        return typeCarburantNom;
    }

    public void setTypeCarburantNom(String typeCarburantNom) {
        this.typeCarburantNom = typeCarburantNom;
    }

    public String getTransmissionVoitureNom() {
        return transmissionVoitureNom;
    }

    public void setTransmissionVoitureNom(String transmissionVoitureNom) {
        this.transmissionVoitureNom = transmissionVoitureNom;
    }

    public String getFreignageVoitureNom() {
        return freignageVoitureNom;
    }

    public void setFreignageVoitureNom(String freignageVoitureNom) {
        this.freignageVoitureNom = freignageVoitureNom;
    }

    public List<EquipementInterne> getEquipementInterneList() {
        return equipementInterneList;
    }

    public void setEquipementInterneList(List<EquipementInterne> equipementInterneList) {
        this.equipementInterneList = equipementInterneList;
    }

    public CatalogVoiture(Date anneeFabrication, String couleur, double consommation, String categorieVoitureNom, String categorieVoitureDescription, String marqueVoitureNom, String marqueVoitureDescription, Date marqueVoitureDateCretion, String typeCarburantNom, String transmissionVoitureNom, String freignageVoitureNom) {
        this.anneeFabrication = anneeFabrication;
        this.couleur = couleur;
        this.consommation = consommation;
        this.categorieVoitureNom = categorieVoitureNom;
        this.categorieVoitureDescription = categorieVoitureDescription;
        this.marqueVoitureNom = marqueVoitureNom;
        this.marqueVoitureDescription = marqueVoitureDescription;
        this.marqueVoitureDateCretion = marqueVoitureDateCretion;
        this.typeCarburantNom = typeCarburantNom;
        this.transmissionVoitureNom = transmissionVoitureNom;
        this.freignageVoitureNom = freignageVoitureNom;
    }
}
