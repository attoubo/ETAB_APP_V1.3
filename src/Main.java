import dao.SingletonDataBase;
import services.Impl.EleveServiceImpl;
import services.Impl.UtilisateurServiceImpl;

import java.sql.Connection;
import java.util.Scanner;

import static services.Impl.UtilisateurServiceImpl.connexion;
import static services.Impl.UtilisateurServiceImpl.menuPrincip;


public class Main {
    public static void main(String[] args) {
        // Obtenir la connexion depuis SingletonDataBase
        UtilisateurServiceImpl utilisateurService = new UtilisateurServiceImpl();


        // Méthode pour ajouter un nouvel utilisateur
        utilisateurService.ajouterUtilisateurParDefaut();

        // Methode de gestion principale (eleves, professeurs, et utilisateurs)
        gestionPrincip();

    }





    /**
     *  La gestion principale pour les eleves, professeurs et utilisateurs
     */
    public static void gestionPrincip(){

        Scanner scanner = new Scanner(System.in);
        boolean repeat = true;

        // Methode pour verifier l'authentification
        connexion();

        menuPrincip();
        while (repeat){

            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    // Méthode pour gérer les élèves
                    EleveServiceImpl.gestionEleve();
                    repeat = false;
                    break;
                case 2:
                    System.out.println("Vous avez choisi l'option 2 : vous souhaitez gerer les professeurs");
                    // gestionProfesseur();
                    break;
                case 3:
                    System.out.println("Vous avez choisi l'option 3 : vous souhaitez gerer les utilisateurs");
                    // gestionUtilisateur();
                    break;
                case 0:
                    System.out.println("Aurevoir et a Bientot !");
                    repeat = false;
                    break;
                default:
                    System.out.println("Option invalide. Veuillez choisir une option valide.");
            }
        }
    }
}