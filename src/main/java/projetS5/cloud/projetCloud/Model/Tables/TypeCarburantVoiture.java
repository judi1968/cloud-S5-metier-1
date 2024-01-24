package projetS5.cloud.projetCloud.Model.Tables;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeCarburantVoiture {
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
        String sql = "INSERT INTO type_carburant_voiture(nom) VALUES (?)";
        PreparedStatement prtmt = connection.prepareStatement(sql);
        prtmt.setString(1, getNom());
        prtmt.executeUpdate();
    }

    public List<TypeCarburantVoiture> read(Connection connection) throws SQLException {
        List<TypeCarburantVoiture> typeCarburantVoitureList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT *FROM type_carburant_voiture");
        while (rs.next()) {
            TypeCarburantVoiture typeCarburantVoiture = new TypeCarburantVoiture();
            typeCarburantVoiture.setId(rs.getString("id"));
            typeCarburantVoiture.setNom(rs.getString("nom"));
            typeCarburantVoitureList.add(typeCarburantVoiture);
        }
        return typeCarburantVoitureList;
    }

    public void update(Connection connection) throws SQLException {
        String sql = "UPDATE type_carburant_voiture SET nom = ?  WHERE id =?";
        PreparedStatement prstmt = connection.prepareStatement(sql);
        prstmt.setString(1, getNom());
        prstmt.setString(2, getId());

        prstmt.executeUpdate();
    }

    public void delete(Connection connection) throws Exception {
        String sql = "DELETE FROM type_carburant_voiture WHERE id = ?";
        try (PreparedStatement prstmt = connection.prepareStatement(sql)){
            prstmt.setString(1, getId());
            prstmt.executeUpdate();
        }
    }
}
