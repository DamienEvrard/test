package DAO;

import Entities.Categorie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;



public class CategorieDAO {

	private final DataSource myDataSource;

	/**
	 * Construit le AO avec sa source de données
	 * @param dataSource la source de données à utiliser
	 */
	public CategorieDAO(DataSource dataSource) {
		this.myDataSource = dataSource;
	}

	/**
	 * Contenu de la table Cleint
	 * @return Liste des clent
	 * @throws SQLException renvoyées par JDBC
	 */
	public List<Categorie> allCategorie() throws SQLException {

		List<Categorie> result = new LinkedList<>();

		String sql = "SELECT * FROM Categorie ORDER BY Code";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int code = rs.getInt("Code");
				String libelle = rs.getString("Libelle");
                                String description = rs.getString("Description");
				Categorie c = new Categorie(code, libelle, description);
				result.add(c);
			}
		}
		return result;
	}
        
        /**
	 * Contenu de la table Client
	 * @return Liste des clent
	 * @throws SQLException renvoyées par JDBC
	 */
	public Categorie getCategorie(String libelle) throws SQLException {

		Categorie result=null;

		String sql = "SELECT * FROM Categorie WHERE Libelle=?";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setString(1, libelle);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int Code = rs.getInt("Code");
				String Libelle = rs.getString("Libelle");
				String Description = rs.getString("Description");
				Categorie c = new Categorie(Code, Libelle, Description);
				result=c;
			}
		}
                if (result==null){
                   throw new SQLException("categorie introuvable");
                }
                
		return result;
	}


}
