package com.example.back_office.Model.Views;

import com.example.back_office.Model.Tables.EquipementInterne;

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



}
