package DAO;

import Entities.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;



public class ClientDAO {

	private final DataSource myDataSource;

	/**
	 * Construit le AO avec sa source de données
	 * @param dataSource la source de données à utiliser
	 */
	public ClientDAO(DataSource dataSource) {
		this.myDataSource = dataSource;
	}

	/**
	 * Contenu de la table Cleint
	 * @return Liste des clent
	 * @throws SQLException renvoyées par JDBC
	 */
	public List<Client> allClient() throws SQLException {

		List<Client> result = new LinkedList<>();

		String sql = "SELECT * FROM Client ORDER BY Code";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String Code = rs.getString("Code");
				String Contact = rs.getString("Contact");
				String Societe = rs.getString("Societe");
				String Fonction = rs.getString("Fonction");
				String Adresse = rs.getString("Adresse");
				String Ville = rs.getString("Ville");
				String Region = rs.getString("Region");
				String Code_Postal = rs.getString("Code_Postal");
				String Pays = rs.getString("Pays");
				String Telephone = rs.getString("Telephone");
				String Fax = rs.getString("Fax");
				Client c = new Client(Code, Contact, Societe, Fonction, Adresse, Ville, Region, Code_Postal, Pays, Telephone, Fax);
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
	public Client getClient(String contact) throws SQLException {

		Client result=null;

		String sql = "SELECT * FROM Client WHERE Contact=?";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setString(1, contact);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String Code = rs.getString("Code");
				String Contact = rs.getString("Contact");
				String Societe = rs.getString("Societe");
				String Fonction = rs.getString("Fonction");
				String Adresse = rs.getString("Adresse");
				String Ville = rs.getString("Ville");
				String Region = rs.getString("Region");
				String Code_Postal = rs.getString("Code_Postal");
				String Pays = rs.getString("Pays");
				String Telephone = rs.getString("Telephone");
				String Fax = rs.getString("Fax");
				Client c = new Client(Code, Contact, Societe, Fonction, Adresse, Ville, Region, Code_Postal, Pays, Telephone, Fax);
				result=c;
			}
		}
                if (result==null){
                   throw new SQLException("client introuvable");
                }
                
		return result;
	}

	/**
	 * Modification d'un enregistrement dans la table Client
	 */
	public void editClient(Client client, String Code, String Contact, String Societe, String Fonction, String Adresse, String Ville, String Region, String Code_Postal, String Pays, String Telephone, String Fax) throws SQLException {
		
            String sql = "UPDATE Client SET Code=?, Contact=?, Societe=?, Fonction=?, Adresse=?, Ville=?, Region=?, Code_Postal=?, Pays=?, Telephone=?, Fax=? WHERE Contact=?";
            
            if(Code==null){
                Code=client.getCode();
            }
            if(Contact==null){
                Contact=client.getContact();
            }
            if(Societe==null){
                Societe=client.getSociete();
            }
            if(Fonction==null){
                Fonction=client.getFonction();
            }
            if(Adresse==null){
                Adresse=client.getAdresse();
            }
            if(Ville==null){
                Ville=client.getVille();
            }
            if(Region==null){
                Region=client.getRegion();
            }
            if(Code_Postal==null){
                Code_Postal=client.getCode_Postal();
            }
            if(Pays==null){
                Pays=client.getPays();
            }
            if(Telephone==null){
                Telephone=client.getTelephone();
            }
            if(Fax==null){
                Fax=client.getFax();
            }
            
            try (Connection connection = myDataSource.getConnection(); 
                 PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setString(1, Code);
                    stmt.setString(2, Contact);
                    stmt.setString(3, Societe);
                    stmt.setString(4, Fonction);
                    stmt.setString(5, Adresse);
                    stmt.setString(6, Ville);
                    stmt.setString(7, Region);
                    stmt.setString(8, Code_Postal);
                    stmt.setString(9, Pays);
                    stmt.setString(10, Telephone);
                    stmt.setString(11, Fax);
                    stmt.setString(12, client.getContact());
                    stmt.executeUpdate();
            }
	}


}
