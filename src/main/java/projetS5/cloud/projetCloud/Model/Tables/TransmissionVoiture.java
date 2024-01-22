package projetS5.cloud.projetCloud.Model.Tables;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransmissionVoiture {
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
        String sql = "INSERT INTO transmission_voiture(nom) VALUES (?)";
        PreparedStatement prtmt = connection.prepareStatement(sql);
        prtmt.setString(1, getNom());
        prtmt.executeUpdate();
    }

    public List<TransmissionVoiture> read(Connection connection) throws SQLException {
        List<TransmissionVoiture> transmissionVoitureList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT *FROM transmission_voiture");
        while (rs.next()) {
            TransmissionVoiture transmissionVoiture = new TransmissionVoiture();
            transmissionVoiture.setId(rs.getString("id"));
            transmissionVoiture.setNom(rs.getString("nom"));
            transmissionVoitureList.add(transmissionVoiture);
        }
        return transmissionVoitureList;
    }

    public void update(Connection connection) throws SQLException {
        String sql = "UPDATE transmission_voiture SET nom = ?  WHERE id =?";
        PreparedStatement prstmt = connection.prepareStatement(sql);
        prstmt.setString(1, getNom());
        prstmt.setString(2, getId());

        prstmt.executeUpdate();
    }
}
