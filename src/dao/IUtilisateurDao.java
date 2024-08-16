package dao;


import models.Utilisateur;

import java.util.List;

public interface IUtilisateurDao {

    boolean auth(String identifiant, String motDePasse);

    boolean ajouterCompte(String identifiant , String motDePasse);

    boolean modifierMotDePasse(String identifiant , String motDePassa);

    boolean supprimerCompte(String identifiant , String motDePasse);

    List<Utilisateur> listerUtilisateurs();

    void ajouterUtilisateurParDefaut();

}
