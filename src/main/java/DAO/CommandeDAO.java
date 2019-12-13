package DAO;

import Entities.Commande;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;



public class CommandeDAO {

	private final DataSource myDataSource;

	/**
	 * Construit le AO avec sa source de données
	 * @param dataSource la source de données à utiliser
	 */
	public CommandeDAO(DataSource dataSource) {
		this.myDataSource = dataSource;
	}

	/**
	 * Contenu de la table Commande
	 * @return Liste des commandes
	 * @throws SQLException renvoyées par JDBC
	 */
	public List<Commande> allCommande() throws SQLException {

		List<Commande> result = new LinkedList<>();

		String sql = "SELECT * FROM Commande ORDER BY Numero";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int Numero = rs.getInt("Numero");
				String Client = rs.getString("Client");
				Commande c = new Commande(Numero, Client, null, null, null, null, null, null, null, null, null, null);
				result.add(c);
			}
		}
		return result;
	}
        
        /**
	 * Affiche la commande faite pas un client
         * @param client
	 * @return Commande du client
	 * @throws SQLException renvoyées par JDBC
	 */
	public Commande getCommande(String client) throws SQLException {

		Commande result=null;

		String sql = "SELECT * FROM Commande WHERE Client=?";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setString(1, client);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int Numero = rs.getInt("Numero");
				String Client = rs.getString("Client");
				Commande c = new Commande(Numero, Client, null, null, null, null, null, null, null, null, null, null);
				result=c;
			}
		}
		return result;
	}
        
        
        /**
	 * compte le nombre de commande par categorie sur une page donnee
         * @param dateDeb debut de la plage a rechercher
         * @param dateFin fin de la plage a rechercher
	 * @return une hashmap <String, Integer>
	 * @throws SQLException renvoyées par JDBC
	 */
	public Map<String, Integer> getNBCommandeParCateg(String dateDeb, String dateFin) throws SQLException {

		Map<String, Integer> result=new HashMap<String, Integer>();

		String sql = "SELECT count(distinct Numero) as NB, Ca.LIBELLE as nom FROM Produit P , Categorie Ca, Commande Co, Ligne L WHERE Co.numero=L.commande and L.produit=P.reference and P.categorie=Ca.code and Saisie_le between ? and ? group by Ca.LIBELLE";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setString(1, dateDeb);
                        stmt.setString(2, dateFin);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int nb = rs.getInt("NB");
				String cate = rs.getString("nom");
				result.put(cate, nb);
			}
		}
		return result;
	}
        
        
        /**
	 * compte le nombre de commande par pays sur une page donnee
         * @param dateDeb debut de la plage a rechercher
         * @param dateFin fin de la plage a rechercher
	 * @return une hashmap <String, Integer>
	 * @throws SQLException renvoyées par JDBC
	 */
	public Map<String, Integer> getNBCommandeParPays (String dateDeb, String dateFin) throws SQLException {

		Map<String, Integer> result=new HashMap<String, Integer>();

		String sql = "SELECT count(distinct Numero) as NB, C.PAYS as pays FROM Client C , Commande Co WHERE C.CODE=Co.CLIENT and Saisie_le between ? and ? group by C.PAYS";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setString(1, dateDeb);
                        stmt.setString(2, dateFin);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int nb = rs.getInt("NB");
				String cate = rs.getString("PAYS");
				result.put(cate, nb);
			}
		}
		return result;
	}
        
        /**
	 * compte le nombre de commande par client sur une page donnee
         * @param dateDeb debut de la plage a rechercher
         * @param dateFin fin de la plage a rechercher
	 * @return une hashmap <String, Integer>
	 * @throws SQLException renvoyées par JDBC
	 */
	public Map<String, Integer> getNBCommandeParClient (String dateDeb, String dateFin) throws SQLException {

		Map<String, Integer> result=new HashMap<String, Integer>();

		String sql = "SELECT count(distinct Numero) as NB, C.CONTACT as nom FROM Client C , Commande Co WHERE C.CODE=Co.CLIENT and Saisie_le between ? and ? group by C.CONTACT";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setString(1, dateDeb);
                        stmt.setString(2, dateFin);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int nb = rs.getInt("NB");
				String cate = rs.getString("nom");
				result.put(cate, nb);
			}
		}
		return result;
	}
        
        
        /**
	 * ajoute une commande a la base donnee
         * @param com la commande a ajouter
	 * @throws SQLException renvoyées par JDBC
	 */
	public void addCommande (Commande com) throws SQLException {
            
                String sql1 = "SELECT max(Numero) as NB FROM Commande Co";
                int numero=0;
                try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql1)) {
                    
                    ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                            int nb = rs.getInt("NB");
                            numero=nb+1;
			}
                }
		

		String sql2 = "insert into commande values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql2)) {
                        stmt.setInt(1, numero);
                        stmt.setString(2, com.getClient());
                        stmt.setString(3, com.getSaisie_le());
                        stmt.setString(4, com.getEnvoyee_le());
                        stmt.setDouble(5, com.getPort());
                        stmt.setString(6, com.getDestinataire());
                        stmt.setString(7, com.getAdresse_livraison());
                        stmt.setString(8, com.getVille_livraison());
                        stmt.setString(9, com.getRegion_livraison());
                        stmt.setString(10, com.getCode_Postal_livrais());
                        stmt.setString(11, com.getPays_Livraison());
                        stmt.setDouble(12, com.getRemise());
			stmt.executeUpdate();
		}
	}
        
        /**
	 * compte le nombre de commande par client
	 * @return une hashmap <String, Integer>
	 * @throws SQLException renvoyées par JDBC
	 */
	public Map<String, Integer> getNBAllCommandeParClient () throws SQLException {

		Map<String, Integer> result=new HashMap<String, Integer>();

		String sql = "select client, count(numero) as NB from COMMANDE group by client";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int nb = rs.getInt("NB");
				String cli = rs.getString("client");
				result.put(cli, nb);
			}
		}
		return result;
	}
        
        
         public HashMap totalForCustomer(String date1, String date2) throws Exception{
            String sql="SELECT NAME, SUM(SHIPPING_COST+PURCHASE_COST * QUANTITY) AS TOTAL FROM CUSTOMER INNER JOIN PURCHASE_ORDER USING (CUSTOMER_ID) INNER JOIN PRODUCT ON PRODUCT.PRODUCT_ID=PURCHASE_ORDER.PRODUCT_ID AND (PURCHASE_ORDER.SALES_DATE BETWEEN ? AND ?) GROUP BY NAME";
            HashMap<String,Integer> client = new HashMap<>();
            
             try (Connection connection = myDataSource.getConnection();
		PreparedStatement stmt = connection.prepareStatement(sql)){
                stmt.setString(1, date1);
                stmt.setString(2, date2);
		try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) { 
			String id =rs.getString("NAME");
                        int mel = rs.getInt("SHIPPING_COST");
                        client.put(id, mel);
                    }
		}
                return client;
            }
            
            catch (SQLException ex) {
		Logger.getLogger("CommandeDAO").log(Level.SEVERE, null, ex);
		throw new Exception(ex.getMessage());
            }    
        }
        
        
        
        
        
        
        
        
        
//	/**     
//	 * Ajout d'un enregistrement dans la table DISCOUNT_CODE
//	 * @param code le code (non null)
//	 * @param rate le taux (positive or 0)
//	 * @return 1 si succès, 0 sinon
//	 * @throws SQLException renvoyées par JDBC
//	 */
//	public int addDiscountCode(String code, float rate) throws SQLException {
//		int result = 0;
//		String sql = "INSERT INTO DISCOUNT_CODE VALUES (?, ?)";
//		try (Connection connection = myDataSource.getConnection(); 
//		     PreparedStatement stmt = connection.prepareStatement(sql)) {
//			stmt.setString(1, code);
//			stmt.setFloat(2, rate);
//			result = stmt.executeUpdate();
//		}
//		return result;
//	}
//
//		
//	/**
//	 * Supprime un enregistrement dans la table DISCOUNT_CODE
//	 * @param code la clé de l'enregistrement à supprimer
//	 * @return le nombre d'enregistrements supprimés (1 ou 0)
//	 * @throws java.sql.SQLException renvoyées par JDBC
//	 **/
//	public int deleteDiscountCode(String code) throws SQLException {
//		int result = 0;
//		String sql = "DELETE FROM DISCOUNT_CODE WHERE DISCOUNT_CODE = ?";
//		try (Connection connection = myDataSource.getConnection(); 
//		     PreparedStatement stmt = connection.prepareStatement(sql)) {
//			stmt.setString(1, code);
//			result = stmt.executeUpdate();
//		}
//		return result;
//	}
        
}
