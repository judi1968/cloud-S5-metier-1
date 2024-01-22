package projetS5.cloud.projetCloud.Model.Tables;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class VoiturePrix {

    String voiturePrixId;
    Date date;
    double prix;
    String voitureId;

    public String getVoiturePrixId() {
        return voiturePrixId;
    }

    public void setVoiturePrixId(String voiturePrixId) {
        this.voiturePrixId = voiturePrixId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getVoitureId() {
        return voitureId;
    }

    public void setVoitureId(String voitureId) {
        this.voitureId = voitureId;
    }

    public VoiturePrix(Date date, double prix, String voitureId) {
        this.setDate(date);
        this.setPrix(prix);
        this.setVoitureId(voitureId);
    }

    public VoiturePrix(double prix) {
        this.setPrix(prix);
    }

    public void create(Connection connection) throws Exception {
        String sql = "INSERT INTO voiture_prix(date, prix, voiture_id) VALUES (?, ?, ?)";
        try (PreparedStatement prstmt = connection.prepareStatement(sql)) {
            prstmt.setDate(1, getDate());
            prstmt.setDouble(2, getPrix());
            prstmt.setString(3, getVoitureId());

            prstmt.executeUpdate();
        }
    }
}
