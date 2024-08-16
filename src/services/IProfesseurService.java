package services;

import models.Professeur;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public interface IProfesseurService {

    public Professeur add(Professeur professeur );
    public void update(Professeur professeur  );
    public boolean delete(int identifiant);
    public List<Professeur> getAll();
    public void getOne(int identifiant);

}
