package DAO;

import Entities.Produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;



public class ProduitDAO {

	private final DataSource myDataSource;

	/**
	 * Construit le AO avec sa source de données
	 * @param dataSource la source de données à utiliser
	 */
	public ProduitDAO(DataSource dataSource) {
		this.myDataSource = dataSource;
	}
        
        public List<Produit> allProducts(){
            
            List<Produit> products = new ArrayList<Produit>();
            
            Produit p = new Produit("Produit1");
            Produit p2 = new Produit("Produit2");
            products.add(p);
            products.add(p);
            return products;
            //Tout les produit à recuperer 
            //A completer
        }

	       /**
         * 
         */
        public List<Produit> allProduit() throws SQLException{
            List<Produit> result = new LinkedList<>();
            String sql = "SELECT * FROM Produit";
            try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                            int Reference = rs.getInt("Reference");
                            String Nom = rs.getString("Nom");
                            int Fournisseur = rs.getInt("Fournisseur");
                            int Categorie = rs.getInt("Categorie");
                            String Quantite_Par_Unite = rs.getString("Quantite_Par_Unite");
                            float Prix_unitaire = rs.getFloat("Prix_Unitaire");
                            int Unites_en_Stock = rs.getInt("Unites_en_Stock");
                            int Unites_commandees = rs.getInt("Unites_commandees");
                            int Niveau_de_reappro = rs.getInt("Niveau_de_reappro");
                            int Indisponible = rs.getInt("Indisponible");
                            Produit p = new Produit(Reference, Nom, Fournisseur, Categorie, Quantite_Par_Unite, Prix_unitaire, Unites_en_Stock, Unites_commandees, Niveau_de_reappro, Indisponible);
                            result.add(p);
			}
		}catch(SQLException e){
                    throw  e;
                }
            
		return result;
	}
        
        
        
        
        
        /**
	 * Produit en fonction de sa reference
	 * @return Produit
	 * @throws SQLException renvoyées par JDBC
	 */
	public Produit getProduit(int reference) throws SQLException {

		Produit result=null;

		String sql = "SELECT * FROM Produit WHERE reference=?";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setInt(1, reference);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                            String Nom = rs.getString("Nom");
                            int Fournisseur = rs.getInt("Fournisseur");
                            int Categorie = rs.getInt("Categorie");
                            String Quantite_Par_Unite = rs.getString("Quantite_Par_Unite");
                            float Prix_unitaire = rs.getFloat("Prix_Unitaire");
                            int Unites_en_Stock = rs.getInt("Unites_en_Stock");
                            int Unites_commandees = rs.getInt("Unites_commandees");
                            int Niveau_de_reappro = rs.getInt("Niveau_de_reappro");
                            int Indisponible = rs.getInt("Indisponible");
                            Produit p = new Produit(reference, Nom, Fournisseur, Categorie, Quantite_Par_Unite, Prix_unitaire, Unites_en_Stock, Unites_commandees, Niveau_de_reappro, Indisponible);
                            result = p;
			}
		} catch(Exception e){
                    throw e;
                }
		return result;
	}
        
        /**
	 * Produit en fonction de sa reference
	 * @return Produit
	 * @throws SQLException renvoyées par JDBC
	 */
	public Produit getProduitByName(String name) throws SQLException {

		Produit result=null;

		String sql = "SELECT * FROM Produit WHERE Nom=?";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                            int Reference = rs.getInt("Reference");
                            int Fournisseur = rs.getInt("Fournisseur");
                            int Categorie = rs.getInt("Categorie");
                            String Quantite_Par_Unite = rs.getString("Quantite_Par_Unite");
                            float Prix_unitaire = rs.getFloat("Prix_Unitaire");
                            int Unites_en_Stock = rs.getInt("Unites_en_Stock");
                            int Unites_commandees = rs.getInt("Unites_commandees");
                            int Niveau_de_reappro = rs.getInt("Niveau_de_reappro");
                            int Indisponible = rs.getInt("Indisponible");
                            Produit p = new Produit(Reference, name, Fournisseur, Categorie, Quantite_Par_Unite, Prix_unitaire, Unites_en_Stock, Unites_commandees, Niveau_de_reappro, Indisponible);
                            result = p;
			}
		} catch(Exception e){
                    throw e;
                }
		return result;
	}

        
        public void ajoutProduit(String nom,int reference, int fournisseur, int categorie,
                                    String Quantite_Par_Unite, float Prix_unitaire, int Unites_en_Stock, 
                                    int Unites_commandees, int Niveau_de_reappro, int Indisponible) throws SQLException {
            int num = 0;
            String sql1 = "SELECT max(REFERENCE) as REFERENCE FROM Produit";
            try (Connection connection = myDataSource.getConnection(); 
                PreparedStatement stmt = connection.prepareStatement(sql1)) {

                ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                        int nb = rs.getInt("REFERENCE");
                        num=nb+1;
                    }
            }
            
            String sql = "insert INTO Produit VALUES(?,?,?,?,?,?,?,?,?,?)";
            try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(2,nom);
                stmt.setInt(1,num);
                stmt.setInt(3,fournisseur);
                stmt.setInt(4,categorie);
                stmt.setString(5,Quantite_Par_Unite);
                stmt.setFloat(6,Prix_unitaire);
                stmt.setInt(7,Unites_en_Stock);
                stmt.setInt(8,Unites_commandees);
                stmt.setInt(9,Niveau_de_reappro);
                if( Unites_en_Stock > 0){
                    stmt.setInt(10,0);
                } else {
                    stmt.setInt(10,1);
                }
                stmt.executeUpdate();
            } catch(Exception e){
                throw e;
            }
        }
        
        public void updateProduit(String nom,int reference, int fournisseur, int categorie,
                                    String Quantite_Par_Unite, float Prix_unitaire, int Unites_en_Stock, 
                                    int Unites_commandees, int Niveau_de_reappro, int Indisponible) throws SQLException {

            String sql = "update produit set reference=?,nom=?,fournisseur=?,categorie=?,quantite_par_unite=?,prix_unitaire=?,unites_en_stock=?,unites_commandees=?,niveau_de_reappro=?,indisponible=? where reference=?";
            
            try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(2,nom);
                stmt.setInt(1,reference);
                stmt.setInt(3,fournisseur);
                stmt.setInt(4,categorie);
                stmt.setString(5,Quantite_Par_Unite);
                stmt.setFloat(6,Prix_unitaire);
                stmt.setInt(7,Unites_en_Stock);
                stmt.setInt(8,Unites_commandees);
                stmt.setInt(9,Niveau_de_reappro);
                if( Unites_en_Stock > 0){
                    stmt.setInt(10,0);
                } else {
                    stmt.setInt(10,1);
                }
                stmt.setInt(11,reference);
                stmt.executeUpdate();
            } catch(Exception e){
                throw e;
            }
        }
        
        
        public void supprProduit(int reference)throws SQLException{
            String sql = "DELETE FROM PRODUIT WHERE REFERENCE = ?";
            try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, reference);
                stmt.executeUpdate();   
            } catch (Exception e){
                throw e;
            }
        }
        
        
        
        
        
        /**
	 * Produit en fonction de sa reference
	 * @return Produit
	 * @throws SQLException renvoyées par JDBC
	 */
	 public List<Produit> getProduitByCategorie(int categorie) throws SQLException{
            List<Produit> result = new LinkedList<>();
            String sql = "SELECT * FROM Produit where categorie=?";
            try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setInt(1, categorie);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                            int Reference = rs.getInt("Reference");
                            String Nom = rs.getString("Nom");
                            int Fournisseur = rs.getInt("Fournisseur");
                            int Categorie = rs.getInt("Categorie");
                            String Quantite_Par_Unite = rs.getString("Quantite_Par_Unite");
                            float Prix_unitaire = rs.getFloat("Prix_Unitaire");
                            int Unites_en_Stock = rs.getInt("Unites_en_Stock");
                            int Unites_commandees = rs.getInt("Unites_commandees");
                            int Niveau_de_reappro = rs.getInt("Niveau_de_reappro");
                            int Indisponible = rs.getInt("Indisponible");
                            Produit p = new Produit(Reference, Nom, Fournisseur, Categorie, Quantite_Par_Unite, Prix_unitaire, Unites_en_Stock, Unites_commandees, Niveau_de_reappro, Indisponible);
                            result.add(p);
			}
		}catch(SQLException e){
                    throw  e;
                }
            
		return result;
	}


}
