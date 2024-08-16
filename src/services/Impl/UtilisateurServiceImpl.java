package services.Impl;

import dao.Impl.UtilisateurDaoImpl;
import dao.SingletonDataBase;
import models.Eleve;
import models.Utilisateur;
import services.IUtilisateurService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static dao.SingletonDataBase.connection;

public class UtilisateurServiceImpl implements IUtilisateurService {


    private UtilisateurDaoImpl utilisateurDao;

    public UtilisateurServiceImpl() {
        // Obtenir la connexion depuis SingletonDataBase
        Connection connection = SingletonDataBase.getInstance();
        this.utilisateurDao = new UtilisateurDaoImpl(); // Initialisation correcte de l'implémentation DAO
    }






    public void ajouterUtilisateurParDefaut() {
        utilisateurDao.ajouterUtilisateurParDefaut(); // Utilisation de l'instance correctement initialisée
    }



    @Override
    public boolean addCompte(String identifiant, String motDePasse) {
        return false;
    }

    @Override
    public boolean updateMotDePasse(String identifiant, String motDePassa) {
        return false;
    }

    @Override
    public boolean deleteCompte(String identifiant, String motDePasse) {
        return false;
    }


    @Override
    public boolean authentification(String identifiant, String motDePasse) {
        return utilisateurDao.auth(identifiant, motDePasse);
    }


    public static void connexion(){
        menuConnexion();

        Scanner scanner = new Scanner(System.in);
        UtilisateurServiceImpl utilisateurService = new UtilisateurServiceImpl();

        System.out.println("Veuillez entrer votre identifiant:");
        String identifiant = scanner.nextLine();

        System.out.println("Veuillez entrer votre mot de passe:");
        String motDePasse = scanner.nextLine();

        boolean isAuthenticated = utilisateurService.utilisateurDao.auth(identifiant, motDePasse);


        if (isAuthenticated) {
            System.out.println("                 Accès autorisé. Bienvenue au menu principal.\n");
            // Call the main menu method here
        } else {
            System.out.println("Identifiant ou mot de passe incorrect.");
            System.exit(1);
        }
    }



    public static void menuConnexion() {
        System.out.println("""
                
                            
                                     BIENVENU DANS L’APPLICATION ETAB V1.3
                            
                                              CONNEXION
                """);
    }




    public static void menuPrincip() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm");
        String formattedDate = myDateObj.format(myFormatObj);

        System.out.println("******************************************************\n" +
                "          BIENVENU DANS L’APPLICATION ETAB V1.3\n" +
                "******************************************************\n" +
                "MENU :\n" +
                "1: Gestion des eleves \n" +
                "2: Gestion des professeurs \n" +
                "3: Gestion des utilisateurs \n" +
                "0: Quitter \n" +
                "Date systeme : " + formattedDate);
    }





    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return List.of();
    }


}
