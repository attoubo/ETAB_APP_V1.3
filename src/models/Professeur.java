package models;

import java.util.Date;

public class Professeur extends Personne {
    private boolean vacant;
    private String matiereEnseignee;
    private String prochainCours;
    private String sujetProchaineReunion;

    // Constructeur
    public Professeur(int id, String nom, String prenom, Date dateNaissance, String matiereEnseignee) {
        super(id, nom, prenom, dateNaissance);
        this.matiereEnseignee = matiereEnseignee;
    }

    // Getters et Setters
    public boolean isVacant() {
        return vacant;
    }

    public void setVacant(boolean vacant) {
        this.vacant = vacant;
    }

    public String getMatiereEnseignee() {
        return matiereEnseignee;
    }

    public void setMatiereEnseignee(String matiereEnseignee) {
        this.matiereEnseignee = matiereEnseignee;
    }

    public String getProchainCours() {
        return prochainCours;
    }

    public void setProchainCours(String prochainCours) {
        this.prochainCours = prochainCours;
    }

    public String getSujetProchaineReunion() {
        return sujetProchaineReunion;
    }

    public void setSujetProchaineReunion(String sujetProchaineReunion) {
        this.sujetProchaineReunion = sujetProchaineReunion;
    }


    @Override
    public String toString() {
        return "Professeur{" +
                "vacant=" + vacant +
                ", matiereEnseignee='" + matiereEnseignee + '\'' +
                ", prochainCours='" + prochainCours + '\'' +
                ", sujetProchaineReunion='" + sujetProchaineReunion + '\'' +
                '}';
    }
}
