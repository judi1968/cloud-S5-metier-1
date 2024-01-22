package projetS5.cloud.projetCloud.Model.Tables;

import java.sql.Date;

public class Personne {
    String id;
    String nom;
    String prenom;
    String address;
    Date dateNaissance;
    int telephone;
    int sex;

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

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
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
}
