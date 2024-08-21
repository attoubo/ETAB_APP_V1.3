package dao.Impl;

import dao.IEleveDao;
import dao.SingletonDataBase;
import models.Eleve;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EleveDaoImpl implements IEleveDao {

    Connection connection = SingletonDataBase.getInstance();



    @Override
    public Eleve ajouter(Eleve eleve) {
        String query = "INSERT INTO eleve (nom, prenom, dateNaissance, classe, matricule) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, eleve.getNom());
            ps.setString(2, eleve.getPrenom());
            ps.setDate(3, new java.sql.Date(eleve.getDateNaissance().getTime())); // Utilisez java.sql.Date pour les dates
            ps.setString(4, eleve.getClasse());
            ps.setString(5, eleve.getMatricule());
            ps.executeUpdate();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    eleve.setId(generatedKeys.getInt(1)); // Définir l'ID généré pour l'élève
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return eleve;
    }

    @Override
    public void modifier(Eleve eleve) {
        String query = "UPDATE eleve SET nom = ?, prenom = ?, classe = ?, matricule = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, eleve.getNom());
            ps.setString(2, eleve.getPrenom());
            ps.setString(3, eleve.getClasse());
            ps.setString(4, eleve.getMatricule());
            ps.setInt(5, eleve.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean supprimer(int id) {
        String query = "DELETE FROM eleve WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Eleve> listeEleve() {
        String QUERY = "SELECT * FROM eleve";
        List<Eleve> eleves = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY)) {

            while (rs.next()) {
                // Utilisation du constructeur avec paramètres
                Eleve eleve = new Eleve(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getDate("dateNaissance"),  // Date de naissance
                        rs.getString("classe"),
                        rs.getString("matricule")
                );
                eleves.add(eleve);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eleves;
    }


    @Override
    public Eleve obtenirEleve(int id) {
        String query = "SELECT * FROM eleves WHERE id = ?";
        Eleve eleve = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {  // Le PreparedStatement est créé ici
            ps.setInt(1, id);  // Le paramètre est défini ici
            try (ResultSet rs = ps.executeQuery()) {  // Le ResultSet est obtenu ici
                if (rs.next()) {
                    eleve = new Eleve(
                            rs.getInt("id"),
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getDate("dateNaissance"),  // Assurez-vous que cette colonne existe
                            rs.getString("classe"),
                            rs.getString("matricule")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eleve;
    }

}
