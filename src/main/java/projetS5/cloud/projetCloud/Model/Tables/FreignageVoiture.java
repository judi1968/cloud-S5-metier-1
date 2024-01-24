package projetS5.cloud.projetCloud.Model.Tables;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FreignageVoiture {
    String id;
    String nom;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void create(Connection connection) throws SQLException {
        String sql = "INSERT INTO freignage_voiture(nom) VALUES (?)";
        PreparedStatement prtmt = connection.prepareStatement(sql);
        prtmt.setString(1, getNom());
        prtmt.executeUpdate();
    }

    public List<FreignageVoiture> read(Connection connection) throws SQLException {
        List<FreignageVoiture> freignageVoitureList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT *FROM freignage_voiture");
        while (rs.next()) {
            FreignageVoiture freignageVoiture = new FreignageVoiture();
            freignageVoiture.setId(rs.getString("id"));
            freignageVoiture.setNom(rs.getString("nom"));
            freignageVoitureList.add(freignageVoiture);
        }
        return freignageVoitureList;
    }

    public void update(Connection connection) throws SQLException {
        String sql = "UPDATE freignage_voiture SET nom = ?  WHERE id =?";
        PreparedStatement prstmt = connection.prepareStatement(sql);
        prstmt.setString(1, getNom());
        prstmt.setString(2, getId());

        prstmt.executeUpdate();
    }

    public void delete(Connection connection) throws SQLException {
        String sql = "DELETE FROM freignage_voiture WHERE id = ?";
        try (PreparedStatement prstmt = connection.prepareStatement(sql)){
            prstmt.setString(1, getId());
            prstmt.executeUpdate();
        }
    }
}
