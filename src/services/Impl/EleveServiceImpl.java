package services.Impl;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import dao.IEleveDao;
import dao.Impl.EleveDaoImpl;
import models.Eleve;
import services.IEleveService;

import static dao.SingletonDataBase.connection;


public class EleveServiceImpl implements IEleveService {
    private static final Scanner scanner = new Scanner(System.in);
    private IEleveDao eleveDao;

    public EleveServiceImpl(Connection connection) {
        this.eleveDao = new EleveDaoImpl();
    }


    @Override
    public Eleve add(Eleve eleve) {
        return eleveDao.ajouter(eleve);
    }

    @Override
    public void update(Eleve eleve) {

    }

    @Override
    public boolean delete(int id) {
        return eleveDao.supprimer(id);
    }

    @Override
    public List<Eleve> getAll() {
        return eleveDao.listeEleve();
    }

    @Override
    public void getOne(int id) {

    }


    public static void gestionEleve(){

        boolean repeat = true;

        while (repeat) {
            menuEleve();

            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    ajouterEleve();
                    repeat = false;
                    break;
                case 2:
                    supprimerEleve();
                    break;
                case 3:
                    System.out.println("Vous avez choisi l'option 3 : vous souhaitez Modifier les informations d'un élève.");
//                    eleve.modifier(null);
                    break;
                case 4:
                    System.out.println("Vous avez choisi l'option 4 : vous souhaitez voir la liste des élèves.\n");
                    listerEleve();
                    break;
                case 5:
                    System.out.println("Menu précédent !\n");
//                    gestionPrincip();
                    repeat = false; // Pour sortir du sous-menu des élèves
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




    // AJOUTER LA METHODE AJOUTERELEVE
    public static void ajouterEleve() {
        EleveServiceImpl eleveService = new EleveServiceImpl(connection);

        boolean nouvElev = true;
        while (nouvElev) {
            System.out.println("Vous avez choisi l'option 1 : ajouter un élève.");

            System.out.println("Veuillez entrer le nom de l'élève :");
            String nom = scanner.nextLine();

            System.out.println("Veuillez entrer le prénom de l'élève :");
            String prenom = scanner.nextLine();

            Date dateNaissance = null;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);

            boolean validDate = false;
            while (!validDate) {
                System.out.println("Veuillez entrer la date de naissance de l'élève (dd/MM/yyyy) :");
                String dateNaissanceString = scanner.nextLine();

                try {
                    dateNaissance = dateFormat.parse(dateNaissanceString);
                    validDate = true; // Date est valide
                } catch (ParseException e) {
                    System.out.println("Format de date invalide. Veuillez entrer une date au format dd/MM/yyyy.");
                }
            }

            System.out.println("Veuillez entrer la classe de l'élève :");
            String classe = scanner.nextLine();

            System.out.println("Veuillez entrer le matricule de l'élève :");
            String matricule = scanner.nextLine();

            Eleve nouvelEleve = new Eleve(0, nom, prenom, dateNaissance, classe, matricule);
            Eleve eleveAjoute = eleveService.add(nouvelEleve);

            if (eleveAjoute != null) {
                System.out.println("Nouvel élève ajouté avec succès : " + eleveAjoute);
            } else {
                System.out.println("Erreur lors de l'ajout de l'élève.");
            }

            System.out.println("Souhaitez-vous ajouter un nouvel élève ? (Oui/Non)");
            String suite = scanner.nextLine().trim();  // trim() pour enlever les espaces en trop
            nouvElev = suite.equalsIgnoreCase("oui");

            if (!nouvElev) {
                System.out.println("Retour au menu des élèves.");
            }
        }
    }





    public static void supprimerEleve() {
        EleveServiceImpl eleveService = new EleveServiceImpl(connection);
        System.out.println("Vous avez choisi l'option 2 : vous souhaitez supprimer un élève.");
        System.out.println("Veuillez entrer l'ID de l'élève à supprimer :");
        int id = scanner.nextInt();
        scanner.nextLine();  // Pour consommer la ligne restante

        boolean eleveSupprime = eleveService.delete(id);

        if (eleveSupprime) {
            System.out.println("Élève avec l'ID " + id + " supprimé avec succès !");
        } else {
            System.out.println("Erreur lors de la suppression de l'élève avec l'ID " + id + ". Veuillez vérifier si cet ID existe.");
        }
    }




    public static void  modifierEleve(){

    }




    public static void listerEleve() {
        EleveServiceImpl eleveService = new EleveServiceImpl(connection);

        System.out.println("Vous avez choisi l'option 4 : lister tous les élèves.");

        List<Eleve> eleves = eleveService.getAll();

        if (eleves.isEmpty()) {
            System.out.println("Aucun élève trouvé.");
        } else {
            System.out.println("Liste des élèves :");
            for (Eleve eleve : eleves) {
                System.out.println(eleve);
            }
        }
    }































    public static void menuEleve() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm");
        String formattedDate = myDateObj.format(myFormatObj);

        System.out.println("******************************************************\n" +
                "          GESTION DES ELEVES  \n" +
                "******************************************************\n" +
                "MENU:\n" +
                "1: Ajouter un élève\n" +
                "2: Supprimer un élève\n" +
                "3: Modifier les informations de l'élève\n" +
                "4: Lister les élèves\n" +
                "5: Retour\n" +
                "0: Accueil "  + formattedDate);
    }



}
