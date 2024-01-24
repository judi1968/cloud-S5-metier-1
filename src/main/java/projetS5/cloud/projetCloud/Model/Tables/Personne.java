package projetS5.cloud.projetCloud.Model.Tables;

import java.sql.*;

public class Personne {
    String id;
    String nom;
    String prenom;
    String address;
    Date dateNaissance;
    String telephone;
    int sexe;

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getSexe() {
        return sexe;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
    }

    public Personne(String id, String nom, String prenom, String address, Date dateNaissance, String telephone, int sexe) {
        this.setId(id);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setAddress(address);
        this.setDateNaissance(dateNaissance);
        this.setTelephone(telephone);
        this.setSexe(sexe);
    }

    public Personne(String nom, String prenom, String address) {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setAddress(address);
    }
    public Personne(String id) {
        this.setId(id);
    }

    public Personne() {

    }

    public String create (Connection connection) throws Exception {
        String sql = "INSERT INTO personne(nom, prenom, address, date_naissance, telephone, sexe) VALUES (?, ?, ?, ?, ?) RETURNING id";
        try (PreparedStatement prstmt = connection.prepareStatement(sql)){
            prstmt.setString(1, getNom());
            prstmt.setString(2, getPrenom());
            prstmt.setString(3, getAddress());
            prstmt.setDate(4, getDateNaissance());
            prstmt.setInt(5, getSexe());

            try (ResultSet rs = prstmt.executeQuery()){
                if (rs.next()) {
                    return rs.getString("id");
                }
            }
        }
        return null;
    }

    public void delete(Connection connection) throws Exception {
        String sql = "DELETE FROM personne WHERE id = '"+getId()+"'";
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
        }
    }

    public Personne getPersonne(Connection connection, String id) throws SQLException {
        String sql = "SELECT *FROM personne WHERE id = ?";
        try (PreparedStatement prstmt = connection.prepareStatement(sql)){
            prstmt.setString(1, id);
            try (ResultSet rs = prstmt.executeQuery()){
                if (rs.next()) {
                    Personne personne = new Personne(
                        rs.getString("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("address"),
                        rs.getDate("date_naissance"),
                        rs.getString("telephone"),
                        rs.getInt("sexe")
                    );
                    return personne;
                }
            }
        }
        return null;
    }


}
