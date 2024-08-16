package dao;

import models.Professeur;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public interface IProfesseurDao {

    public Professeur ajouter(Professeur professeur);
    public void modifier(Professeur professeur  );
    public boolean supprimer(int identifiant);
    public List<Professeur> listeProfesseur();
    public void obtenirProfesseur(int identifiant);

}
