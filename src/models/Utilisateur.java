package models;
import java.util.Date;

public class Utilisateur {
    private int id;
    private String pseudo;
    private String motDePasse;
    private Date dateCreation;

    // Constructeur
    public Utilisateur(int id, String pseudo, String motDePasse, Date dateCreation) {
        this.id = id;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.dateCreation = dateCreation;
    }

    // Getters et Setters
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "pseudo='" + pseudo + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", dateCreation=" + dateCreation +
                '}';
    }
}
