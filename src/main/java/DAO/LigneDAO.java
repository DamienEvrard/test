package DAO;


import Entities.Ligne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;

/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author flo
 */
public class LigneDAO {
    
        private final DataSource myDataSource;
        
        /**
	 * Construit le AO avec sa source de données
	 * @param dataSource la source de données à utiliser
	 */
	public LigneDAO(DataSource dataSource) {
		this.myDataSource = dataSource;
	}
        
        /**
	 * Contenu de la table Commande
	 * @return Liste des commandes
	 * @throws SQLException renvoyées par JDBC
	 */
	public List<Ligne> allLignes() throws SQLException {

		List<Ligne> result = new LinkedList<>();

		String sql = "SELECT * FROM Ligne ORDER BY Commande";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int Commande = rs.getInt("Commande");
				int Produit = rs.getInt("Produit");
				Ligne c = new Ligne(Commande, Produit,0);
				result.add(c);
			}
		}
		return result;
	}
        
        /**
	 * Affiche la Ligne d'une commande
         * @param commande
	 * @return Ligne de la commande
	 * @throws SQLException renvoyées par JDBC
	 */
	public Ligne getLigne(int commande) throws SQLException {

		Ligne result=null;

		String sql = "SELECT * FROM Ligne WHERE Commande=?";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setInt(1, commande);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int Commande = rs.getInt("Commande");
				int Produit = rs.getInt("Produit");
				Ligne c = new Ligne(Commande, Produit,0);
				result=c;
			}
		}
		return result;
	}
        
}
