package com.example.back_office.Model.Views;

import com.example.back_office.Model.Tables.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VAnnonce {
    Annonce annonce;
    AnnonceValidee annonceValidee;
    Voiture voiture;
    VoiturePrix voiturePrix;
    PersonneAutentification personneAuthAdmin;
    PersonneAutentification personneAuthUtilisateur;

    public List<VAnnonce> read(Connection connection) throws SQLException {
        List<VAnnonce> annonceValideeList = new ArrayList<>();
        String sql = "SELECT *FROM v_annonce WHERE date_fin != null";
        try (PreparedStatement prstmt = connection.prepareStatement(sql)) {

        }
        return annonceValideeList;
    }

}
