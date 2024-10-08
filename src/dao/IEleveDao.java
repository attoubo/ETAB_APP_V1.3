package dao;

import models.Eleve;

import java.util.List;

/**
 * dao.ICRUDEleve est une interface qui va nous permettre de definie les differentes methodes des crud
 */
public interface IEleveDao {

    public Eleve ajouter(Eleve eleve );
    public void modifier(Eleve eleve );
    public boolean supprimer(int id);
    public List<Eleve> listeEleve();
    public Eleve obtenirEleve(int id);

}