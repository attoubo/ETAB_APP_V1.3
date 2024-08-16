package dao.Impl;

import dao.SingletonDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

public class UtilisateurDaoImpl {

    // Obtenir la connexion depuis SingletonDataBase
    Connection connection = SingletonDataBase.getInstance();
    public UtilisateurDaoImpl() {
        this.connection = SingletonDataBase.getInstance();
    }


    public void ajouterUtilisateurParDefaut() {
        String CHECKQUERY = "SELECT COUNT(*) FROM utilisateur WHERE pseudo = ?";
        String INSERTQUERY = "INSERT INTO utilisateur (pseudo, motDePasse) VALUES (?, ?)";

        try (PreparedStatement checkPs = connection.prepareStatement(CHECKQUERY)) {
            checkPs.setString(1, "admin");
            ResultSet rs = checkPs.executeQuery();

            if (rs.next() && rs.getInt(1) == 0) {
                try (PreparedStatement insertPs = connection.prepareStatement(INSERTQUERY)) {
                    insertPs.setString(1, "admin");
                    insertPs.setString(2, "admin");
                    insertPs.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public boolean auth(String identifiant, String motDePasse) {
        String query = "SELECT COUNT(*) FROM utilisateur WHERE pseudo = ? AND motDePasse = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, identifiant);
            ps.setString(2, motDePasse);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next() && rs.getInt(1) == 1) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }





}
