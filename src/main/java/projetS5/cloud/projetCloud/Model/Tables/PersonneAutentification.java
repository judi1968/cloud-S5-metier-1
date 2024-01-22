package projetS5.cloud.projetCloud.Model.Tables;

public class PersonneAutentification extends Personne{
    String email;
    String motPasse;
    Boolean isAdmin;
    String personneId;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getPersonneId() {
        return personneId;
    }

    public void setPersonneId(String personneId) {
        this.personneId = personneId;
    }

    public PersonneAutentification(String id) {
        super(id);
    }

}
