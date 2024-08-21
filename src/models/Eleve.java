package models;

import java.util.Date;

public class Eleve extends Personne {
    private String classe;
    private String matricule;

    // Constructeur
    public Eleve(int id, String nom, String prenom, Date dateNaissance, String classe, String matricule) {
        super(id, nom, prenom, dateNaissance);
        this.classe = classe;
        this.matricule = matricule;
    }

    // Getters et Setters
    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }


    @Override
    public String toString() {
        return "Eleve{" +
                "Nom='" + getNom() + '\'' +
                ", Prenom='" + getPrenom() + '\'' +
                ", Date Naissance='" + getDateNaissance() + '\'' +
                ", Classe='" + classe + '\'' +
                ", Matricule='" + matricule + '\'' +
                '}';
    }
}
